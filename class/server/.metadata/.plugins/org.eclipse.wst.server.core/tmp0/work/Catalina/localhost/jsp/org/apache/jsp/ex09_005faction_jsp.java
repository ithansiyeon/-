/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-08-11 07:41:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;

public final class ex09_005faction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Arrays");
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
      out.write("\r\n");

	
	//1. 클라이언트(브라우저) : UTF-8
	//2. 데이터 전송 
	//3. 인터넷(WEB) ~~~ 서버 도착 : ISO-8859-1 
	//4. 서버 수신 : UTF-8 
	

	//데이터 수신하기 
	request.setCharacterEncoding("UTF-8"); // 첫줄에 적어

	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	//텍스트 박스 
	String txt1 = request.getParameter("txt1"); // 인터넷상에서는 무조건 문자열로 반환을 함

	//암호 박스
	String pw1 = request.getParameter("pw1");
	
	//다중 라인
	String txt2 = request.getParameter("txt2");
	txt2 = txt2.replace("\n", "<br>");
	
	//체크 박스
	//1. value O
	// - 체크O : value
	// - 체크X : null
	//2. value X
	// - 체크O : "on"
	// - 체크X : null
	String cb1 = request.getParameter("cb1");
	
	String cb2 = request.getParameter("cb2");
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	
	String temp = "";
	
	/* temp로 관리함 */
	for(int i=2;i<=4;i++){
		temp += request.getParameter("cb"+i)+",";
	}
	
	String[] cb = request.getParameterValues("cb");
	//같은 이름을 한꺼번에 받을 수 있어
	
	//라디오 버튼(단일값 컨트롤)
	String [] rb =request.getParameterValues("rb"); // 길이가 1짜리 배열이 만들어져, 사용X
	System.out.println(Arrays.toString(rb)); //[on], [on]
			
	String rb2 = request.getParameter("rb"); // 사용O
	System.out.println(rb2); //[y],y,[n],n
	
	//셀렉트
	String sel1 = request.getParameter("sel1");
	
	//달력
	String date1 = request.getParameter("date1");
	
	//범위
	String range1 = request.getParameter("range1");
	
	//자바스크립트(히든 태그)
	String jvalue = request.getParameter("jvalue");
	
	//단일 데이터 : request.getParameter()
	//다중 데이터 : request.getParameterValues()
	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("<style>\r\n");
      out.write("\tdiv{\r\n");
      out.write("\tmargin-bottom:15px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<h1>데이터 수신하기</h1>\r\n");
      out.write("\t<div>이름: ");
      out.print( name );
      out.write("</div>\r\n");
      out.write("\t<div>나이: ");
      out.print( age );
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<h1>폼 데이터 수신하기</h1>\r\n");
      out.write("\t<div>텍스트 박스: ");
      out.print( txt1 );
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div>암호상자: ");
      out.print( pw1 );
      out.write("</div>\r\n");
      out.write("\t<div>다중 라인: ");
      out.print( txt2 );
      out.write("</div>\r\n");
      out.write("\t<div>체크 박스: ");
      out.print( cb1 );
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div>체크 박스 : ");
      out.print( cb2 );
      out.write(',');
      out.write(' ');
      out.print( cb3 );
      out.write(',');
      out.write(' ');
      out.print( cb4 );
      out.write("</div>\r\n");
      out.write("\t<div>체크 박스 : ");
      out.print( temp );
      out.write("</div>\r\n");
      out.write("\t<div>체크 박스 : ");
      out.print( Arrays.toString(cb) );
      out.write("</div>\r\n");
      out.write("\t<div>라디오 버튼 : ");
      out.print( rb2 );
      out.write("</div>\r\n");
      out.write("\t<div>셀렉트 : ");
      out.print( sel1  );
      out.write("</div>\r\n");
      out.write("\t<div>달력 : ");
      out.print( date1 );
      out.write("</div>\r\n");
      out.write("\t<div>범위 : ");
      out.print( range1 );
      out.write("</div>\r\n");
      out.write("\t<div>자바스크립트 : ");
      out.print( jvalue );
      out.write("</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
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
