<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <!-- 编码方式渲染一个datagrid -->
  <table id="userMsgDatagrid">
  <div id="empDatagrid_toolbaruser23">
  	<input id="ss" class="easyui-searchbox" style="width:250px"
    	data-options="searcher:user,prompt:'搜索(id/姓名/用户名)'"></input>
  
	<a href="javascript:void(0)" onclick="insertUserWin()" class='easyui-linkbutton' data-options="iconCls:'icon-mini-add'" style="float:right">添加新人员</a>
  </div>
  </table>
<script type="text/javascript">
	//搜索
	function user(value){
    	//alert(value)
    	
		$("#userMsgDatagrid").datagrid("load",{
			ename:value
		});
    }

	$('#saldate').datebox({
		disabled:true
	});
	
	$(function(){
		initlistuserDatagrid();
	})	
	
	//初始化emp表格
	function initlistuserDatagrid(){
		$("#userMsgDatagrid").datagrid({
			columns:[[
				{field:'userid',title:"员工ID",width:100,align:"center"},
				{field:'username',title:"用户名",width:150,align:"center"},
				{field:"name",title:"姓名",width:150,align:"center"},
				{field:"age",title:"年龄",width:50,align:"center"},
				{field:"phone",title:"手机号",width:150,align:"center"},
				{field:"email",title:"电子邮箱",width:150,align:"center"},
				{field:"gender",title:"性别",width:50,align:"center"},
				{field:"rname",title:"职位",width:180,align:"center"},
				{field:"deptname",title:"部门",width:150,align:"center"},
				{field:"hire",title:"入职日期",width:120,align:"center",sortable:true},
				{field:"qid",title:"操作",width:180,align:"center",formatter:function(v,r,i){// v 当前字段值, r为行对象, i为索引
					var username = r.username;
					var userid= r.userid;
					var index= i;
					return"<a class='修改工资' href='javascript:void(0)' onclick='updatesUserWin(\""+username+"\")'>修改信息</a>&nbsp&nbsp;"+
					"<a class='离职' href='javascript:void(0)' onclick='deleteUser(\""+userid+"\")'>离职</a>"
				}}
			]],
			//启用editor
			 onLoadSuccess:function (data) {
                        $(".修改工资").linkbutton({plain:true, iconCls:'icon-edit' });
                        $(".离职").linkbutton({plain:true, iconCls:'icon-cancel' });
                }
			,rowStyler: function(index, row) {
		        return 'background-color:#D3D3D3';
		    }
			,rownumbers:true
			,singleSelect:false
			,selectOnCheck:false	
			,emptyMsg:'<h2 style="color:red">换个姿势搜索吧~没有相关记录！</h2>'
			,url:"exmg/listusers"
			,method:"get"
			,toolbar:"#empDatagrid_toolbaruser23"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[20,40,60,100]//设置每页记录可选的范围
			,pageSize:20//默认每页记录数
		});
	}
	
	//刷新Datagrid
	function initupdateuserdatagrid(){
		$("#userMsgDatagrid").datagrid("reload");
	}
	
	//关闭修改的window新加成员
	function hideInsertUserWin(){
		var $win = $("#insertuserWin");
		$win.window("close");
		$win.remove();

	}
	//显示修改的window新加成员
	function insertUserWin(){
			//动态的设置一个divid属性值updateEmpWin
			var $win = $("#insertuserWin");
			if($win.length==0){
				//不存在，就新添加到body中
				$win = $("<div id='insertuserWin'></div>");
				$win.appendTo(document.body);
			}
			//$.ajaxSettings.async = false;
			$win.window({
				title:"修改员工工资",
				maximizable:false,
				minimizable:false,
				collapsible:false,
				width:660,
				height:560,
				modal:true//模式对话框，就时当前对话框不处理，背后的操作不能操作
				,href:"exmg/insertuser"
				,method:"get"
			});
			//initSetsaldatagrid();
			$win.window("center");//居中显示
		
	}
	
	
	
	//关闭修改的window更新
	function hideupdatesUserWin(){
		var $win = $("#updatesuserWin");
		$win.window("close");
		$win.remove();

	}
	//显示修改的window更新
	function updatesUserWin(data){
			//动态的设置一个divid属性值updateEmpWin
			var $win = $("#updatesuserWin");
			if($win.length==0){
				//不存在，就新添加到body中
				$win = $("<div id='updatesuserWin'></div>");
				$win.appendTo(document.body);
			}
			//$.ajaxSettings.async = false;
			$win.window({
				title:"修改员工工资",
				maximizable:false,
				minimizable:false,
				collapsible:false,
				width:660,
				height:560,
				modal:true//模式对话框，就时当前对话框不处理，背后的操作不能操作
				,href:"exmg/listupdatesusers?username="+data
				,method:"get"
			});	
			//initSetsaldatagrid();
			$win.window("center");//居中显示
		
	}
	
	//删除用户
	function deleteUser(data){
		//alert(data);
		url= "exmg/deleteuser?userid="+data;
		$.messager.confirm("操作提示", "确定要去除此员工吗？", function (data) {
		    if (data) {
				$.post(url,function(data){
					if(data){
						 if(data.result){
							 hideupdatesUserWin();
							initupdateuserdatagrid();
			 				}
			 		$.messager.alert("提示",data.msg);
					}
				});
		}else {
			return false;
		}
		});
	}
	
	
	
	
	

</script>











  