/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-12-04 09:39:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1685959055593L));
    _jspx_dependants.put("jar:file:/D:/Java/new_project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springproject/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageTitle }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</title>\r\n");
      out.write("<!-- font awesome -->\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/e927512ef5.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- CSS import -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/navigation.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/user/signUp.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/footer.css\">\r\n");
      out.write("<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/resources/js/user/signUp.js\" ></script>\r\n");
      out.write("<!-- JS import -->\r\n");
      out.write("<script defer type=\"text/javascript\" src=\"/resources/js/navigation.js\"></script>\r\n");
      out.write("<!-- SweetAlert2 -->\r\n");
      out.write("<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script> \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- navigation -->\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layouts/navigation.jsp", out, false);
      out.write("\r\n");
      out.write("	<div id=\"signUpContainer\">\r\n");
      out.write("		<h2>회원가입</h2>\r\n");
      out.write("		<form action=\"/user/signUp\" method=\"post\">\r\n");
      out.write("			<div id=\"signUpInput\">\r\n");
      out.write("				<p style=\"color: rgb(0,102,51); font-weight: bold;\">Welcome!</p>\r\n");
      out.write("				<p style=\"color: rgb(190,190,205); font-weight: bold;\">부동산 코리아에 오신 것을 환영합니다.</p>\r\n");
      out.write("				<div class=\"hrDiv\">\r\n");
      out.write("					<hr>\r\n");
      out.write("				</div>			\r\n");
      out.write("				<input type=\"text\" id=\"id_input\" name=\"id\" placeholder=\"영문이나 영문 숫자를 조합하여 4~12자 아이디를 입력해 주세요.\" maxlength=\"12\" oninput=\"delayedCheckId()\"> <br>\r\n");
      out.write("				<!-- id 중복체크 -->\r\n");
      out.write("				<span class=\"id_ok\">사용 가능한 아이디입니다.</span>\r\n");
      out.write("				<span class=\"id_already\">이미 사용중인 아이디입니다.</span>\r\n");
      out.write("				<span class=\"id_error\">영문이나 영문 숫자를 조합한 4~12자 아이디가 필요합니다.</span>\r\n");
      out.write("				<input type=\"password\" id=\"pw_input\" name=\"pw\" placeholder=\"비밀번호를 입력해 주세요. ( 8자리 이상 영문 대소문자, 숫자, 특수문자가 각 1개 이상 )\" maxlength=\"18\" oninput=\"delayedCheckPw()\"> <br>\r\n");
      out.write("				<span class=\"pw_ok\">사용 가능한 패스워드입니다.</span>\r\n");
      out.write("				<span class=\"pw_error\">최소 8자리 이상 영문 대소문자, 숫자, 특수문자가 각 1개 이상 필요합니다.</span>\r\n");
      out.write("				<input type=\"password\" id=\"pw_confirm\" name=\"pw_confirm\" placeholder=\"비밀번호를 재입력해 주세요.\" onblur=\"confirmPw()\"> <br>\r\n");
      out.write("				<span class=\"pw_confirm_ok\">일치하는 비밀번호입니다.</span>\r\n");
      out.write("				<span class=\"pw_confirm_error\">비밀번호를 다시 확인해 주세요.</span>\r\n");
      out.write("				<input type=\"text\" id=\"name_input\" name=\"name\" placeholder=\"이름 ( 한글 또는 영어 )\" onblur=\"confirmName()\"> <br>\r\n");
      out.write("				<span class=\"name_error\">형식에 맞는 이름을 입력해 주세요.</span>\r\n");
      out.write("				<div id=\"addressDiv\">\r\n");
      out.write("					<div class=\"horizontal\">			\r\n");
      out.write("	   					<input type=\"text\" name=\"address_postcode\" readonly=\"readonly\" placeholder=\"우편번호\">\r\n");
      out.write("	   					<input type=\"button\" value=\"주소검색\" onclick=\"exePost()\">	\r\n");
      out.write("	   					<span class=\"address_error\">&nbsp;&nbsp; * 주소를 입력해 주세요.</span>\r\n");
      out.write("	   				</div>	\r\n");
      out.write("					<div class=\"vertical\">\r\n");
      out.write("					    <input type=\"text\" id=\"address_primary\" name=\"address_primary\" readonly=\"readonly\" placeholder=\"기본주소\">\r\n");
      out.write("					    <input type=\"text\" name=\"address_detail\" placeholder=\"나머지 주소(선택 사항)\">\r\n");
      out.write("  					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div id=\"phoneDiv\">\r\n");
      out.write("					<input type=\"hidden\" name=\"phone\" placeholder=\"전화번호\">\r\n");
      out.write("					<select id=\"phoneNum1\">\r\n");
      out.write("						<option value=\"010\">010</option>\r\n");
      out.write("						<option value=\"011\">011</option>\r\n");
      out.write("						<option value=\"016\">016</option>\r\n");
      out.write("						<option value=\"017\">017</option>\r\n");
      out.write("						<option value=\"018\">018</option>\r\n");
      out.write("						<option value=\"019\">019</option>\r\n");
      out.write("					</select>\r\n");
      out.write("					- <input type=\"number\" id=\"phoneNum2\" maxlength=\"4\" oninput=\"maxLengthCheck(this)\">\r\n");
      out.write("		    		- <input type=\"number\" id=\"phoneNum3\" maxlength=\"4\" oninput=\"maxLengthCheck(this)\"> \r\n");
      out.write("				</div>\r\n");
      out.write("				<span class=\"phone_error\">전화번호를 입력해 주세요.</span>\r\n");
      out.write("				<div id=\"emailDiv\">\r\n");
      out.write("					<div id=\"emailSendDiv\">\r\n");
      out.write("						<input type=\"text\" name=\"email\" id=\"email\" placeholder=\"인증코드를 받을 이메일을 입력해 주세요.\">\r\n");
      out.write("						<input type=\"button\" id=\"emailButton\" value=\"인증코드 발송\" onclick=\"sendEmail()\">\r\n");
      out.write("					</div>\r\n");
      out.write("					<span class=\"email_error\">이메일을 입력해 주세요.</span>\r\n");
      out.write("					<div id=\"emailRecieveDiv\">\r\n");
      out.write("						<input type=\"text\" id=\"code_input\" placeholder=\"인증번호 입력\" disabled=\"disabled\"> <br>\r\n");
      out.write("						<span class=\"code_ok\">인증되었습니다.</span>\r\n");
      out.write("						<span class=\"code_error\">인증번호를 다시 입력해주세요.</span>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>	\r\n");
      out.write("				<input type=\"hidden\" name=\"customerType\" value=\"third\"> <br>\r\n");
      out.write("				<button type=\"submit\" onclick=\"validateButton(event)\" id=\"regBtn\">회원가입</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>		\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- footer -->	\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layouts/footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}