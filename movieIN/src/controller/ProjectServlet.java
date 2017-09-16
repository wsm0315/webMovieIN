package controller;
import model.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "";
		ProjectDAO dao = null;
		ProjectVO project = null;
		MembershipVO logOn = null;
		HttpSession session = request.getSession();
		//action ������Ϳ� insertProject�� ���Դ����� Ȯ����.
		if ("insertProject".equals(request.getParameter("action"))) {
			// action �Ķ���Ͱ� insertProject ���� ���� ��, login�� �ߴ��� Ȯ����. ������ ��� �α��� â���� �̵�.
			if (session.getAttribute("logOn") != null) {
				logOn = (MembershipVO)session.getAttribute("logOn");
				dao = new ProjectDAO();
				project = dao.checkProject(logOn.getId());
				// checkProject method�� ���� ���̵�� ������ ������Ʈ�� �ִ��� Ȯ����.
				// ���� ��� �ش� level�� Ȯ���Ͽ� ������ �Է��ϴ� �κ� �������� �̵��ϰ�, ���� ��쿡�� ������Ʈ ù ��� ȭ������ �̵���.
				// if-else ���� ���ο� Ŭ������ �����ұ�?? - �����غ���.
				if (project != null) {
					int level = project.getLevel_();
//					request.setAttribute("inv_type", project.getInv_type());
					request.setAttribute("seq_PID", project.getSeq_PID());
					switch (level) {
					case 0:
						// ���������� ���������� inv_type()���� Ȯ���Ͽ� �̵���.
						if (project.getInv_type().equals("R")) {
							url = "/project/insertReward.jsp";
						} else {
							url = "/project/insertInterest.jsp";
						}
						break;
					case 1:
						url = "/project/insertCompany.jsp";
						break;
					case 2:
						url = "/project/insertMovie.jsp";
						break;
					}
				} else {
					url = "/project/insertProject.jsp";
				}
			} else {
				url = "login.jsp";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "";
		ProjectDAO dao = new ProjectDAO();
		ProjectVO project = null;
		MembershipVO logOn = null;
		RewardVO reward = null;
		InterestVO interest = null;
		MovieVO movie = null;
		CompanyVO company = null;
		
		HttpSession session = request.getSession();
		if (session.getAttribute("logOn") != null) {
			logOn = (MembershipVO)session.getAttribute("logOn");
			if ("insertProject".equals(request.getParameter("action"))) {
				project = new ProjectVO();
				project.setId(logOn.getId());
				project.setProj(request.getParameter("proj"));
				project.setM_target(Integer.parseInt(request.getParameter("m_target")));
				project.setEnddate(request.getParameter("enddate"));
				if (request.getParameter("m_min") != "") {
					project.setM_min(Integer.parseInt(request.getParameter("m_min")));
				} else {
					project.setM_min(0);
				}
				if (request.getParameter("m_max") != "") {
					project.setM_max(Integer.parseInt(request.getParameter("m_max")));
				} else {
					project.setM_max(1000000000);
				}
				project.setInv_type(request.getParameter("inv_type"));
				project.setPurpose(request.getParameter("purpose"));
				project.setImgurl(request.getParameter("imgurl"));
				request.setAttribute("seq_PID", dao.insertProject(project));
				if (request.getParameter("inv_type").equals("R"))
					url = "project/insertReward.jsp";
				else 
					url = "project/insertInterest.jsp";
			} else if ("insertReward".equals(request.getParameter("action"))) {
				ArrayList <RewardVO> rewardList = new ArrayList<RewardVO>();
				int seq_PID = Integer.parseInt(request.getParameter("seq_PID"));
				for (int i = 1; i < 5; ++i) {
					String inputStd_invest = request.getParameter("std_invest" + i);
					String inputReward = request.getParameter("reward" + i);
					if (inputStd_invest != "" && inputReward != "") {
						reward = new RewardVO();
						reward.setSeq_PID(seq_PID);
						reward.setReward(inputReward);
						reward.setStd_invest(Integer.parseInt(inputStd_invest));
						rewardList.add(reward);
					} else {
						break;
					}
				}
				request.setAttribute("seq_PID", seq_PID);
				dao.insertReward(rewardList);
				url = "project/insertCompany.jsp";
			} else if ("insertInterest".equals(request.getParameter("action"))) { 
				ArrayList <InterestVO> interestList = new ArrayList<InterestVO>();
				int seq_PID = Integer.parseInt(request.getParameter("seq_PID"));
				for (int i = 1; i < 5; ++i) {
					String inputAudience = request.getParameter("audience" + i);
					String inputInterest = request.getParameter("interest" + i);
					if (inputAudience != "" && inputInterest != "") {
						interest = new InterestVO();
						interest.setSeq_PID(seq_PID);
						interest.setAudience(Integer.parseInt(inputAudience));
						interest.setInterest(Integer.parseInt(inputInterest));
						interestList.add(interest);
					} else {
						break;
					}
				}
				request.setAttribute("seq_PID", seq_PID);
				dao.insertInterest(interestList);
				url = "project/insertCompany.jsp";
				
			} else if ("insertCompany".equals(request.getParameter("action"))) { 
				company = new CompanyVO();
				int seq_PID = Integer.parseInt(request.getParameter("seq_PID"));
				company.setSeq_PID(seq_PID);
				company.setId(logOn.getId());
				company.setC_name(request.getParameter("c_name"));
				company.setC_location(request.getParameter("c_location"));
				company.setC_date(request.getParameter("c_date"));
				company.setC_eoname(request.getParameter("c_eoname"));
				company.setC_emp(Integer.parseInt(request.getParameter("c_emp")));
				company.setC_crime(request.getParameter("c_cirme"));
				company.setC_site(request.getParameter("c_site"));
				company.setC_mail(request.getParameter("c_mail"));
				dao.insertCompany(company);
				request.setAttribute("seq_PID", seq_PID);
				url = "project/insertMovie.jsp";
			} else if ("insertMovie".equals(request.getParameter("action"))) { 
				movie = new MovieVO();
				int seq_PID = Integer.parseInt(request.getParameter("seq_PID"));
				movie.setSeq_PID(seq_PID);
				movie.setTitle(request.getParameter("title"));
				movie.setGenre1(request.getParameter("genre1"));
				movie.setGenre2(request.getParameter("genre2"));
				movie.setGenre3(request.getParameter("genre3"));
				movie.setDirector(request.getParameter("director"));
				movie.setActor1(request.getParameter("actor1"));
				movie.setActor2(request.getParameter("actor2"));
				movie.setActor3(request.getParameter("actor3"));
				movie.setActor4(request.getParameter("actor4"));
				movie.setProduction(request.getParameter("production"));
				movie.setDistributor(request.getParameter("distributor"));
				movie.setReleasedate(request.getParameter("releasedate"));
				movie.setOrigin_title(request.getParameter("origin_title"));
				movie.setImporter(request.getParameter("importer"));
				dao.insertMovie(movie);
				url = "index.jsp";
			} 
		} else {
			url = "login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
