<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/formCheck.js"></script>
<title>프로젝트 올리기 - 4</title>
</head>
<body>
	<% int seq_PID = (Integer)request.getAttribute("seq_PID"); %>
	<h1>영화 정보 입력</h1>
	<form action = "/movieIN/Project?action=insertMovie" onSubmit="return formCheck(this)">
	<input type="hidden" name="seq_PID" value="<%=seq_PID%>" />
	<div>
	<label>작품명(필수) : </label> 
		<input type="text" name="title" maxlength="20">
	</div>
	<div>
	<label>장르 : </label> 
		<select name="genre1" required>
			<option value="sf">sf</option>
			<option value="사극">사극</option>
			<option value="액션">액션</option>
			<option value="드라마">드라마</option>
			<option value="범죄">범죄</option>
			<option value="코미디">코미디</option>
			<option value="스릴러">스릴러</option>
			<option value="어드벤처">어드벤처</option>
			<option value="판타지">판타지</option>
			<option value="전쟁">전쟁</option>
			<option value="서부극">서부극</option>
			<option value="멜로/로맨스">멜로/로맨스</option>
			<option value="가족">가족</option>
			<option value="애니메이션">애니메이션</option>
			<option value="공포">공포</option>
			<option value="다큐멘터리">다큐멘터리</option>
			<option value="미스터리">미스터리</option>
			<option value="뮤지컬">뮤지컬</option>
			<option value="공연">공연</option>
			<option value="기타">기타</option>
		</select>
	</div>
	<div>
	<label>장르 : </label> 
		<select name="genre2">
			<option value="sf">sf</option>
			<option value="사극">사극</option>
			<option value="액션">액션</option>
			<option value="드라마">드라마</option>
			<option value="범죄">범죄</option>
			<option value="코미디">코미디</option>
			<option value="스릴러">스릴러</option>
			<option value="어드벤처">어드벤처</option>
			<option value="판타지">판타지</option>
			<option value="전쟁">전쟁</option>
			<option value="서부극">서부극</option>
			<option value="멜로/로맨스">멜로/로맨스</option>
			<option value="가족">가족</option>
			<option value="애니메이션">애니메이션</option>
			<option value="공포">공포</option>
			<option value="다큐멘터리">다큐멘터리</option>
			<option value="미스터리">미스터리</option>
			<option value="뮤지컬">뮤지컬</option>
			<option value="공연">공연</option>
			<option value="기타">기타</option>
		</select>
	</div>
	<div>
	<label>장르 : </label> 
		<select name="genre3">
			<option value="sf">sf</option>
			<option value="사극">사극</option>
			<option value="액션">액션</option>
			<option value="드라마">드라마</option>
			<option value="범죄">범죄</option>
			<option value="코미디">코미디</option>
			<option value="스릴러">스릴러</option>
			<option value="어드벤처">어드벤처</option>
			<option value="판타지">판타지</option>
			<option value="전쟁">전쟁</option>
			<option value="서부극">서부극</option>
			<option value="멜로/로맨스">멜로/로맨스</option>
			<option value="가족">가족</option>
			<option value="애니메이션">애니메이션</option>
			<option value="공포">공포</option>
			<option value="다큐멘터리">다큐멘터리</option>
			<option value="미스터리">미스터리</option>
			<option value="뮤지컬">뮤지컬</option>
			<option value="공연">공연</option>
			<option value="기타">기타</option>
		</select>
	</div>
	<div>
	<label>감독(필수) : </label> 
		<input type="text" name="director" maxlength="13" required>
	</div>
	<div>
	<label>출연 배우 : </label> 
		<input type="text" name="actor1" maxlength="13">
	</div>
	<div>
	<label>출연 배우 : </label> 
		<input type="text" name="actor2" maxlength="13">
	</div>
	<div>
	<label>출연 배우 : </label> 
		<input type="text" name="actor3" maxlength="13">
	</div>
	<div>
	<label>출연 배우(기타) : </label> 
		<input type="text" name="actor4" maxlength="66">
	</div>
	<div>
	<label>제작사 : </label> 
		<input type="text" name="production" maxlength="13">
	</div>
	<div>
	<label>배급사 : </label> 
		<input type="text" name="distributor" maxlength="13">
	</div>
	<div>
	<label>개봉(예정)일 : </label> 
		<input type="date" name="releasedate" >
	</div>
	<div>
	<label>원제 : </label> 
		<input type="text" name="origin_title" maxlength="13">
	</div>
	<div>
	<label>수입회사 : </label> 
		<input type="text" name="importer" maxlength="13">
	</div>
	<input type="submit" value="저장"> <input type="reset" value="다시쓰기">
	</form>
</body>
</html>