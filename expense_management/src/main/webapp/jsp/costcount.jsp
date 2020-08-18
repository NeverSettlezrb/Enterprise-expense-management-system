<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<div id="container" style="height:400px"></div>
<table class="highchart table" 
	   data-graph-container="#container" data-graph-type="column" style="display:none">
	<caption>报销统计</caption>
	<thead>
		<tr>
			<th width="100px">月份</th>
			<th width="100px">月报销总金额</th>
		</tr>
	</thead>
	<tbody>
		<!--<c:forEach items="${result}" var="li">
 				<tr>
 					<td><c:out value="${li.month}" /></td>
					<td><c:out value="${li.money}" /></td>
				</tr>
		</c:forEach>-->
				<tr>
 					<td><c:out value="1" /></td>
					<td><c:out value="2345" /></td>
				</tr>
				<tr>
 					<td><c:out value="2" /></td>
					<td><c:out value="4444" /></td>
				</tr>
				<tr>
 					<td><c:out value="3" /></td>
					<td><c:out value="2312" /></td>
				</tr>
				<tr>
 					<td><c:out value="4" /></td>
					<td><c:out value="3243" /></td>
				</tr>
				<tr>
 					<td><c:out value="5" /></td>
					<td><c:out value="5450" /></td>
				</tr>
				<tr>
 					<td><c:out value="6" /></td>
					<td><c:out value="21433" /></td>
				</tr>
				<tr>
 					<td><c:out value="7" /></td>
					<td><c:out value="6444" /></td>
				</tr>
				<tr>
 					<td><c:out value="8" /></td>
					<td><c:out value="6455" /></td>
				</tr>
				<tr>
 					<td><c:out value="9" /></td>
					<td><c:out value="" /></td>
				</tr>
				<tr>
 					<td><c:out value="10" /></td>
					<td><c:out value="0" /></td>
				</tr>
				<tr>
 					<td><c:out value="11" /></td>
					<td><c:out value="0" /></td>
				</tr>
				<tr>
 					<td><c:out value="12" /></td>
					<td><c:out value="0" /></td>
				</tr>
	</tbody>
</table>

<script  type="text/javascript">
$(document).ready(function(){
	$('table.highchart').highchartTable();	
});
/*
function init(){
$.post("exmg/costcount",function(data){
		var $tr=$("#x1");
		var html="";
		//alert(data[1].month);
		for (var p in data) {
			html+="<td>"+data[p].month+"</td>"+"<td>"+300+"</td>";
		}
		//salert(html);
		$("#x1").html(html);
		
	});
}*/

</script>