/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-24 12:42:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertuser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <input id=\"countdept\" type=\"hidden\" value=\"\" />\r\n");
      out.write("    <input id=\"check\" type=\"hidden\" value=\"0\" />\r\n");
      out.write("    <div style=\"overflow:auto;width: 330px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;\">\r\n");
      out.write("  <form id=\"insertuserz\" method=\"post\">\r\n");
      out.write("<table>\r\n");
      out.write("  \t<tr>\r\n");
      out.write(" \t \t<h1>新加员工</h1>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>姓名</td>\r\n");
      out.write("\t\t<td><input type=\"text\" id=\"name\" name=\"name\" class='easyui-textbox'  missingMessage=\"请输入真实姓名\"  /></td>\r\n");
      out.write("\t\t<td id=\"message4\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>性别</td>\r\n");
      out.write("\t\t<td><select id=\"gender\" class=\"easyui-combobox\" name=\"gender\" style=\"width:178px;\" editable=\"false\" >\r\n");
      out.write("\t\t<option>男</option>\r\n");
      out.write("    \t<option>女</option>\r\n");
      out.write("    \t</select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>年龄</td>\r\n");
      out.write("\t\t<td><input type=\"number\" name=\"age\" id=\"age\" class='easyui-textbox' value='' data-options=\"events:{blur:checkAge}\"/></td>\r\n");
      out.write("\t\t<td id=\"messageage\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>手机号</td>\r\n");
      out.write("\t\t<td><input type=number id=\"phone\" name=\"phone\" missingMessage=\"请填写11位手机号\"  class='easyui-textbox' data-options=\"events:{blur:checkPhone}\"/></td>\r\n");
      out.write("\t\t<td id=\"messagephone\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>邮箱</td>\r\n");
      out.write("\t\t<td><input type=text id=\"email\" name=\"email\"  missingMessage=\"请填写邮箱\"  class='easyui-textbox' data-options=\"events:{blur:checkemail}\"/></td>\r\n");
      out.write("\t\t<td id=\"messageemail\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>部门分配</td>\r\n");
      out.write("\t\t<td><input  id=\"dept\" name=\"dept\" class='easyui-combobox' required=\"true\"  data-options=\"events:{blur:createUserId}\" editable=\"false\"/></td>\r\n");
      out.write("\t\t<td id=\"messageid\"></td>\r\n");
      out.write("\t</tr>\t\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>职位赋权</td>\r\n");
      out.write("\t\t<td><input  id=\"rname\" name=\"rname\" class='easyui-combobox' required=\"true\" missingMessage=\"请选择职位\"  editable=\"false\"/></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>员工ID</td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"userid\" id=\"userid\" class='easyui-textbox' required=\"true\" missingMessage=\"点击部门生成id\" readonly /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan='3'>\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" id=\"确认添加\" class='easyui-linkbutton'data-options=\"iconCls:'icon-ok'\" onclick=\"insertUserNew()\">确认添加人员</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script  type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tinitrname();\r\n");
      out.write("\t\t$(\"#age\").textbox('setValue', 0);\r\n");
      out.write("\t})\t\r\n");
      out.write("\r\n");
      out.write("\t//职位下拉\r\n");
      out.write("\tfunction initrname(){\t\r\n");
      out.write("\t\t$('#rname').combobox({\r\n");
      out.write("\t   \t\turl:'exmg/listrname',\r\n");
      out.write("\t   \t\tmultiple:true,\r\n");
      out.write("\t    \tvalueField:'rid',\r\n");
      out.write("\t    \ttextField:'rname',\r\n");
      out.write("\t    \tonLoadSuccess:function(){\r\n");
      out.write("\t    \t\t$('#rname').combobox('select', '4');\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$('#dept').combobox({\r\n");
      out.write("\t   \t\turl:'exmg/listdept',\r\n");
      out.write("\t    \tvalueField:'deptno',\r\n");
      out.write("\t    \ttextField:'deptname'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t//自动生成id\r\n");
      out.write("\tfunction createUserId(){\r\n");
      out.write("\t\t var messageid = document.getElementById(\"messageid\"); \r\n");
      out.write("\t\t var deptno = $('#dept').combobox('getValue');\r\n");
      out.write("\t\t var deptnotostring=\"\";\r\n");
      out.write("\t\t if(deptno==null||deptno==\"\"){\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t }else{\r\n");
      out.write("\t\t $.ajaxSettings.async = false;\r\n");
      out.write("\t\t $.post(\"exmg/countdeptno?deptno=\"+deptno,function(data){\r\n");
      out.write("\t\t\t var da = data.count+1;\r\n");
      out.write("\t\t\t //alert(da.toString().length);\r\n");
      out.write("\t\t\t if(da.toString().length==1){\r\n");
      out.write("\t\t\t\t$(\"#countdept\").val(\"00\"+(data.count+1).toString());\r\n");
      out.write("\t\t\t }else if(da.toString().length==2){\r\n");
      out.write("\t\t\t\t$(\"#countdept\").val(\"0\"+(data.count+1).toString());\r\n");
      out.write("\t\t\t }else if(da.toString().length==3){\r\n");
      out.write("\t\t\t\t$(\"#countdept\").val((data.count+1).toString());\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t });\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t if(deptno.length==1){\r\n");
      out.write("\t\t\t deptnotostring =  \"0\"+deptno;\r\n");
      out.write("\t\t }else if(deptno.length==2){\r\n");
      out.write("\t\t\t deptnotostring =  deptno;\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t //alert($(\"#countdept\").val());\r\n");
      out.write("\t\t //alert(\"120\"+deptnotostring+$(\"#countdept\").val());\r\n");
      out.write("\t\t var result= \"120\"+deptnotostring+$(\"#countdept\").val();\t \r\n");
      out.write("\t\t $(\"#check\").val($(\"#check\").val()+1);\r\n");
      out.write("\t\t $('#userid').textbox('setValue',result);\r\n");
      out.write("\t\t }\t \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkAge(){\r\n");
      out.write("\t\t var messageage = document.getElementById(\"messageage\");\r\n");
      out.write("\t\t var test = $(\"#insertuserz\").serializeArray();\r\n");
      out.write("\t\t $(\"#age\").textbox('setValue', $(this).val()); \r\n");
      out.write("\t\t var age = $(\"#age\").textbox('getText'); \r\n");
      out.write("\t\t //alert(age);\r\n");
      out.write("\t\tif(age<0){\r\n");
      out.write("\t\t\tmessageage.innerHTML = \"请填入合法年龄！\";\r\n");
      out.write("\t\t\t$(\"#messageage\").css(\"color\",\"red\");\r\n");
      out.write("\t\t}else if(age==\"\"||age==null){\r\n");
      out.write("\t\t\t$(\"#age\").textbox('setValue', 0);\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tmessageage.innerHTML = \" \";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkemail(){\r\n");
      out.write("\t\t$(\"#email\").textbox('setValue', $(this).val()); \r\n");
      out.write("\t\t var x = $(\"#email\").textbox('getText'); \r\n");
      out.write("\t\tif(x.charAt(x.length-4) == \".\" && x.indexOf(\".\") == x.length-4 && x.lastIndexOf(\".\") == x.length-4){\r\n");
      out.write("\t\t\tif(x.indexOf(\"@\") == x.length-7 || x.indexOf(\"@\") == x.length-8 && x.lastIndexOf(\"@\") == x.length-7 ||  x.lastIndexOf(\"@\") == x.length-8){\r\n");
      out.write("\t\t\t\tmessageemail.innerHTML = \"可用！\";\r\n");
      out.write("\t\t\t\t$(\"#messageemail\").css(\"color\",\"green\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tmessageemail.innerHTML = \"请填入合法的邮箱！\";\r\n");
      out.write("\t\t\t\t$(\"#messageemail\").css(\"color\",\"red\");\r\n");
      out.write("\t\t\t\t $(\"#check\").val($(\"#check\").val()+1);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else if(x==null||x==\"\"){\r\n");
      out.write("\t\t\tmessageemail.innerHTML = \" \";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tmessageemail.innerHTML = \"请填入合法的邮箱！\";\r\n");
      out.write("\t\t\t$(\"#messageemail\").css(\"color\",\"red\");\r\n");
      out.write("\t\t\t $(\"#check\").val($(\"#check\").val()+1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkPhone(){\r\n");
      out.write("\t\t var messageage = document.getElementById(\"messagephone\");\r\n");
      out.write("\t\t var test = $(\"#insertuserz\").serializeArray();\r\n");
      out.write("\t\t $(\"#phone\").textbox('setValue', $(this).val()); \r\n");
      out.write("\t\t var phone = $(\"#phone\").textbox('getText'); \r\n");
      out.write("\t\t if(phone.length!=11){\r\n");
      out.write("\t\t\t \tmessagephone.innerHTML = \"请填入合法正确的手机号！\";\r\n");
      out.write("\t\t\t\t$(\"#messagephone\").css(\"color\",\"red\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t \tmessagephone.innerHTML = \" \";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//插入人员\r\n");
      out.write("\tfunction insertUserNew(){\r\n");
      out.write("\t\tvar datas = $(\"#insertuserz\").serialize();\r\n");
      out.write("\t\tvar myDate = new Date();\r\n");
      out.write("\t\tvar time=myDate.getFullYear()+\"-\"+myDate.getMonth()+\"-\"+myDate.getDate();\r\n");
      out.write("\t\tvar url = \"exmg/insertusernew?\"+datas+\"&hire=\"+time;\r\n");
      out.write("\t\t//alert(url);\r\n");
      out.write("\t\tif($('#rname').combobox('getValue')==null||$('#rname').combobox('getValue')==\"\"){\r\n");
      out.write("\t\t\t$.messager.alert(\"提示\",\"请选择一个职位！\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tif($(\"#check\").val()==\"01\"){\r\n");
      out.write("\t\t\t$.ajaxSettings.async = false;\r\n");
      out.write("\t\t\t$.post(url,function(data){\r\n");
      out.write("\t\t\t\t if(data){\r\n");
      out.write("\t\t\t\t\t if(data.result){\r\n");
      out.write("\t\t\t\t\t\t hideInsertUserWin();\t\r\n");
      out.write("\t\t\t\t\t\t initupdateuserdatagrid();\r\n");
      out.write("\t\t \t\t\t\t}\r\n");
      out.write("\t\t \t\t\t\t$.messager.alert(\"提示\",data.msg);\r\n");
      out.write("\t\t\t \t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示\",\"至少需要一个部门信息！\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
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
