<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <table id="allreportDatagrid">
  	<div id="allreportDatagrid_toolbar1">
  	</div>
  </table>
<script type="text/javascript">


	$(function(){
		initallreportDatagrid();
	})	
	
	//初始化emp表格
	function initallreportDatagrid(){
		
		$("#allreportDatagrid").datagrid({
			columns:[[
				{field:"userid",title:"员工ID",width:80,align : 'center'},
				{field:"name",title:"姓名",width:60,align : 'center'},
				{field:"money",title:"报销金额",width:120,align : 'center'},
				{field:"tips",title:"报销原因",width:300,align : 'center'},
				{field:"redate",title:"报销日期",width:160,align : 'center'},
				{field:"jingli",title:"经理审核情况",width:120,align : 'center',
	                formatter : function(value,row,index){
	                    if(value=='0'){return '<b style="color:blue">'+'待经理审核'+'</b>';}  
	                    else if(value=='1'){
	                    return '<b style="color:green">'+'已通过！'+'</b>';
	                    }else if(value=='2'){
	                    return '<b style="color:red">'+'审核不通过！'+'</b>'
	                    }       
	                  }},
				{field:"caiwu",title:"财务审核情况",width:160,align : 'center',
	  	                formatter : function(value,row,index){
		                    if(value=='0'){return '<b style="color:blue">'+'待财务审核'+'</b>'}  
		                    else if(value=='1'){
		                    return '<b style="color:green">'+'已通过！'+'</b>';
		                    }else if(value=='2'){
			                    return '<b style="color:red">'+'审核不通过！'+'</b>'
		                    }else if(value=='3'){
			                    return '--'
		                    }
		                  }},
		                  {field:"finallys",title:"最终状态",width:160,align : 'center',
			  	                formatter : function(value,row,index){
				                    if(value=='0'){return '<b style="color:blue">'+'审核中...'+'</b>'}  
				                    else if(value=='1'){
				                    return '<b style="color:green">'+'已通过！'+'</b>';
				                    }else if(value=='2'){
					                    return '<b style="color:red">'+'不通过！'+'</b>'
				                    }
				                  }},
		       {field:"qid",title:"操作",width:100,align:"center",formatter:function(v,r,i){// v 当前字段值, r为行对象, i为索引
		    	   		var reid = r.reid;
		  				return "<a class='cehhuishenpi' href='javascript:cehhuishenpi(\""+reid+"\")'>撤回重新审批</a>"
		  				
		  				}}
			]]
			, onLoadSuccess:function (data) {
            	$(".cehhuishenpi").linkbutton({plain:true, iconCls:'icon-back' });
    		}
			,rownumbers:true
			,rowStyler: function(index, row) {
	        	return 'background-color:#D3D3D3';
	    	}
			,emptyMsg:'<h2 style="color:red">没有相关记录！</h2>'
			,url:"exmg/listreport?username="
			,method:"get"
			,toolbar:"#allreportDatagrid_toolbar1"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[10,20,50]//设置每页记录可选的范围
			,pageSize:10//默认每页记录数
		});
	}
	
	//刷新empDatagrid
	function initAllReportdatagrid(){
		$("#allreportDatagrid").datagrid("reload");
	}
	
	function cehhuishenpi(data){
		url="exmg/backcheckreport?reid="+data;
		$.post(url,function(data){
			 if(data){
				 if(data.result){
					 	$.messager.alert("提示",data.msg);
					 	initAllReportdatagrid();
	 				}else{	
	 					$.messager.alert("提示",data.msg);
	 				}
		 	}
		});
	}
</script>











  