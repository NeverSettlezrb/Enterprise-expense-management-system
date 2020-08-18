<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath }/"/>
<title>费用管理信息系统主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="../themes/bootstrap/easyui.css">
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="jquery.easyui.min.js"></script>
<script type="text/javascript" src="locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery.highchartTable.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>
</head>
<!-- layout -->
<body class="easyui-layout">
<input id="attrs" type="hidden" value="${sessionScope.usersname }" />
<input id="attrid" type="hidden" value="${sessionScope.userid }" />
<input id="time0" type="hidden" value="60" />
<input id="time" type="hidden" value="" />

	<div data-options="region:'north',title:'费用管理信息系统'" style="height:100px">
		
		<h2 align="right" style=" float:right">欢迎登录:${sessionScope.usersname }
		<a href='javascript:loginout()' style="float:right;padding-right: 20px ;color: darkgray;" >退出</a>&nbsp
		<a href='javascript:showUserSetWin("username")' style="float:right;padding-right: 5px ;color: darkgray;" >设置</a></h2>
	</div>
	<div data-options="region:'west',title:'菜单'" style="width:180px" >
		<div></div>
		<ul id="menu">
			
		</ul>
	</div>
	<div data-options="region:'center',title:'主界面'" style="padding:3px">
		<div class='easyui-tabs' id="mytabs" data-options="fit:true">
			<div data-options="title:'主页'" style="background:url('../img/专业团队.png');opacity:0.75;">
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	
	//禁止浏览器返回
	$(function() {
		if($("#attrid").val()==null||$("#attrid").val()==""){
			window.location.href="exmg/login";
		}	
		if (window.history && window.history.pushState) {
			$(window).on('popstate', function () {
				window.history.pushState('forward', null, 'jsp/HomePage.jsp?username='+$("#attrs").val());
				window.history.forward(1);
			});
		}
		window.history.pushState('forward', null, 'jsp/HomePage.jsp?username='+$("#attrs").val()); 
		window.history.forward(1);
	})

	$(function(){
		$("#time").val($("#time0").val());
		initMenus();
	})
	
	//初始化菜单
	function initMenus(){
		
		$("#menu").tree({
			url:'exmg/getmenu?username='+$("#attrs").val()
			//要想树中的节点（无论根节点还是叶子节点）点击之后会打开新的tab页
			//那么要为树加上鼠标点击事件
			,onClick:function(node){
				//alert(node.mname)
				var title = node.text;
				//获取节点上面的自定义属性url，一旦有url就证明是叶子节点，反之是根节点
				//叶子节点才需要处理
				if(node.attributes){
					var url = node.attributes.url;
					if(url){
						if(url=="jsp/costcount.jsp"){
							$.post("exmg/costcount",function(data){
								addNewTab(title,"exmg/costcount");
							});
							
						}else{
						
						}
						addNewTab(title,url);
					}
				}
			}
		});
	}
	
	//新建标签页（如果没有就新建，如果存在了，就选中它）
	function addNewTab(title,url){
		var $mytabs = $("#mytabs");
		var $currTab = $mytabs.tabs("getTab",title);
		if(!$currTab){
			//不存在
			$mytabs.tabs("add",{
				title:title,
				closable:true,
				href:url,
				fit:true
			});
		}else{
			//存在
			$mytabs.tabs("select",title);
			var tab = $mytabs.tabs('getSelected');  // get selected panel
			tab.panel('refresh', url);
		}
	}
	
	//退出
	function loginout(){
		window.location.href="exmg/login";
		//alert("a");

	}
	
	
	//关闭修改的window
	function hideUserSetWin(){	
		var $win = $("#updateUserWin");
		$win.window("close");
		$win.remove();

	}
	//显示修改的window
	function showUserSetWin(empno){
		var $win = $("#updateUserWin");
		if($win.length==0){
			$win = $("<div id='updateUserWin'></div>");
			$win.appendTo(document.body);
		}
		$win.window({
			title:"账户与密码设置",
			maximizable:false,
			minimizable:false,
			collapsible:false,
			width:660,
			height:560,
			modal:true
			,href:"exmg/setusername_pw?username="+$("#attrid").val()
			,method:"post"
		});
		$win.window("center");//居中显示
	}
	
	
	
</script>