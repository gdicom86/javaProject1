package com.myweb.www.api;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class KakaoLoginBO {

    /* 인증 요청문을 구성하는 파라미터 */
	//client_id: 애플리케이션 등록 후 발급받은 클라이언트 아이디
	//response_type: 인증 과정에 대한 구분값. code로 값이 고정돼 있습니다.
	//redirect_uri: 카카오 로그인 인증의 결과를 전달받을 콜백 URL(URL 인코딩). 애플리케이션을 등록할 때 Callback URL에 설정한 정보입니다.
	//state: 애플리케이션이 생성한 상태 토큰
	private final static String KAKAO_CLIENT_ID = "2235fbed823c1081e4a375924d75ebdb"; // 클라이언트 아이디
    private final static String KAKAO_CLIENT_SECRET = "5EjW3RJHugsOP47sakDZ4AYAjQeaF623"; // 클라이언트 시크릿
    private final static String KAKAO_REDIRECT_URI = "http://localhost:8088/user/callbackKakao";
    private final static String SESSION_STATE = "kakao_oauth_state";
    /* 프로필 조회 API URL */
    private final static String PROFILE_API_URL = "https://kapi.kakao.com/v2/user/me";
    
    /* 네이버 아이디로 인증  URL 생성  Method */
    public String getAuthorizationUrl(HttpSession session) {

        /* 세션 유효성 검증을 위하여 난수를 생성 */
        String state = generateRandomString();
        /* 생성한 난수 값을 session에 저장 */
        setSession(session,state);        

        /* Scribe에서 제공하는 인증 URL 생성 기능을 이용하여 카카오 인증 URL 생성 */
        OAuth20Service oauthService = new ServiceBuilder()                                                   
                .apiKey(KAKAO_CLIENT_ID)
                .apiSecret(KAKAO_CLIENT_SECRET)
                .callback(KAKAO_REDIRECT_URI)
                .state(state) //앞서 생성한 난수값을 인증 URL생성시 사용함
                .build(KakaoOAuthApi.instance());
        		// 네이버 서버와 통신하기 위해 생성한 KakaoOAuthApi 사용
        return oauthService.getAuthorizationUrl();
    }

    /* 카카오아이디로 Callback 처리 및  AccessToken 획득 Method */
    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws Exception{

        /* Callback으로 전달받은 세선검증용 난수값과 세션에 저장되어있는 값이 일치하는지 확인 */
        String sessionState = getSession(session);
        if(StringUtils.pathEquals(sessionState, state)){

            OAuth20Service oauthService = new ServiceBuilder()
                    .apiKey(KAKAO_CLIENT_ID)
                    .apiSecret(KAKAO_CLIENT_SECRET)
                    .callback(KAKAO_REDIRECT_URI)
                    .state(state)
                    .build(KakaoOAuthApi.instance());
            		// 카카오 서버와 통신하기 위해 생성한 KakaoOAuthApi 사용
            /* Scribe에서 제공하는 AccessToken 획득 기능으로 카카오 Access Token을 획득 */
            OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
            return accessToken;
        }
        return null;
    }

    /* Access Token을 이용하여 네이버 사용자 프로필 API를 호출 */
    public String getUserProfile(OAuth2AccessToken oauthToken) throws Exception{ 	
    	OAuth20Service oauthService =new ServiceBuilder()
    			.apiKey(KAKAO_CLIENT_ID)
    			.apiSecret(KAKAO_CLIENT_SECRET)
    			.callback(KAKAO_REDIRECT_URI).build(KakaoOAuthApi.instance());
    	// 카카오 서버와 통신하기 위해 생성한 KakaoOAuthApi 사용
    	OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
    	oauthService.signRequest(oauthToken, request);
    	Response response = request.send();
    	return response.getBody();
    }
    
    /* 세션 유효성 검증을 위한 난수 생성기 */
    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    /* http session에 데이터 저장 */
    private void setSession(HttpSession session,String state){
        session.setAttribute(SESSION_STATE, state);     
    }

    /* http session에서 데이터 가져오기 */ 
    private String getSession(HttpSession session){
        return (String) session.getAttribute(SESSION_STATE);
    }

}
