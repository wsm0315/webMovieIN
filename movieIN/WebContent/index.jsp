<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MembershipVO"%>
<%@ page import="model.ProjectVO" %>
<%@ page import="model.ProjectDAO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MovieIn</title>

<!-- Bootstrap core CSS -->
<link href="reference/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="reference/css/shop-homepage.css" rel="stylesheet">
<style>
body {font-family: "Lato", sans-serif;}

/* Style the tab */
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
#navbar {
width:150px;
}
#search-holder {
padding-left:10px;
padding-right:10px;
padding-top:5px;
padding-bottom:5px;
width:65px;
}
#search-btn {
background-color:gray;
}
#search {
padding:0px;
}

</style>
<!-- <style>
		@media only screen and (max-width:992px){
			#recommend {
				display: none;
			}
		}
	</style> -->
<!-- Bootstrap core JavaScript -->
<script src="reference/vendor/jquery/jquery.min.js"></script>
<script src="reference/vendor/popper/popper.min.js"></script>
<script src="reference/vendor/bootstrap/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
$("#search-holder").focus(function(){ 
	$("#search-form").animate({ 
		"width": "200px" }, 300, function() {});
	}); 
$("#search-holder").blur(function(){ 
	$("#search-form").animate({ 
		"width": "60px" }, 300, function() {}); 
	}); 
$("#search-form").click(function(){ 
	$("#search-holder").focus();
}); 
})
</script>
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">MovieIn</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
			<div class="col-lg-8">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">프로젝트
							둘러보기</a></li>
					<li class="nav-item"><a class="nav-link" href="#">프로젝트 올리기</a>
					</li>
					<!--  간격조정 어떻게 하는거야... -->
				</ul>
			</div>
			
			
			<div id="logOn-after" class="col-lg-2">
				<ul id="navbar" class="navbar-nav">
					<li id="logOn-login" class="nav-item active"><a
						class="nav-link" href="login.jsp">로그인 <span class="sr-only">(current)</span>
					</a></li>
					<li id="logOn-register" class="nav-item"><a class="nav-link"
						href="register.jsp">회원가입</a></li>
				</ul>
			
			
			
				<%
						MembershipVO logOn = null;
						if (session.getAttribute("logOn") != null) {
							logOn = (MembershipVO) session.getAttribute("logOn");
					%>

						<div id="logOn-name" class="dropdown">
							<button style="background-color: gray" class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown"><%=logOn.getName() + " 님"%>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">나의 펀딩 현황</a></li>
								<li><a href="#">찜한 프로젝트</a></li>
								<li><a href="#">만든 프로젝트</a></li>
								<li class="dropdown-divider"></li> 
								<li><a href="#">정보 설정</a></li>
								<li><a href="./Member?action=logout">로그아웃</a></li>
							</ul>
						</div>
			
		
			<%
				}
			%>
			</div>
			<div id="search" class="col-lg-2">
        <form id="search-form" class="navbar-form" role="search">
        <div class="input-group">
            <input id="search-holder" type="text" class="form-control" placeholder="Search" name="q">
            <div class="input-group-btn">
                <button id="search-btn" type="submit" class="btn btn-primary btn-sm">Search</button>
            </div>
        </div>
        </form>
    </div>
			</div>
		</div>
		
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-9" style="flex:0 0 60%">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<a href=""><img class="d-block img-fluid" src="img/001.png" width="560"
								alt="First slide" style="" ></a>
						</div>
						<div class="carousel-item">
							<a href=""><img class="d-block img-fluid" src="img/004.png" width="560"
								alt="Second slide" style="" ></a>
						</div>
						<div class="carousel-item">
							<a href=""><img class="d-block img-fluid" src="img/003.png" width="560"
								alt="Third slide" style="" ></a>
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>

			<div id="recommend" class="col-lg-3" style="padding-bottom:20px;flex:0 0 40%;max-width:40%">
				<div class="my-4" style="margin-bottom:0!important;">
				  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">조회순</button>
				  <button class="tablinks" onclick="openCity(event, 'Paris')">예상관객수</button>
				  <button class="tablinks" onclick="openCity(event, 'Tokyo')">모아진금액</button>
				</div>

				<!-- 랭킹 : listAll("cnt desc"); : 조회수 많은 순, 
						listAll("pna desc nulls last"); : 예상관객수 많은순, 
						listAll("m_collected desc"); : 모아진 돈 많은 순  -->
				<!-- 나머지  : listAll("writedate"); : 신작순, 
						listAll("enddate"); : 마감 끝나가는 순 -->
				<!-- 이렇게 구성. 가운데 나오는 건 우리가 임의로 구성.  
				ArrayList<ProjectVO> listAll(String sorting)
				"cnt desc"(큰거에서 작은거), "enddate", "writedate", "m_collected desc", "pna desc nulls last"-->
				
				<%ProjectDAO dao = new ProjectDAO();%>				
				<div id="London" class="tabcontent">
				  <%//프로젝트 name, jsp주소, cnt
				ArrayList<ProjectVO> cntList = dao.listAll("cnt desc"); 
				for (int i = 0; i < cntList.size() && i < 5; ++i) {%>
					<h4><%=i+1 %>. <a href=""><%=cntList.get(i).getProj() %></a></h4>
					<span>조회수 : <%=cntList.get(i).getCnt() %></span>
				<% } %>
				</div>
				
				<div id="Paris" class="tabcontent">
				  <%//프로젝트 name, jsp주소, pna
				ArrayList<ProjectVO> pnaList = dao.listAll("pna desc nulls last"); 
				for (int i = 0; i < pnaList.size() && i < 5; ++i) {%>
					<h4><%=i+1 %>. <a href=""><%=cntList.get(i).getProj() %></a></h4>
					<span>예상 관객수 : <%=cntList.get(i).getPna() %></span>
				<% } %>
				</div>
				
				<div id="Tokyo" class="tabcontent">
				<%//프로젝트 name, jsp주소, m_colleted
				ArrayList<ProjectVO> m_collectedList = dao.listAll("m_collected desc"); 
				for (int i = 0; i < m_collectedList.size() && i < 5; ++i) {%>
				  <h4><%=i+1 %>. <a href=""><%=m_collectedList.get(i).getProj() %></a></h4>
					<span>모아진 금액 : <%=m_collectedList.get(i).getM_collected() %></span>
				<% } %>
				</div>
			</div>

		</div>
		<!-- end of row1 -->
		<!-- card 안에 어떤 내용들을 넣을지 상의 필요. -->
		<div class="row">
		<%//프로젝트 name, jsp주소, imgurl, 기타 정보들.
			ArrayList<ProjectVO> writedateList = dao.listAll("writedate desc"); 
			for (int i = 0; i < writedateList.size() && i < 3; ++i) {
			%>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="<%="img/" + writedateList.get(i).getImgurl() %>" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#"><%=writedateList.get(i).getProj() %></a>
						</h4>
						<h5>등록일 : <%=writedateList.get(i).getWritedate() %></h5>
						<p class="card-text"></p>
					</div>
				</div>
			</div>
			<%}%>
			<%//프로젝트 name, jsp주소, imgurl, 기타 정보들.
			ArrayList<ProjectVO> enddateList = dao.listAll("enddate"); 
			for (int i = 0; i < enddateList.size() && i < 3; ++i) {
			%>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="<%="img/" + enddateList.get(i).getImgurl() %>" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#"><%=enddateList.get(i).getProj() %></a>
						</h4>
						<h5>마감일 : <%=enddateList.get(i).getEnddate() %></h5>
						<p class="card-text"></p>
					</div>
				</div>
			</div>
			<%}  %>
		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; 주식회사 2017</p>
		</div>
		<!-- /.container -->
	</footer>
	<%
		if (session.getAttribute("logOn") != null) {
	%>
	<script>
		$("#logOn-login").hide();
		$("#logOn-register").hide();
		/* $("#logOn-name").css("width", "100px");
		$("#logOn-after").css("width", "100px"); */
	</script>
	<%
		}
	%>
	<script>
	function openCity(evt, cityName) {
	    var i, tabcontent, tablinks;
	    tabcontent = document.getElementsByClassName("tabcontent");
	    for (i = 0; i < tabcontent.length; i++) {
	        tabcontent[i].style.display = "none";
	    }
	    tablinks = document.getElementsByClassName("tablinks");
	    for (i = 0; i < tablinks.length; i++) {
	        tablinks[i].className = tablinks[i].className.replace(" active", "");
	    }
	    document.getElementById(cityName).style.display = "block";
	    evt.currentTarget.className += " active";
	}
	
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
	</script>


</body>

</html>




