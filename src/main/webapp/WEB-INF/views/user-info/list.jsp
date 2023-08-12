<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕안녕 나는 리스트
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>생일</th>
		</tr>
		<tbody id="tbody">
		</tbody>
		<tr>
			<td><button onclick="location.href='/views/user-info/insert'">등록</button>
		</tr>
	</table>
</body>

<script>
	window.addEventListener('load',function(){
		const xhr = new XMLHttpRequest();
		xhr.open('GET','/user-info/list');
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					const user = JSON.parse(xhr.responseText);
					let html ='';
					for(const userInfo of user){
						html += '<tr>';
						html += '<td>'+ userInfo.uiNum + '</td>';
						html += '<td>'+ userInfo.uiId + '</td>';
						html += '<td><a href="/views/user-info/view?uiNum=' + userInfo.uiNum +'">' + userInfo.uiName + '</a></td>';
						html += '<td>'+ userInfo.uiBirth + '</td>';					
						html += '</tr>';
					}
					document.querySelector('#tbody').innerHTML = html;
				}
			}
		}
		xhr.send();
	})
	
</script>
</html>