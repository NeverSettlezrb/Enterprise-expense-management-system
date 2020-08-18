<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <!-- 编码方式渲染一个datagrid -->
  <table id="setsalDatagrid">
  <div id="empDatagrid_toolbar3">
	<a href="javascript:void(0)" onclick="setallsal()" class='easyui-linkbutton' data-options="iconCls:'icon-add'" style="float:right">一键发放</a>
   	<input id="saldate" type="text" class="easyui-datebox" value="d" />
  </div>
  </table>
<script type="text/javascript">
	$('#saldate').datebox({
		disabled:true
		
	});
	
	$(function(){
		initsetsalDatagrid();
	})	
	
	//初始化emp表格
	function initsetsalDatagrid(){
		$("#setsalDatagrid").datagrid({
			columns:[[
				{field:"ck",title:"ck",width:150,align:"center",checkbox:"true"	},
				{field:"name",title:"姓名",width:150,align:"center",rownumbers:true},
				{field:'userid',title:"员工ID",width:150,align:"center"},
				{field:"sal",title:"工资",width:120,align:"center",editor:{
                    type:"numberbox"
                }},
				{field:"qid",title:"操作",width:180,align:"center",formatter:function(v,r,i){// v 当前字段值, r为行对象, i为索引
					var username = r.username;
					//alert(typeof $('#saldate').val());
					var data =$('#saldate').val();
					var index= i;
					//alert(typeof data);
						//var ele =  $("#setsalDatagrid").datagrid("getEditor",{index:2,field:"sal"});   \,\""+ ele+"\"
					return "<a class='确认发放' href='javascript:insertsal(\""+username+"\")'>确认发放</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;"
					+"<a class='修改工资' href='javascript:showUpdateEmpWin(\""+username+"\"\,\""+data+"\"\,\""+index+"\")'>修改工资</a>"
				}}
                ,{field:'sdata',title:"上一次操作日期",width:150,align:"center"}
			]],
			//启用editor
			 onLoadSuccess:function (data) {
				 
                    for(var i=0;i<data.total;i++){
                        $(this).datagrid("beginEdit",i);
                        $(".确认发放").linkbutton({plain:true, iconCls:'icon-save' });
                        $(".修改工资").linkbutton({plain:true, iconCls:'icon-edit' });
                    }
                }
			//,data:datagridLocalData
			//,idField:'id'
			,rowStyler: function(index, row) {
		         //此处可以添加条件
		        return 'background-color:#D3D3D3';
		    }
			,rownumbers:true
			,singleSelect:false
			,selectOnCheck:false	
			,emptyMsg:'<h2 style="color:red">没有相关记录！</h2>'
			,url:"exmg/listsetsal"
			,method:"get"
			,toolbar:"#empDatagrid_toolbar3"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[20,40,60,100]//设置每页记录可选的范围
			,pageSize:20//默认每页记录数
		});
	}
	
	//刷新empDatagrid
	function initSetsaldatagrid(){
		$("#setsalDatagrid").datagrid("reload");
	}
	
	//关闭修改的window
	function hideUpdateEmpWin(){
		var $win = $("#updateEmpWin");
		$win.window("close");
		$win.remove();

	}
	//显示修改的window
	function showUpdateEmpWin(username,data,i,j){
			//if(j!=null||j!=""){
			if(j=="2000-02-06"){
			//动态的设置一个divid属性值updateEmpWin
			var $win = $("#updateEmpWin");
			if($win.length==0){
				//不存在，就新添加到body中
				$win = $("<div id='updateEmpWin'></div>");
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
				,href:"exmg/listsalupdate?username="+username+"&sdata="+data
				,method:"get"
			});
			//initSetsaldatagrid();
			$win.window("center");//居中显示
		}else{
		var row = $('#setsalDatagrid').datagrid('getData').rows[i];
		//alert(row.sdata);
		if(row.sdata=="1999-11-30"){
			$.messager.alert("提示","还没有为该员工发过工资哦,不能进行修改！");
		}else{
			
		//动态的设置一个divid属性值updateEmpWin
		var $win = $("#updateEmpWin");
		if($win.length==0){
			//不存在，就新添加到body中
			$win = $("<div id='updateEmpWin'></div>");
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
			,href:"exmg/listsalupdate?username="+username+"&sdata="+data
			,method:"get"
		});
		$win.window("center");//居中显示
		//initSetsaldatagrid();
		}
		}
	}
	
	
	//发放工资
	function insertsal(username){
		var index=$("#setsalDatagrid").datagrid("selectRecord",username);//选中指定行
		var row =$("#setsalDatagrid").datagrid('getSelected')//获取选中的行
		var data = $("#setsalDatagrid").datagrid("getRowIndex",row);//获取选中行的索引
		var ele = $("#setsalDatagrid").datagrid("getEditor",{index:data,field:"sal"});//选中编辑框的
		var val = $(ele.target).val();//获取编辑框里的值
		//alert($("#saldate").val());
		//alert(val);
		if(val==null||val==""||val==0){
			$.messager.alert("提示","若需发放工资，工资不能为空！");
		}else{
			$.messager.confirm("操作提示", "确定要提交该员工工资吗？", function (data) {
			    if (data) {
					//alert(typeof val);
					$.get("exmg/setsal?sal="+val+"&sdata="+$("#saldate").val()+"&username="+username,function(data){
						//alert(data.verify)
						//alert(data.setsal)
						if(data.verify==0){
							if(data.setsal==1){
								$.messager.alert("提示","工资已成功发放~");
								initSetsaldatagrid();
							}else{
								$.messager.alert("提示","没有成功，在尝试一下哦~");
								initSetsaldatagrid();
							}
						}else{
							initSetsaldatagrid();
							$.messager.alert("提示","近期已经为该人员发放过工资！不能再次操作！");
							initSetsaldatagrid();
						}
					})
			     }else {
			    	 return false;
			     }
			});
		}
		
		
	}
	
	
	//一键发放工资功能
	function setallsal(){
		$.messager.confirm("操作提示", "确定要提交选中员工工资吗？", function (data) {
			if (data) {
				//循环存放数据
				 //$(this).datagrid('clearChecked');
				 var data = $("#setsalDatagrid").datagrid("getChecked");
		         
				for(var i=0;i<data.length;i++){
					//var username = data[i].id;
					 var indexs = $("#setsalDatagrid").datagrid("getRowIndex",data[i]);
		             var ele = $("#setsalDatagrid").datagrid("getEditor",{index:indexs,field:"sal"});
		             data[i]["sal"] = $(ele.target).val();
		         }
				//alert(data[i].username+"   "+data[i].sal);
				//循环判断sal是否为空
						//alert(data.length);
				var countsalisnull=0;
				for(var i=0;i<data.length;i++){
					if(data[i]["sal"]==null||data[i]["sal"]==""||data[i]["sal"]==0){
						countsalisnull=countsalisnull+1;
					}
				}
				if(data[0]==null||data[0]==""){
					$.messager.alert("提示","请先选择需要修改的人员!");
				}else{
					if(countsalisnull!=0){
						$.messager.alert("提示","选中的员工有工资为空的，请修改!");
					}else{
						var lists="员工:";
						//循环读取数据
						for(var i=0;i<data.length;i++){
				        	//console.info(data[i].username+"   "+data[i].sal);  	
				     			//alert(results);
				     		function test(conCats){
				     			$.ajaxSettings.async = false;
				     			$.get("exmg/setsal?sal="+data[i].sal+"&sdata="+$("#saldate").val()+"&username="+data[i].username,function(data){
				     				if(data.verify==0){
				     				}else{
				     					initSetsaldatagrid();
				     					conCats(data.name);
				     					//alert(data.name);
				     					//$.messager.alert("提示","员工"+data.name+"近期已放过工资！不再发放！");
				     				}
				     			});
				     			 $.ajaxSettings.async = true;
				     			}
				     		//拼接函数
				     		
				     		test(function(data){
				     			concats2(data);
				     		})
				     		
				     		
				     		function concats2(data){
				     			//alert(data);
				     			if(lists=="员工:"){
				     				if(data=="没有人员了!"){
				     					lists="";
				     				}else{			
				     					lists = lists+data;
				     				}
				     			}else{
				     				if(data=="没有人员了!"){
				     					lists= lists+"近期已经发放过工资，不能重复发放，其他员工";
				     					initSetsaldatagrid();
				     				}else{	
				     					lists= lists+"、"+data;
				     				}
				     			}
				     			return lists;
				     		}
				     		
				    	};
				    	$.messager.alert("提示",concats2("没有人员了!")+"工资已全部发放成功~");
				    	initSetsaldatagrid();
				    	//$.messager.alert("提示","工资已全部发放成功~");
					}
				}
			}else {
				return false;
			};
		});//*/
         
	}
	
	

</script>











  