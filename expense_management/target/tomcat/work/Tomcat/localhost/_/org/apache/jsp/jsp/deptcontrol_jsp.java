/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-21 11:26:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class deptcontrol_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\t<table id=\"deptcontrolDatagrid\">\r\n");
      out.write("  \t\t<div id=\"empDatagrid_toolbardept\">\r\n");
      out.write("  \t\t<a href=\"javascript:void(0)\" onclick=\"insertdeptsWin()\" class='easyui-linkbutton' data-options=\"iconCls:'icon-mini-add'\">新增部门</a>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("    </table>\r\n");
      out.write("  \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tinitDeptControlDatagrid();\r\n");
      out.write("\t})\t\r\n");
      out.write("\t\r\n");
      out.write("\t//初始化\r\n");
      out.write("\tfunction initDeptControlDatagrid(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#deptcontrolDatagrid\").datagrid({\r\n");
      out.write("\t\t\tcolumns:[[\r\n");
      out.write("\t\t\t\t{field:\"deptname\",title:\"部门名称\",align:\"center\",width:160},\r\n");
      out.write("\t\t\t\t{field:\"qid\",title:\"操作\",width:180,align:\"center\",formatter:function(v,r,i){// v 当前字段值, r为行对象, i为索引\r\n");
      out.write("\t\t\t\t\tvar deptname = r.deptname;\r\n");
      out.write("\t\t\t\t\tvar deptno=r.deptno;\r\n");
      out.write("\t\t\t\t\treturn\"<a class='删除角色' href='javascript:void(0)' onclick='deleteDept(\\\"\"+deptno+\"\\\"\\,\\\"\"+deptname+\"\\\")'>删除部门</a>\"\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}}\r\n");
      out.write("\t\t\t]],\r\n");
      out.write("\t\t\tonLoadSuccess:function (data) {\r\n");
      out.write("\t        \t$(\".authority\").linkbutton({plain:true, iconCls:'icon-edit' });\r\n");
      out.write("\t        \t$(\".删除角色\").linkbutton({plain:true, iconCls:'icon-cancel' });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t,rownumbers:true\r\n");
      out.write("\t\t\t,rowStyler: function(index, row) {\r\n");
      out.write("\t        \treturn 'background-color:#D3D3D3';\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t\t\t,emptyMsg:'<h2 style=\"color:red\">还没有添加角色</h2>'\r\n");
      out.write("\t\t\t,url:\"exmg/deptcontrol\"\r\n");
      out.write("\t\t\t,method:\"get\"\r\n");
      out.write("\t\t\t,toolbar:\"#empDatagrid_toolbardept\"//添加工具包\r\n");
      out.write("\t\t\t,pagination:true//分页\r\n");
      out.write("\t\t\t,fit:true\r\n");
      out.write("\t\t\t,fitColumns:true//所有列沾满一行\r\n");
      out.write("\t\t\t,singleSelect:true//只能单行选中\r\n");
      out.write("\t\t\t,pageList:[5,10,15]//设置每页记录可选的范围\r\n");
      out.write("\t\t\t,pageSize:10//默认每页记录数\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//刷新Datagrid\r\n");
      out.write("\tfunction initdeptcontroldatagrid(){\r\n");
      out.write("\t\t$(\"#deptcontrolDatagrid\").datagrid(\"reload\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t//插入部门\r\n");
      out.write("\tfunction insertdeptsWin(){\r\n");
      out.write("\t\t$.messager.prompt('新增部门', \"请输入需要添加的部门:\", function(r){\r\n");
      out.write("\t\t\tif (r){\r\n");
      out.write("\t\t\t\turl = \"exmg/insertdept?deptname=\"+r;\r\n");
      out.write("\t\t\t\t//$.ajaxSettings.async = false;\r\n");
      out.write("\t\t\t\t$.post(url,function(data){\r\n");
      out.write("\t\t\t\t\t\t//alert(data.result);\r\n");
      out.write("\t\t\t\t\tif(data.result==true){\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示\",\"成功插入新部门！\");\r\n");
      out.write("\t\t\t\t\t\tinitdeptcontroldatagrid();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示\",\"已有部门,无需重复插入！\");\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//删除部门\r\n");
      out.write("\tfunction deleteDept(data1,data2){\r\n");
      out.write("\t\t//alert(data);\r\n");
      out.write("\t\t var $deptname =  data2;\r\n");
      out.write("\t\turl= \"exmg/deletedept?deptno=\"+data1;\r\n");
      out.write("\t\t$.messager.confirm(\"操作提示\", \"确定要删除                          \"+$deptname+\t\"              吗？\", function (data) {\r\n");
      out.write("\t\t    if (data) {\r\n");
      out.write("\t\t\t\t$.post(url,function(data){\r\n");
      out.write("\t\t\t\t\tif(data.result){\r\n");
      out.write("\t\t\t\t\t\tinitdeptcontroldatagrid();\r\n");
      out.write("\t\t\t \t\t\t$.messager.alert(\"提示\",data.msg);\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示\",data.msg);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
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
