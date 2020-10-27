<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$.get("/gradle_spring_webmvc_study/api/members",
			function(json){
		var dataLength = json.length;
		if(dataLength >= 1){
			var sCont = "";
			for(i=0; i<dataLength; i++){
				sCont += "<tr>";
				sCont += "<td>" + json[i].id + "</td>";
				sCont += "<td><a href='members/"+json[i].id+"'>"
						+ json[i].name + "</a></td>";
				sCont += "<td>" + json[i].email + "</td>";
				sCont += "<td>" + json[i].registerDataTime + "</td>";
				sCont += "</tr>";
			}
			$("#load:last-child").append(sCont);
		}
	});
});
</script>
</head>
<body>
	<table border="1">
		<thead>
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
			<th>가입일</th>
		</thead>
		<tbody id="load">
		</tbody>	
	</table>
</body>
</html>