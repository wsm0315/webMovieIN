<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/formCheck.js"></script>
<title>프로젝트 올리기 - 2I</title>
</head>
<body>
	<% int seq_PID = (Integer)request.getAttribute("seq_PID"); %>
	<h1>이자율 입력</h1>
	<form action = "/movieIN/Project?action=insertInterest" onSubmit="return formCheck(this)">
	<input type="hidden" name="seq_PID" value="<%=seq_PID%>" />
	<div>
	<label>관객수 (필수) : </label> 
		<br><input type="number" name="audience1" required />이하<br>
	<label>이자율 (필수) : </label> 
		<input type="number" name="interest1" step="any" required />%
	</div>
	<br>
	<div>
	<label>관객수 (필수) : </label> 
		<br><input type="number" name="audience2" required />이하<br>
	<label>이자율  (필수) : </label> 
		<input type="number" name="interest2" step="any" required />%
	</div>
	<br>
	<div>
	<label>관객수 : </label> 
		<br><input type="number" name="audience3" />이하<br>
	<label>이자율 : </label> 
		<input type="number" name="interest3" step="any"  />%
	</div>
	<br>
	<div>
	<label>관객수 : </label> 
		<br><input type="number" name="audience4"  />이하<br>
	<label>이자율 : </label> 
		<input type="number" name="interest4" step="any"  />%
	</div>
	<br>
	<div>
	<label>관객수 : </label> 
		<br><input type="number" name="audience5"  />이하<br>
	<label>이자율 : </label> 
		<input type="number" name="interest5" step="any"  />%
	</div>
	<input type="submit" value="저장"> <input type="reset" value="다시쓰기">
	</form>
</body>
</html>