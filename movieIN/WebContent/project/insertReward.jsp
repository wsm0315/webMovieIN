<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/formCheck.js"></script>
<title>프로젝트 올리기 - 2R</title>
</head>
<body>
	<% int seq_PID = (Integer)request.getAttribute("seq_PID"); %>
	<h1>보상 입력</h1>
	<form action = "/movieIN/Project?action=insertReward" onSubmit="return formCheck(this)">
	<input type="hidden" name="seq_PID" value="<%=seq_PID%>" />
	<div>
	<label>투자금액 (필수) : </label> 
		<br> <input type="number" name="std_invest1" required />이하<br>
	<label>보상 (필수) : </label> 
		<input type="text" name="reward1" required />
	</div>
	<br>
	<div>
	<label>투자금액 (필수) : </label> 
		<br><input type="number" name="std_invest2" required />이하<br>
	<label>보상  (필수) : </label> 
		<input type="text" name="reward2" required />
	</div>
	<br>
	<div>
	<label>투자금액 : </label> 
		<br><input type="number" name="std_invest3" />이하<br>
	<label>보상 : </label> 
		<input type="text" name="reward3"  />
	</div>
	<br>
	<div>
	<label>투자금액 : </label> 
		<br><input type="number" name="std_invest4"  />이하<br>
	<label>보상 : </label> 
		<input type="text" name="reward4"  />
	</div>
	<br>
	<div>
	<label>투자금액 : </label> 
		<br><input type="number" name="std_invest5"  />이하<br>
	<label>보상 : </label> 
		<input type="text" name="reward5"  />
	</div>
	<input type="submit" value="저장"> <input type="reset" value="다시쓰기">
	</form>
</body>
</html>