/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-08-27 00:07:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/views/inc/asset.jsp", Long.valueOf(1596172891774L));
    _jspx_dependants.put("jar:file:/D:/class/server/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/codestudy/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/views/inc/footer.jsp", Long.valueOf(1596172891514L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1596159195709L));
    _jspx_dependants.put("jar:file:/D:/class/server/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/codestudy/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fminIntegerDigits_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fminIntegerDigits_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fminIntegerDigits_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>CodeStudy::Plan</title>\r\n");
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
      out.write("<link rel=\"stylesheet\" href=\"/codestudy/css/plan.css\">\r\n");
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
      out.write("\t\t\t\t<h1>스터디 일정 <small>Plan</small></h1>\r\n");
      out.write("                \r\n");
      out.write("                <table style =\"margin:15px 0px; width:100%;\">\r\n");
      out.write("                \t<tr>\r\n");
      out.write("                \t\t<td><button type = \"button\" id = \"prevMonth\" class = \"btn btn-default\" onclick=\"location.href='/codestudy/plan/index.do?year=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prevYear}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&month=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prevMonth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\">이전달</button></td>\r\n");
      out.write("                \t\t<td style=\"text-align:center;font-size:2em;font-weight:bold;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${year}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('.');
      if (_jspx_meth_fmt_005fformatNumber_005f0(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("                \t\t<td style=\"text-align:right\"><button type = \"button\" id = \"nextMonth\" class = \"btn btn-default\"  onclick=\"location.href='/codestudy/plan/index.do?year=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nextYear}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&month=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nextMonth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\">다음달</button></td>\r\n");
      out.write("                \t</tr>\r\n");
      out.write("              </table>\r\n");
      out.write("                \r\n");
      out.write("                <table class=\"calendar\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>SUN</th>\r\n");
      out.write("                            <th>MON</th>\r\n");
      out.write("                            <th>TUE</th>\r\n");
      out.write("                            <th>WED</th>\r\n");
      out.write("                            <th>THU</th>\r\n");
      out.write("                            <th>FRI</th>\r\n");
      out.write("                            <th>SAT</th>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${txtCal}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                      ");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("                \r\n");
      out.write("                <div style=\"clear:both;\"></div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                <div style=\"clear:both;\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- ########## 내용 끝 -->\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- ########## 본문 끝 -->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- ########## Modal -->\r\n");
      out.write("\t<form method = \"POST\" action= \"/codestudy/plan/add.do\">\r\n");
      out.write("\t    <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t        <div class=\"modal-dialog\">\r\n");
      out.write("\t        <div class=\"modal-content\">\r\n");
      out.write("\t            <div class=\"modal-header\">\r\n");
      out.write("\t            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("\t            <h4 class=\"modal-title\" id=\"myModalLabel\">일정</h4>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t            <div class=\"modal-body\">\r\n");
      out.write("\t\t                <ul class=\"list-group\">\r\n");
      out.write("\t\t                    <li class=\"list-group-item\">\r\n");
      out.write("\t\t                        <input type=\"date\" class=\"form-control\" id=\"itemDate\" name = \"regdate\" required>\r\n");
      out.write("\t\t                    </li>\r\n");
      out.write("\t\t                    <li class=\"list-group-item\">\r\n");
      out.write("\t\t                        <input type=\"text\" class=\"form-control\" id=\"itemText\" name = \"content\" required placeholder = \"일정 내용을 입력하세요.\">\r\n");
      out.write("\t\t                    </li>\r\n");
      out.write("\t\t                    <li class=\"list-group-item\">\r\n");
      out.write("\t\t                        <input type=\"text\" class=\"form-control\" id=\"itemUser\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t                    </li>\r\n");
      out.write("\t\t                </ul>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t            <div class=\"modal-footer\">\r\n");
      out.write("\t                <button type=\"submit\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-floppy-disk\"></span> 저장</button>\r\n");
      out.write("\t                <button type=\"button\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-remove\"></span> 삭제</button>\r\n");
      out.write("\t                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\"><span class=\"glyphicon glyphicon-ok\"></span> 닫기</button>                    \r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("</form>\r\n");
      out.write("    <!-- ########## Modal -->\r\n");
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
      out.write("\t\t$('#myModal').on('show.bs.modal', function (e) {\r\n");
      out.write("\t        //console.log(e.relatedTarget.innerText);\r\n");
      out.write("\t        if (e.relatedTarget.nodeName == \"DIV\") {\r\n");
      out.write("\t            $(\"#itemText\").val(e.relatedTarget.innerText.substr(2));\r\n");
      out.write("\t        } else {\r\n");
      out.write("\t            console.log((new Date()).toDateString());\r\n");
      out.write("\t            $(\"#itemDate\").val((new Date()).toDateString());\r\n");
      out.write("\t            $(\"#itemText\").val(\"\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t    })\r\n");
      out.write("\t    \r\n");
      out.write("\t    function setData(regdate,name){\r\n");
      out.write("\t\t\t$(\"#itemDate\").val(regdate);\r\n");
      out.write("\t\t\t$(\"#itemUser\").val(name);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
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

  private boolean _jspx_meth_fmt_005fformatNumber_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fminIntegerDigits_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    boolean _jspx_th_fmt_005fformatNumber_005f0_reused = false;
    try {
      _jspx_th_fmt_005fformatNumber_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fformatNumber_005f0.setParent(null);
      // /WEB-INF/views/plan/index.jsp(73,88) name = minIntegerDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatNumber_005f0.setMinIntegerDigits(2);
      // /WEB-INF/views/plan/index.jsp(73,88) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatNumber_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${month+1}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_fmt_005fformatNumber_005f0 = _jspx_th_fmt_005fformatNumber_005f0.doStartTag();
      if (_jspx_th_fmt_005fformatNumber_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fminIntegerDigits_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
      _jspx_th_fmt_005fformatNumber_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatNumber_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatNumber_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/plan/index.jsp(108,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty id}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" <!-- 로그인한 사람 -->\r\n");
          out.write("                <div class=\"btns btn-group\">\r\n");
          out.write("                    <button type=\"button\" class=\"btn btn-default\" data-toggle=\"modal\" data-target=\"#myModal\">\r\n");
          out.write("                        <span class=\"glyphicon glyphicon-plus\"></span>\r\n");
          out.write("                        등록\r\n");
          out.write("                    </button>\r\n");
          out.write("                </div>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
