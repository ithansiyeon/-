/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-08-22 11:52:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ex09_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ajax/css/bootstrap.css\">\r\n");
      out.write("<script src=\"/ajax/js/jquery-1.12.4.js\"></script>\r\n");
      out.write("<script src=\"/ajax/js/bootstrap.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("\t.container {\r\n");
      out.write("\t\twidth: 500px;\r\n");
      out.write("\t\tposition:relative;  /* 자식의 부모역할을 하기 위해서 */\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#list {\r\n");
      out.write("\t\tborder: 1px solid #DDD;\r\n");
      out.write("\t\twidth: 333px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tleft: 24px;\r\n");
      out.write("\t\ttop: 112px;\r\n");
      out.write("\t\tbackground-color: white;\r\n");
      out.write("\t\tborder-radius: 3px;\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#list footer {\r\n");
      out.write("\t\tfont-size: 12px;\r\n");
      out.write("\t\tbackground-color: #CCC;\r\n");
      out.write("\t\ttext-align: right;\r\n");
      out.write("\t\tpadding: 5px 5px 3px 3px;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#list .item {\r\n");
      out.write("\t\tpadding:5px;\r\n");
      out.write("\t\tpading-left:10px;\r\n");
      out.write("\t\tcursor:pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\t/*\r\n");
      out.write("\t#list .item:hover{\r\n");
      out.write("\t\tbackground-color:#DDD;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t*/\r\n");
      out.write("\t\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--  -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<h1>추천 검색어</h1>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"search\" id=\"search\" class=\"form-control\" autocomplete=\"off\"></td>\r\n");
      out.write("\t\t\t\t<td><button type=\"button\" class=\"btn btn-default\">검색</button></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"list\">\r\n");
      out.write("\t\t\t<section>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t\t<footer>추천 검색어</footer>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar index = -1;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#search\").keyup(function() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (event.keyCode == 38) { //위\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tindex--;\r\n");
      out.write("\t\t\t\tif (index < 0) { index = 0; }\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#list .item\").css(\"background-color\", \"#FFF\");\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#list .item\").eq(index).css(\"background-color\", \"#DDD\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#search\").val($(\"#list .item\").eq(index).text());\r\n");
      out.write("\t\t\t\treturn;\t\t\t\r\n");
      out.write("\t\t\t} else if (event.keyCode == 40) { //아래\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tindex++;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tif (index > $(\"#list .item\").length-1) { index--; }\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#list .item\").css(\"background-color\", \"#FFF\");\r\n");
      out.write("\t\t\t\t$(\"#list .item\").eq(index).css(\"background-color\", \"#DDD\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#search\").val($(\"#list .item\").eq(index).text());\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} else if (event.keyCode == 13) {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#search\").val($(\"#list .item\").eq(index).text());\r\n");
      out.write("\t\t\t\t$(\"#list\").hide();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tindex = -1; //초기화\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar word = $(\"#search\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//서버로 전송\r\n");
      out.write("\t\t\t//GET -> 서버로 전송하는 데이터의 양이 적을 때 \r\n");
      out.write("\t\t\t//POST -> 서버로 전송하는 데이터의 양이 많을 때 \r\n");
      out.write("\t\t\t//돌려받는 건 상관이 없어 \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//검색어가 존재할때만 전송\r\n");
      out.write("\t\t\tif(word.trim().length>0){\r\n");
      out.write("\t\t\t\t//초성이 없는 경우만 전송\r\n");
      out.write("\t\t\t\t// - 영어대소문자 + 숫자 + 공백 + 특수문자(_) + 한글\r\n");
      out.write("\t\t\t\t// - 정규식 -> ^[A-Za-z0-9\\s _ 가-힣]{1,}$ \r\n");
      out.write("\t\t\t\tvar regex = /^[A-Za-z0-9\\s _ 가-힣]{1,}$/gi;\r\n");
      out.write("\t\t\t\t//g는 여러번 찾아줘 \r\n");
      out.write("\t\t\t\t//console.log(word,regex.test(word));\r\n");
      out.write("\t\t\t\tif(regex.test(word)) {\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype:\"GET\",\r\n");
      out.write("\t\t\t\t\turl:\"/ajax/ex09ok.do\",\r\n");
      out.write("\t\t\t\t\tdata: \"word=\"+word,\r\n");
      out.write("\t\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\t\tsuccess:function(result){\r\n");
      out.write("\t\t\t\t\t\t//초기화\r\n");
      out.write("\t\t\t\t\t\t$(\"#list section\").html(\"\");\r\n");
      out.write("\t\t\t\t\t\t//추가하기\r\n");
      out.write("\t\t\t\t\t\t$(result).each(function(index,item){\r\n");
      out.write("\t\t\t\t\t\t\t//item == 검색어 \r\n");
      out.write("\t\t\t\t\t\t\t$(\"#list section\").append(\"<div class='item' onclick='sel();' onmouseover='itemover();' onmouseout='itemout()'>\"+item+\"</div>\");\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t$(\"#list\").show();\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror:function(a,b,c){\r\n");
      out.write("\t\t\t\t\t\tconsole.log(a,b,c);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#list\").hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tfunction sel(){\r\n");
      out.write("\t\t\t\t//$(this) -> jQuery를 사용해서 이벤트를 걸었을 때만 사용 || window(BOM)\r\n");
      out.write("\t\t\t\tvar word = event.srcElement.innerText;\r\n");
      out.write("\t\t\t\t//alert(word);\r\n");
      out.write("\t\t\t\t$(\"#search\").val(word);\r\n");
      out.write("\t\t\t\t$(\"#list\").hide();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//alert($(event.srcElement).index());\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//폼.submit(); 자동전송 에뮬레이트 함수\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction itemover(){\r\n");
      out.write("\t\t\t\t$(event.srcElement).css(\"background-color\",\"#DDD\");\r\n");
      out.write("\t\t\t\t$(\"#list .item\").eq(index).css(\"background-color\",\"#FFF\");\r\n");
      out.write("\t\t\t\tindex = $(event.srcElement).index(); // 이것 안하면 0부터 시작함\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction itemout(){\r\n");
      out.write("\t\t\t\t$(event.srcElement).css(\"background-color\",\"#FFF\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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