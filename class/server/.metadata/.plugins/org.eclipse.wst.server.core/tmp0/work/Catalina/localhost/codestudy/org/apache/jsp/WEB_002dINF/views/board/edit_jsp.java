/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-08-12 07:41:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/inc/asset.jsp", Long.valueOf(1596172891774L));
    _jspx_dependants.put("/WEB-INF/views/inc/footer.jsp", Long.valueOf(1596172891514L));
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>CodeStudy::Board</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<link rel=\"stylesheet\" href=\"/codestudy/node_modules/bootstrap/dist/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/codestudy/css/main.css\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"/codestudy/images/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"/codestudy/node_modules/jquery/dist/jquery.js\"></script>\r\n");
      out.write("<script src=\"/codestudy/node_modules/bootstrap/dist/js/bootstrap.js\"></script>");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/codestudy/css/board.css\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- ########## 상단 헤더 시작 -->\r\n");
      out.write("\t");

		out.flush();
	    RequestDispatcher dheader = request.getRequestDispatcher("/inc/header.do");
	    dheader.include(request, response);
	
      out.write("\r\n");
      out.write("\t<!-- ########## 상단 헤더 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- ########## 본문 시작 -->\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- ########## 좌측 시작 -->\r\n");
      out.write("\t\t<div class=\"menu col-sm-12 col-md-3\">\r\n");
      out.write("\t\t\t<!-- ########## 메뉴 시작 -->\r\n");
      out.write("\t\t\t");

				out.flush();
			    RequestDispatcher dmenu = request.getRequestDispatcher("/inc/menu.do");
				dmenu.include(request, response);
			
      out.write("\r\n");
      out.write("\t\t\t<!-- ########## 메뉴 끝 -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- ########## 인증 시작 -->\r\n");
      out.write("\t\t\t");

				out.flush();
			    RequestDispatcher dauth = request.getRequestDispatcher("/inc/auth.do");
			    dauth.include(request, response);
			
      out.write("\r\n");
      out.write("\t\t\t<!-- ########## 인증 끝 -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- ########## 채팅 시작 -->\r\n");
      out.write("\t\t\t");

				out.flush();
			    RequestDispatcher dchat = request.getRequestDispatcher("/inc/chat.do");
				dchat.include(request, response);
			
      out.write("\r\n");
      out.write("\t\t\t<!-- ########## 채팅 끝 -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- ########## 좌측 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- ########## 내용 시작 -->\r\n");
      out.write("\t\t<div class=\"content col-sm-12 col-md-9\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<h1>자유 게시판 <small>Board</small></h1>\r\n");
      out.write("                \r\n");
      out.write("\t\t\t\t<form method = \"POST\" action = \"/codestudy/board/editok.do\">\r\n");
      out.write("                <table class=\"table write\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"subject\" id=\"subject\" name = \"subject\" required value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.subject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <textarea class=\"form-control\" id=\"content\" placeholder=\"content\" name = \"content\" required>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <!-- \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"file\" class=\"form-control\" placeholder=\"file\" id=\"file\">\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                     -->\r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div style=\"clear:both;\"></div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"btns btn-group\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" onclick=\"location.href='/codestudy/board/list.do';\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-chevron-left\"></span>\r\n");
      out.write("                        뒤로\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-default\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-plus\"></span>\r\n");
      out.write("                        수정\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- 수정할 글 번호(눈에 보일 필요는 없고 어떤걸 수정해야 되는지) -->\r\n");
      out.write("                <input type = \"hidden\" name = \"seq\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.seq}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                </form>\r\n");
      out.write("                <div style=\"clear:both;\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- ########## 내용 끝 -->\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- ########## 본문 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- ########## 하단 시작 -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("\t<div>&copy;Copyright codestudy.com 2020 All rights reserved.</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"/codestudy/js/main.js\"></script>\r\n");
      out.write("<!-- 2020.07.21.in -->");
      out.write("\r\n");
      out.write("\t<!-- ########## 하단 끝 -->\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
