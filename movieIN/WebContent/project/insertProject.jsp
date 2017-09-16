<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/formCheck.js"></script>
<title>프로젝트 올리기 - 1</title>
</head>
<body>
	<h1>프로젝트 정보 입력</h1>
	<form action = "/movieIN/Project?action=insertProject" onSubmit="return formCheck(this)">
	<!-- 
	project.setImgurl(request.getParameter("imgurl")); -->
	<div>
	<label>프로젝트 이름 (필수) : </label> 
		<input type="text" name="proj" maxlength="34" required>
	</div>
	<div>
	<label>목표 금액(필수) : </label> 
		<input type="number" name="m_target" required>
	</div>
	<div>
	<label>마감일(필수) : </label> 
		<input type="date" name="enddate" required>
	</div>
	<div>
	<label>투자받을 최대금액  : </label> 	
		<input type="number" name="m_max" min="0">
	</div>
	<div>
	<label>투자받을 최소금액 : </label> 
		<input type="number" name="m_min" min="0">
	</div>
	<div>
	<label>투자받을 형태(필수) : </label> 
		<select name="inv_type" required>
			<option value="I">투자형</option>
			<option value="R">보상형</option>
		</select>
	</div>
	<div>
	<label>투자금 사용 목적 (필수) : </label> 
		<select name="purpose" required>
			<option value="import">영화 수입</option>
			<option value="marketing">마케팅</option>
			<option value="reshow">재개봉</option>
			<option value="newMake">영화 제작</option>
		</select>
	</div>
	
	<!-- 파일 업로드 부분에서는 좀 생각을 해야할 것 같음. -->
	<div>
	<label>프로젝트 이미지 : </label> 
		<input type="file" name="imgurl" accept="image/*" required>
	</div>
	<input type="submit" value="저장"> <input type="reset" value="다시쓰기">
</form>

</body>
</html>