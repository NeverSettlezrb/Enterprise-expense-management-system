/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-25 03:03:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class setuserpw_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <input id=\"times0\" type=\"hidden\" value=\"60\" />\r\n");
      out.write("<input id=\"times\" type=\"hidden\" value=\"\" />\r\n");
      out.write("    <input id=\"logincount\" type=\"hidden\" value=\"\" />\r\n");
      out.write("    <div style=\"overflow:auto;width: 330px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;\">\r\n");
      out.write("  <form id=\"loginemail\" method=\"post\" style=\"margin-top: 100px;\">\r\n");
      out.write("<table>\r\n");
      out.write("  \t<tr>\r\n");
      out.write(" \t \t<h1>忘记密码，邮箱一键登录</h1>\r\n");
      out.write(" \t</tr>\r\n");
      out.write(" \t<tr>\r\n");
      out.write("\t\t<td>用户名</td>\r\n");
      out.write("\t\t<td><input type=\"text\" id=\"username\" name=\"username\" required=\"true\" class='easyui-textbox' value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" missingMessage=\"账户名至少需要6位！\"/></td>\r\n");
      out.write("\t\t<td id=\"message4\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>邮箱</td>\r\n");
      out.write("\t\t<td><input class=\"easyui-textbox\" type=\"text\" id=\"email\" name=\"email\" data-options=\"validType:'email'\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("        \t<button id=\"btnGetVcode\" style=\"cursor:pointer;width: 83px;font-size: 1px;\" onclick=\"getvcode()\">获取验证码</button>\r\n");
      out.write("        </td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td >验证码</td>\r\n");
      out.write("        <td>\r\n");
      out.write("        \t<input type=\"text\" name=\"vcodes\" id=\"vcodes\" class='easyui-textbox'  \r\n");
      out.write("        \tplaceholder=\"输入验证码\"   missingMessage=\"请查询邮件是否收到，并且填写验证码\" data-options=\"events:{blur:logincheckVerify}\"/>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td id=\"loginmessage\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan='2'>\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" id=\"修改个人信息\" class='easyui-linkbutton' data-options=\"iconCls:'icon-ok'\"  onclick=\"loginUser_Pw()\">登录</a>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script  type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\twindow.onload = numberInputPlaceholder2();\r\n");
      out.write("\t})\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t//显示提示条\r\n");
      out.write("\tfunction numberInputPlaceholder2(){\r\n");
      out.write("\t\t$(\"#vcodes\").each(function(i){\r\n");
      out.write("\t\t\tvar span = $(this).siblings(\"span\")[0];\r\n");
      out.write("\t\t\tvar targetInput = $(span).find(\"input:first\");\r\n");
      out.write("\t\t\t//alert(targetInput.val(s));\r\n");
      out.write("\t\tif(targetInput){\r\n");
      out.write("\t\t\t$(targetInput).attr(\"placeholder\", $(this).attr(\"placeholder\"));\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//获取验证码\r\n");
      out.write("\t//var time0 = 60;\r\n");
      out.write("\t//var time = time0;  \r\n");
      out.write("\tvar m;  \r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction getvcode(){\r\n");
      out.write("\t\t\tvar btnGet = document.getElementById(\"btnGetVcode\");\r\n");
      out.write("\t\t\tbtnGet.disabled = true;  // 为了防止多次点击\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl: 'EmailServlet?method=getVCode',\r\n");
      out.write("\t\t\t\ttype: 'post',\r\n");
      out.write("\t\t\t\tdata: {email: $(\"input[name='email']\").val()},\r\n");
      out.write("\t\t\t\tdataType: 'text',\r\n");
      out.write("\t\t\t\tsuccess: function(msg) {\r\n");
      out.write("\t\t\t\t\tif(msg == -1){\r\n");
      out.write("\t\t\t\t\t\twindow.alert(\"请输入正确的邮箱！\");\r\n");
      out.write("\t\t\t\t\t\tbtnGet.disabled = false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\tuseChangeBTN2();  // 控制下一次重新获取验证码\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror:function(msg){\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t//})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//控制验证码重新获取\r\n");
      out.write("\tfunction changeBTN2(){\r\n");
      out.write("\t\tif($(\"#times\").val() > 0){\r\n");
      out.write("\t\t\tvar btnGet = document.getElementById(\"btnGetVcode\");\r\n");
      out.write("\t\t\tbtnGet.disabled = true;\r\n");
      out.write("\t\t\t$(\"#btnGetVcode\").text(\"（\"+$(\"#times\").val()+\"s）\"+\"重新获取\");\r\n");
      out.write("\t\t\t$(\"#times\").val($(\"#times\").val()-1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\tvar btnGet = document.getElementById(\"btnGetVcode\");\r\n");
      out.write("\t\t\tbtnGet.disabled = false;\r\n");
      out.write("\t\t\t$(\"#btnGetVcode\").text(\"获取验证码\");\r\n");
      out.write("\t\t\tclearInterval(m);\r\n");
      out.write("\t\t\t$(\"#times\").val($(\"#times0\").val());\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//重新获取验证码\r\n");
      out.write("\tfunction useChangeBTN2(){\r\n");
      out.write("\t\t$(\"#btnGetVcode\").text(\"(\"+$(\"#time\").val()+\"s)\"+\"重新获取\");\r\n");
      out.write("\t\t$(\"#times\").val($(\"#times\").val()-1);\r\n");
      out.write("\t\tm = setInterval(\"changeBTN2()\", 1000);  // 1s调用一次\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t// 验证验证码\r\n");
      out.write("\t\tfunction logincheckVerify(){\r\n");
      out.write("\t\t\t\t$(\"#vcodes\").textbox('setValue', $(this).val()); \r\n");
      out.write("\t\t\t\tvar vcodes = $(\"#vcodes\").textbox('getText'); \r\n");
      out.write("\t\t\t\tvar message = document.getElementById(\"loginmessage\");  // 显示提示信息\r\n");
      out.write("\t\t\t\tif(vcodes==null||vcodes==\"\"){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl: 'EmailServlet?method=verify',\r\n");
      out.write("\t\t\t\t\ttype: 'post',\r\n");
      out.write("\t\t\t\t\tdata: {vcode: vcodes},\r\n");
      out.write("\t\t\t\t\tdataType: 'text',\r\n");
      out.write("\t\t\t\t\tsuccess: function(msg) {\r\n");
      out.write("\t\t\t\t\t\tif(msg == 1){\r\n");
      out.write("\t\t\t\t\t\t\tloginmessage.innerHTML = \"验证码正确！\";\r\n");
      out.write("\t\t\t\t\t\t\t//countconcat();\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#loginmessage\").css(\"color\",\"green\");\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#logincount\").val(1);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\t\tloginmessage.innerHTML = \"验证码错误！\";\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#loginmessage\").css(\"color\",\"red\");\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#logincount\").val(0);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror:function(msg){\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//信息修改\r\n");
      out.write("\tfunction loginUser_Pw(){\r\n");
      out.write("\t\tvar test = $(\"#loginemail\").serializeArray()\r\n");
      out.write("\t\tvar datas = $(\"#loginemail\").serialize();\r\n");
      out.write("\t\tvar url = \"exmg/updateuserdate?\"+datas;\r\n");
      out.write("\t\t//alert(test[1].value);\r\n");
      out.write("\t\tif(test[0].value==0){\r\n");
      out.write("\t\t\t$.messager.alert(\"提示\",\"请输入用户名\");\r\n");
      out.write("\t\t}else if(test[2].value==0){\r\n");
      out.write("\t\t\t$.messager.alert(\"提示\",\"请输入验证码\");\r\n");
      out.write("\t\t}else if($(\"#logincount\").val()==0){\r\n");
      out.write("\t\t\t$.messager.alert(\"提示\",\"验证码错误\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t//alert(\"信息正确！\");\r\n");
      out.write("\t\t\tvar url= \"exmg/login_email?\"+datas;\r\n");
      out.write("\t\t\t//alert(url);\r\n");
      out.write("\t\t\t$.post(url,function(data){\r\n");
      out.write("\t\t\t\tvar test = false;\r\n");
      out.write("\t\t\t\tif(data.verify!=true){\r\n");
      out.write("\t\t\t\t\talert(\"用户名或邮箱错误\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\twindow.location.href=$(\"#pageContext\").val()+\"/exmg/homepage?usersname=\"+data.name+\"&userid=\"+data.username+\"&userID=\"+data.userid;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write(" \t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\t\r\n");
      out.write("\t\r\n");
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
