<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  

	<table id="deptcontrolDatagrid">
  		<div id="empDatagrid_toolbardept">
  		<a href="javascript:void(0)" onclick="insertdeptsWin()" class='easyui-linkbutton' data-options="iconCls:'icon-mini-add'">新增部门</a>
  		</div>
    </table>
  
<script type="text/javascript">
	$(function(){
		initDeptControlDatagrid();
	})	
	
	//初始化
	function initDeptControlDatagrid(){
		
		$("#deptcontrolDatagrid").datagrid({
			columns:[[
				{field:"deptname",title:"部门名称",align:"center",width:160},
				{field:"qid",title:"操作",width:180,align:"center",formatter:function(v,r,i){// v 当前字段值, r为行对象, i为索引
					var deptname = r.deptname;
					var deptno=r.deptno;
					return"<a class='删除角色' href='javascript:void(0)' onclick='deleteDept(\""+deptno+"\"\,\""+deptname+"\")'>删除部门</a>"
					
					
				}}
			]],
			onLoadSuccess:function (data) {
	        	$(".authority").linkbutton({plain:true, iconCls:'icon-edit' });
	        	$(".删除角色").linkbutton({plain:true, iconCls:'icon-cancel' });
			}
			,rownumbers:true
			,rowStyler: function(index, row) {
	        	return 'background-color:#D3D3D3';
	    	}
			,emptyMsg:'<h2 style="color:red">还没有添加角色</h2>'
			,url:"exmg/deptcontrol"
			,method:"get"
			,toolbar:"#empDatagrid_toolbardept"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[5,10,15]//设置每页记录可选的范围
			,pageSize:10//默认每页记录数
		});
	}
	
	//刷新Datagrid
	function initdeptcontroldatagrid(){
		$("#deptcontrolDatagrid").datagrid("reload");
	}
	

	//插入部门
	function insertdeptsWin(){
		$.messager.prompt('新增部门', "请输入需要添加的部门:", function(r){
			if (r){
				url = "exmg/insertdept?deptname="+r;
				//$.ajaxSettings.async = false;
				$.post(url,function(data){
						//alert(data.result);
					if(data.result==true){
						$.messager.alert("提示","成功插入新部门！");
						initdeptcontroldatagrid();
					}else{
						$.messager.alert("提示","已有部门,无需重复插入！");
					};
				});
			}
		});
	}

	//删除部门
	function deleteDept(data1,data2){
		//alert(data);
		 var $deptname =  data2;
		url= "exmg/deletedept?deptno="+data1;
		$.messager.confirm("操作提示", "确定要删除                          "+$deptname+	"              吗？", function (data) {
		    if (data) {
				$.post(url,function(data){
					if(data.result){
						initdeptcontroldatagrid();
			 			$.messager.alert("提示",data.msg);
					}else{
						$.messager.alert("提示",data.msg);
					}
				});
		}else {
			return false;
		}
		});
	}

</script>