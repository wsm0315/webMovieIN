<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/formCheck.js"></script>
<title>프로젝트 올리기 - 3</title>
</head>
<body>
	<% int seq_PID = (Integer)request.getAttribute("seq_PID"); %>
	<h1>회사정보 입력</h1>
	<form action = "/movieIN/Project?action=insertCompany" onSubmit="return formCheck(this)">
	<input type="hidden" name="seq_PID" value="<%=seq_PID%>" />
	<div>
	<label>회사 이름 : </label> 
		<input type="text" name="c_name" maxlength="10">
	</div>
	<div>
	<label>회사 소재지 : </label> 
		<input type="text" name="c_location" maxlength="26">
	</div>
	<div>
	<label>회사 설립일</label> 
		<input type="date" name="c_date" >
	</div>
	<div>
	<label>대표자명(필수) : </label> 
		<input type="text" name="c_eoname" maxlength="18" required>
	</div>
	<div>
	<label>임, 직원 수(필수) : </label> 
		<input type="number" name="c_emp" required>
	</div>
	<div>
	<label>범죄 이력 : </label> 
		<input type="text" name="c_crime" maxlength="6">
	</div>
	<div>
	<label>홈페이지 : </label> 
		<input type="text" name="c_site" maxlength="50">
	</div>
	<div>
	<label>이메일 : </label> 
		<input type="text" name="c_mail" maxlength="40">
	</div>
	<input type="submit" value="저장"> <input type="reset" value="다시쓰기">
</form>

</body>
</html>