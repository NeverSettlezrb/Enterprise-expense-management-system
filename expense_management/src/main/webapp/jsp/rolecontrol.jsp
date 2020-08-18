<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  

	<table id="rolecontrolDatagrid">
  		<div id="empDatagrid_toolbarrole">
  		<a href="javascript:void(0)" onclick="insertrolesWin()" class='easyui-linkbutton' data-options="iconCls:'icon-mini-add'">新增角色</a>
  		</div>
    </table>
  
<script type="text/javascript">
	$(function(){
		initRoleControlDatagrid();
	})	
	
	//初始化
	function initRoleControlDatagrid(){
		
		$("#rolecontrolDatagrid").datagrid({
			columns:[[
				{field:"rname",title:"角色名称",align:"center",width:160},
				{field:"qid",title:"操作",width:180,align:"center",formatter:function(v,r,i){// v 当前字段值, r为行对象, i为索引
					var rname = r.rname;
					var rid=r.rid;
					return"<a class='authority' href='javascript:void(0)' onclick='updatesauthorityWin(\""+rname+"\")'>权限管理</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;"+
					"<a class='删除角色' href='javascript:void(0)' onclick='deleteRole(\""+rid+"\"\,\""+rname+"\")'>删除角色</a>"
					
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
			,url:"exmg/rolecontrol"
			,method:"get"
			,toolbar:"#empDatagrid_toolbarrole"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[5,10,15]//设置每页记录可选的范围
			,pageSize:10//默认每页记录数
		});
	}
	
	
	//关闭角色赋权窗口
	function hideinsertroleWin(){
		var $win = $("#insertroleWin");
		$win.window("close");
		$win.remove();

	}
	//显示角色赋权窗口
	function insertroleWin(data){
			//动态的设置一个divid属性值updateEmpWin
			var $win = $("#insertroleWin");
			if($win.length==0){
				//不存在，就新添加到body中
				$win = $("<div id='insertroleWin'></div>");
				$win.appendTo(document.body);
			}
			//$.ajaxSettings.async = false;
			$win.window({
				title:"权限赋予",
				maximizable:false,
				minimizable:false,
				collapsible:false,
				width:660,
				height:560,
				modal:true//模式对话框，就时当前对话框不处理，背后的操作不能操作
				,href:"exmg/listrolemeunwin?rname="+data
				,method:"get"
			});	
			//initSetsaldatagrid();
			$win.window("center");//居中显示
		
	}
	
	
	//关闭权限管理窗口
	function hideupdatesauthorityWin(){
		var $win = $("#updateroleWin");
		$win.window("close");
		$win.remove();

	}
	//显示权限管理窗口 
	function updatesauthorityWin(data){
			//动态的设置一个divid属性值updateEmpWin
			var $win = $("#updateroleWin");
			if($win.length==0){
				//不存在，就新添加到body中
				$win = $("<div id='updateroleWin'></div>");
				$win.appendTo(document.body);
			}
			//$.ajaxSettings.async = false;
			$win.window({
				title:"权限修改",
				maximizable:false,
				minimizable:false,
				collapsible:false,
				width:660,
				height:560,
				modal:true//模式对话框，就时当前对话框不处理，背后的操作不能操作
				,href:"exmg/listupdaterolemeunwin?rname="+data
				,method:"get"
			});	
			//initSetsaldatagrid();
			$win.window("center");//居中显示
		
	}
	

	//刷新Datagrid
	function initrolecontroldatagrid(){
		$("#rolecontrolDatagrid").datagrid("reload");
	}
	

	function insertrolesWin(){
		$.messager.prompt('新增角色', "第一步  请输入需要添加的角色:", function(r){
			if (r){
				url = "exmg/insertrole?rname="+r;
				//$.ajaxSettings.async = false;
				$.post(url,function(data){
						//alert(data.result);
					if(data.result==true){
						//$.messager.alert("提示","成功插入新角色，第二步:请继续为角色赋权！");
						initrolecontroldatagrid();
						insertroleWin(r);
					}else{
						$.messager.alert("提示","重复角色！插入角色失败，请重试！");
					};
				});
			}
		});
	}

	//删除角色
	function deleteRole(data1,data2){
		//alert(data);
		 var $rname =  data2;
		url= "exmg/deleterole?rid="+data1;
		$.messager.confirm("操作提示", "确定要删除                          "+$rname+	"              吗？", function (data) {
		    if (data) {
				$.post(url,function(data){
					if(data.result){
						initrolecontroldatagrid();
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