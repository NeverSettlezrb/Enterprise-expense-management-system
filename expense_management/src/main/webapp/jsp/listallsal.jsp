<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <!-- 编码方式渲染一个datagrid -->
  <table id="listallsalDatagrid">
  <div id="empDatagrid_toolbar2"  >
	搜索:<input type="text" id="search" class='easyui-datebox' />
	<a href="javascript:void(0)" onclick="findsal()" class='easyui-linkbutton'>查询</a>
  </div>
  </table>
<script type="text/javascript">
$('#listsaldate').datebox({
	disabled:false
});
	//模糊查询
	function findsal(){	
		//1获取查询的参数
		var ename1 = $("#search").val();
		//2.让datagrid加载的时候，附带查询参数
		$("#listallsalDatagrid").datagrid("load",{
			ename:ename1
		});
	}

	$(function(){
		initallsalDatagrid();
	})	
	
	//初始化emp表格
	function initallsalDatagrid(){
		$("#listallsalDatagrid").datagrid({
			columns:[[
				{field:"sdata",title:"薪水发放日期",width:160,align:"center",sortable:true},
				{field:"username",title:"用户名",width:120,align:"center"},
				{field:"userid",title:"员工ID",width:120,align:"center"},
				{field:"name",title:"员工姓名",width:150,align:"center"},
				{field:"sal",title:"工资",width:120,align:"center",sortable:true},
			]]
			,rownumbers:true
			,rowStyler: function(index, row) {
		         //此处可以添加条件
		        return 'background-color:#D3D3D3';
		    }
			,emptyMsg:'<h2 style="color:red">没有相关记录，换个姿势搜索吧~</h2>'
			//本地获取数据，只是演示一下实际从远程服务器端获取数据较常见。
			//,data:datagridLocalData
			,url:"exmg/listsal"
			,method:"get"
			,toolbar:"#empDatagrid_toolbar2"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[5,10,15,20,100]//设置每页记录可选的范围
			,pageSize:10//默认每页记录数
		});
	}
	
	//刷新
	function initEmpdatagrid(){
		$("#listallsalDatagrid").datagrid("reload");
	}
</script>











  