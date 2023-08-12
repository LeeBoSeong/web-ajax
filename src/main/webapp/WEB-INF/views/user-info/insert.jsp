<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름:
	<input type="text" id="uiName">
	<br> 아이디:
	<input type="text" id="uiId">
	<br> 비번:
	<input type="password" id="uiPwd">
	<br> 소개:
	<textarea id="uiDesc"></textarea>
	<br> 생년월일:
	<input type="text" id="uiBirth">
	<br>
	<button onclick="sendObj()">확인</button>
</body>
<script>
	function sendObj() {
		const param = {
			uiName : document.querySelector('#uiName').value,
			uiId : document.querySelector('#uiId').value,
			uiPwd : document.querySelector('#uiPwd').value,
			uiDesc : document.querySelector('#uiDesc').value,
			uiBirth : document.querySelector('#uiBirth').value
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/user-info/insert');
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					if (xhr.responseText === '1') {
						alert('성공');
					} else {
						alert('실패');
					}
					location.href='/views/user-info/list';
				}
			}
		}
		xhr.send(json);
	}
</script>
</html>