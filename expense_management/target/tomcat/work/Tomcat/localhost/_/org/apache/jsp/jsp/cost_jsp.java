/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-23 06:17:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cost_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    <!DOCTYPE html>\r\n");
      out.write("    <div style=\"overflow:auto;width: 299px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;\">\r\n");
      out.write("  <form id=\"baoxiao\" method=\"post\">\r\n");
      out.write("<table>\r\n");
      out.write("  \t<tr>\r\n");
      out.write(" \t \t<h1>报销单</h1>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>报销金额</td>\r\n");
      out.write("\t\t<td><input type=\"number\" id=\"money\" name=\"money\" class='easyui-textbox' value='' /></td>\r\n");
      out.write("\t\t<td id=\"messagemoney\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>报销原因</td>\r\n");
      out.write("\t\t<td><input class=\"easyui-textbox\" id=\"tips\" name=\"tips\" data-options=\"multiline:true\" style=\"height:100px\"></td>\r\n");
      out.write("\t\t<td id=\"messageetips\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan='2'>\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" id=\"修改个人信息\" class='easyui-linkbutton' data-options=\"iconCls:'icon-ok'\" style=\"margin-left: 40px;\" onclick=\"submitapply()\">确定申请</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script  type=\"text/javascript\">\r\n");
      out.write("\tfunction submitapply(){\r\n");
      out.write("\t\tvar datas = $(\"#baoxiao\").serialize();\r\n");
      out.write("\t\tvar myDate = new Date();\r\n");
      out.write("\t\tvar time=myDate.getFullYear()+\"-\"+myDate.getMonth()+\"-\"+myDate.getDate();\r\n");
      out.write("\t\tvar url = \"exmg/applyreport?\"+datas+\"&redate=\"+time+\"&username=\"+$(\"#attrid\").val();\r\n");
      out.write("\t\t//alert(url);\r\n");
      out.write("\t\tif($('#money').textbox('getValue')==null||$('#money').textbox('getValue')==\"\"){\r\n");
      out.write("\t\t\t$.messager.alert(\"提示\",\"请填写报销金额哦！\");\r\n");
      out.write("\t\t}else if($('#money').textbox('getValue')==null||$('#tips').textbox('getValue')==\"\"){\r\n");
      out.write("\t\t\t$.messager.alert(\"提示\",\"请填写报销原因哦！\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$.post(url,function(data){\r\n");
      out.write("\t\t\t\t if(data){\r\n");
      out.write("\t\t\t\t\t if(data.result){\r\n");
      out.write("\t\t\t\t\t\t $.messager.alert(\"提示\",data.msg);\r\n");
      out.write("\t\t \t\t\t\t}else{\t\r\n");
      out.write("\t\t \t\t\t\t$.messager.alert(\"提示\",data.msg);\r\n");
      out.write("\t\t \t\t\t\t}\r\n");
      out.write("\t\t\t \t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
