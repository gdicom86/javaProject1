/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-12-04 09:46:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.levelUp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>등업 신청</title>\r\n");
      out.write("<!-- font awesome -->\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/e927512ef5.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- bootstrap -->\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- Jquery -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.js\"></script> \r\n");
      out.write("<!-- CSS import -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/navigation.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/footer.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/levelUp/register.css\">\r\n");
      out.write("<!-- Sweet Alert2 -->\r\n");
      out.write("<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("<!-- JS import -->\r\n");
      out.write("<script defer type=\"text/javascript\" src=\"/resources/js/levelUp/register.js\"></script>\r\n");
      out.write("<script defer type=\"text/javascript\" src=\"/resources/js/navigation.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- navigation -->\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layouts/navigation.jsp", out, false);
      out.write("\r\n");
      out.write("	<div>\r\n");
      out.write("		<h1 style=\"margin-top: 14rem; text-align: center;\">등업 신청</h1>\r\n");
      out.write("	</div>\r\n");
      out.write("	<form style=\"padding: 20px;\" action=\"/levelUp/register\" method=\"post\" id=\"registerForm\">\r\n");
      out.write("		<table>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>아이디 <span data-tooltip=\"필수항목\"><i\r\n");
      out.write("							class=\"fa-solid fa-circle-exclamation fa-2xs\"\r\n");
      out.write("							style=\"color: #ff0000;\"></i></span>\r\n");
      out.write("					</th>\r\n");
      out.write("					<td><input type=\"text\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"readonly\" required=\"required\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>핸드폰번호 <span data-tooltip=\"필수항목\"><i\r\n");
      out.write("							class=\"fa-solid fa-circle-exclamation fa-2xs\"\r\n");
      out.write("							style=\"color: #ff0000;\"></i></span>\r\n");
      out.write("					</th>\r\n");
      out.write("					<td><input type=\"text\" name=\"phone\">\r\n");
      out.write("						<p id=\"phoneError\" style=\"color: red; display: none;\">핸드폰번호를 입력해주세요.</p>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>사업자 등록번호 <span data-tooltip=\"필수항목\"><i\r\n");
      out.write("							class=\"fa-solid fa-circle-exclamation fa-2xs\"\r\n");
      out.write("							style=\"color: #ff0000;\"></i></span>\r\n");
      out.write("					</th>\r\n");
      out.write("					<td><input type=\"text\" name=\"businessNumber\">\r\n");
      out.write("						<p id=\"businessNumberError\" style=\"color: red; display: none;\">사업자 등록번호를 입력해주세요.</p>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>등업신청 내용</th>\r\n");
      out.write("					<td><textarea name=\"content\" id=\"\" cols=\"30\" rows=\"10\" placeholder=\"ex) 어떤부동산 소속공인중개사 김땡땡입니다.&#10;    매물 등록을 위해 등업 신청합니다.\"></textarea>\r\n");
      out.write("						<p id=\"contentError\" style=\"color: red; display: none;\">등업신청 내용을 입력해주세요.</p>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("		<div class=\"subtitle\">개인정보의 수집 및 이용에 대한 안내</div>\r\n");
      out.write("		개인정보의 처리 <span data-tooltip=\"필수항목\"><i class=\"fa-solid fa-circle-exclamation fa-2xs\"\r\n");
      out.write("			style=\"color: #ff0000;\"></i></span> <span id=\"privacy-policy\"\r\n");
      out.write("			style=\"cursor: pointer;\" class=\"detail\">자세히보기</span>\r\n");
      out.write("		<!-- ***************************************************************************************************************************************************************************************************** -->\r\n");
      out.write("		<div id=\"policy-modal\" class=\"modal\">\r\n");
      out.write("			<span id=\"close-button-policy\" class=\"modal-close\">&times;</span>\r\n");
      out.write("			<div class=\"modal-content\">\r\n");
      out.write("				<p>※ \"개인정보\"란 살아 있는 개인에 관한 정보로서 다음의 어느 하나에 해당하는 정보를 말합니다(「개인정보\r\n");
      out.write("					보호법」 제2조제1호). 1. 성명, 주민등록번호 및 영상 등을 통하여 개인을 알아볼 수 있는 정보 2. 해당\r\n");
      out.write("					정보만으로는 특정 개인을 알아볼 수 없더라도 다른 정보와 쉽게 결합하여 알아볼 수 있는 정보(이 경우 쉽게 결합할 수\r\n");
      out.write("					있는지 여부는 다른 정보의 입수 가능성 등 개인을 알아보는 데 소요되는 시간, 비용, 기술 등을 합리적으로 고려하여야\r\n");
      out.write("					함) 3. 가명처리함으로써 원래의 상태로 복원하기 위한 추가 정보의 사용·결합 없이는 특정 개인을 알아볼 수 없는 정보\r\n");
      out.write("					※ \"가명처리\"란 개인정보의 일부를 삭제하거나 일부 또는 전부를 대체하는 등의 방법으로 추가 정보가 없이는 특정 개인을\r\n");
      out.write("					알아볼 수 없도록 처리하는 것을 말합니다((「개인정보 보호법」 제2조제1호의2).</p>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		개인정보의 수집·이용 방법 <span data-tooltip=\"필수항목\"><i class=\"fa-solid fa-circle-exclamation fa-2xs\"\r\n");
      out.write("			style=\"color: #ff0000;\"></i></span> <span id=\"privacy-policy1\"\r\n");
      out.write("			style=\"cursor: pointer;\" class=\"detail\">자세히보기</span>\r\n");
      out.write("\r\n");
      out.write("		<div id=\"policy-modal1\" class=\"modal\">\r\n");
      out.write("			<span id=\"close-button-policy1\" class=\"modal-close\">&times;</span>\r\n");
      out.write("			<div class=\"modal-content\">\r\n");
      out.write("				<p>개인정보의 수집·이용 개인정보처리자\r\n");
      out.write("				※ \"개인정보\"란 살아 있는 개인에 관한 정보로서 다음의 어느 하나에 해당하는 정보를 말합니다(「개인정보\r\n");
      out.write("					보호법」 제2조제1호). 1. 성명, 주민등록번호 및 영상 등을 통하여 개인을 알아볼 수 있는 정보 2. 해당\r\n");
      out.write("					정보만으로는 특정 개인을 알아볼 수 없더라도 다른 정보와 쉽게 결합하여 알아볼 수 있는 정보(이 경우 쉽게 결합할 수\r\n");
      out.write("					있는지 여부는 다른 정보의 입수 가능성 등 개인을 알아보는 데 소요되는 시간, 비용, 기술 등을 합리적으로 고려하여야\r\n");
      out.write("					함) 3. 가명처리함으로써 원래의 상태로 복원하기 위한 추가 정보의 사용·결합 없이는 특정 개인을 알아볼 수 없는 정보\r\n");
      out.write("					※ \"가명처리\"란 개인정보의 일부를 삭제하거나 일부 또는 전부를 대체하는 등의 방법으로 추가 정보가 없이는 특정 개인을\r\n");
      out.write("					알아볼 수 없도록 처리하는 것을 말합니다((「개인정보 보호법」 제2조제1호의2).</p>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div>\r\n");
      out.write("			<input type=\"checkbox\">상담진행을 위해 개인정보 수집 및 이용에 동의 합니다.\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<button id=\"levelUpBtn\" onclick=\"validateButton(event)\" type=\"submit\"  style=\"margin-bottom: 108px;\">등업신청</button>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<!-- footer -->\r\n");
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
