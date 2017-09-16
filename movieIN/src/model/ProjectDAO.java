package model;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
public class ProjectDAO {
	// Connection 객체를 생성해줌. -> 추후 dao 모두 만들고 나면 connection pool로 교체하자.
	private Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "moviein", "moviein");
		} catch (Exception e) {
			System.out.println("ConnectDB() : " + e);
		}
		return conn;
	}
	
	// sort로 입력 가능한 값 : "cnt desc"(큰거에서 작은거), "enddate", "writedate", "m_collected desc", "pna desc nulls last"
	//						조회수 많은 순 			        마감임박          신작순		    모아진 돈 많은 순.	 		예상관객수
	public ArrayList<ProjectVO> listAll(String sorting) {
		ArrayList<ProjectVO> projectList = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			// seq_PID(프로젝트 id), 사용자 id, 프로젝트명, imgurl명을 받음
			// level_ 과 status가 3인 것만 받고 매개변수에 따라 정렬 기준을 달리하여 ArrayList에 순서대로 담아서 출력함.
			rs = st.executeQuery("select seq_PID, id, proj, imgurl, inv_type, purpose from project where level_ = 3 and status = 3 order by " + sorting);
			ProjectVO vo = null;
			projectList = new ArrayList<ProjectVO>();
			while (rs.next()) {
				vo = new ProjectVO();
				vo.setSeq_PID(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setProj(rs.getString(3));
				vo.setImgurl(rs.getString(4));
				vo.setInv_type(rs.getString(5));
				vo.setPurpose(rs.getString(6));
				projectList.add(vo);
			}
		} catch (Exception e) {
			System.out.println("listAll : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return projectList;
	}
	
	// FilterVO의 값을 가져옴. 프로젝트 둘러보기 시에 FilterVO의 값을 이용하여 프로젝트 list를 출력함.
	public ArrayList<FilterVO> listFilter(String sorting) {
		ArrayList<FilterVO> filterList = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			// seq_PID(프로젝트 id), 사용자 id, 프로젝트명, imgurl명을 받음
			// level_ 과 status가 3인 것만 받고 매개변수에 따라 정렬 기준을 달리하여 ArrayList에 순서대로 담아서 출력함.
			rs = st.executeQuery("select movie.seq_PID, id, proj, imgurl, inv_type, purpose, genre1, genre2, genre3 from project, movie where project.seq_pid = movie.seq_pid and level_ = 3 and status = 3 order by " + sorting);
			FilterVO vo = null;
			filterList = new ArrayList<FilterVO>();
			while (rs.next()) {
				vo = new FilterVO();
				vo.setSeq_PID(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setProj(rs.getString(3));
				vo.setImgurl(rs.getString(4));
				vo.setInv_type(rs.getString(5));
				vo.setPurpose(rs.getString(6));
				vo.setGenre1(rs.getString(7));
				vo.setGenre2(rs.getString(8));
				vo.setGenre3(rs.getString(9));
				filterList.add(vo);
			}
		} catch (Exception e) {
			System.out.println("listAll : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return filterList;
	}
	// 검색기능 dao. 검색어를 입력하면 프로젝트 이름 중 그 keyword가 들어간 글자를 찾아줌.
	public ArrayList<ProjectVO> search(String keyword) {
		ArrayList<ProjectVO> projectList = null;
		Connection conn = connectDB();
		String query = "select seq_PID, id, proj, imgurl, inv_type, purpose from project where level_ = 3 and status = 3 and proj like '%" + keyword + "%'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			ProjectVO vo = null;
			projectList = new ArrayList<ProjectVO>();
			while (rs.next()) {
				vo = new ProjectVO();
				vo.setSeq_PID(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setProj(rs.getString(3));
				vo.setImgurl(rs.getString(4));
				vo.setInv_type(rs.getString(5));
				vo.setPurpose(rs.getString(6));
				projectList.add(vo);
			}
		} catch (Exception e) {
			System.out.println("search : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return projectList;
	}
	
	// project에 대한 상세 페이지에서 처음으로 나오는 위의 정보를 출력하기 위해 projectDB의 모든 정보를 담음.
	public ProjectVO listOneProject(int seq_PID) {
		ProjectVO vo = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_PID, id, proj, m_target, m_collected, enddate, cnt, writedate, m_min, m_max, inv_type, pna, level_, purpose, status, imgurl from project where level_ = 3 and status = 3 and seq_pid = " + seq_PID);
			vo = new ProjectVO();
			if (rs.next()) {
				vo.setSeq_PID(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setProj(rs.getString(3));
				vo.setM_target(rs.getInt(4));
				vo.setM_collected(rs.getInt(5));
				vo.setEnddate(rs.getString(6));
				vo.setCnt(rs.getInt(7));
				vo.setWritedate(rs.getString(8));
				vo.setM_min(rs.getInt(9));
				vo.setM_max(rs.getInt(10));
				vo.setInv_type(rs.getString(11));
				vo.setPna(rs.getInt(12));
				vo.setLevel_(rs.getInt(13));
				vo.setPurpose(rs.getString(14));
				vo.setStatus(rs.getInt(15));
				vo.setImgurl(rs.getString(16));
			}
		} catch (Exception e) {
			System.out.println("listOne : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	// 메서드 종료 시점에서 찜한 프로젝트가 있을 경우 True, 없을 경우 False
	public boolean likeProjectChange(int seq_PID, String id) {
		boolean result = false;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_pid, id from likeproject where seq_PID = " + seq_PID + " and id = " + id);
			if (rs.next()) {
				st.executeUpdate("delete from likeproject where seq_pid = " + rs.getInt(1) + " and id = " + rs.getString(2));
			} else {
				st.executeUpdate("insert into likeproject(seq_pid, id) values (" + seq_PID + "," + id + ")");
				result = true;
			}
		} catch (Exception e) {
			System.out.println("likeProjectChange : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 찜한 프로젝트가 있는지 없는지만 확인함.
	public boolean likeProjectCheck(int seq_PID, String id) {
		boolean result = false;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_pid, id from likeproject where seq_PID = " + seq_PID + " and id = " + id);
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("likeProjectCheck : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// boolean insertPrice(seq_PID, id, m_invest) 투자하기 누를 때 구현.
	// price의 최소 최대값은 input 에서 min, max 속성? 같은 걸로?
	public boolean insertInvest(int seq_PID, String id, int m_invest) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			st = conn.prepareStatement("insert into investProject(seq_pid, id, m_invest) values (?, ?, ?)");
			st.setInt(1, seq_PID);
			st.setString(2, id);
			st.setInt(3, m_invest);
			st.executeUpdate();
			st1 = conn.prepareStatement("update project set m_collected = m_collected + ? where seq_pid = ?");
			st1.setInt(1, m_invest);
			st1.setInt(2, seq_PID);
			st1.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.out.println("insertPrice : " + e);
		} finally {
			try {
				st.close();
				st1.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 전에 투자를 했었는지 확인하는 DAO
	public boolean investCheck(int seq_PID, String id) {
		boolean result = false;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
//		String query = "select * from investProject where seq_pid = " + seq_PID + " and id = " + id;
//		System.out.println(query);
		try {
			st = conn.createStatement();
//			rs = st.executeQuery(query);
			rs = st.executeQuery("select * from investProject where seq_pid = " + seq_PID + " and id = '" + id + "'");
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("investCheck : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// CompanyVO companyInfo(seq_PID) - 기업정보 불러오기
	public CompanyVO companyInfo(int seq_PID) {
		CompanyVO vo = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_CID, seq_pid, id, c_name, c_location, c_date, c_eoname, c_emp, c_crime, c_site, c_mail from company where seq_pid = " + seq_PID);
			vo = new CompanyVO();
			if (rs.next()) {
				vo.setSeq_CID(rs.getInt(1));
				vo.setSeq_PID(rs.getInt(2));
				vo.setId(rs.getString(3));
				vo.setC_name(rs.getString(4));
				vo.setC_location(rs.getString(5));
				vo.setC_date(rs.getString(6));
				vo.setC_eoname(rs.getString(7));
				vo.setC_emp(rs.getInt(8));
				vo.setC_crime(rs.getString(9));
				vo.setC_site(rs.getString(10));
				vo.setC_mail(rs.getString(11));
			}
		} catch (Exception e) {
			System.out.println("companyInfo : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	// MovieVO movieInfo(seq_PID) - 영화정보 불러오기
	public MovieVO movieInfo(int seq_PID) {
		MovieVO vo = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_pid, title, genre1, genre2, genre3, director, actor1, actor2, actor3, actor4, production, distributor, releasedate, origin_title, importer from movie where seq_pid = " + seq_PID);
			vo = new MovieVO();
			if (rs.next()) {
				vo.setSeq_PID(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setGenre1(rs.getString(3));
				vo.setGenre2(rs.getString(4));
				vo.setGenre3(rs.getString(5));
				vo.setDirector(rs.getString(6));
				vo.setActor1(rs.getString(7));
				vo.setActor2(rs.getString(8));
				vo.setActor3(rs.getString(9));
				vo.setActor4(rs.getString(10));
				vo.setProduction(rs.getString(11));
				vo.setDistributor(rs.getString(12));
				vo.setReleasedate(rs.getString(13));
				vo.setOrigin_title(rs.getString(14));
				vo.setImporter(rs.getString(15));
			}
		} catch (Exception e) {
			System.out.println("movieInfo : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	// ProjectVO에서 inv_type에 따라서
	// ArrayList<InterestVO> interestInfo(seq_PID) or ArrayList<RewardVO> rewardInfo(seq_PID) 를 호출하여 정보를 얻음.
	public ArrayList<InterestVO> interestInfo(int seq_PID) {
		ArrayList<InterestVO> list = null;
		InterestVO vo = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_pid, audience, interest from interest where seq_pid = " + seq_PID + " order by audience");
			list = new ArrayList<InterestVO>(); 
			while (rs.next()) {
				vo = new InterestVO();
				vo.setSeq_PID(rs.getInt(1));
				vo.setAudience(rs.getInt(2));
				vo.setInterest(rs.getInt(3));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("interestInfo : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<RewardVO> rewardInfO(int seq_PID) {
		ArrayList<RewardVO> list = null;
		RewardVO vo = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_pid, std_invest, reward from reward where seq_pid = " + seq_PID + " order by std_invest");
			list = new ArrayList<RewardVO>();
			while (rs.next()) {
				vo = new RewardVO();
				vo.setSeq_PID(rs.getInt(1));
				vo.setStd_invest(rs.getInt(2));
				vo.setReward(rs.getString(3));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("rewardInfo : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// ArrayList<NewsVO> listNews(int seq_PID) : 새소식 글들 출력
	// group이 높은 순서(새소식이 최근에 작성된 순서로 우선 정렬)
	// 그 다음 depth 순서로 정리해서 댓글보다 작성글이 먼저 올 수 있게 정렬
	// 그 다음 n_date 로 정렬해서 먼저 적은 댓글이 위로 올 수 있게 함.
	public ArrayList<NewsVO> listNews(int seq_PID) {
		ArrayList<NewsVO> list = null;
		NewsVO vo = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_NNO, seq_PID, id, n_contents, n_date, n_depth, n_group, n_imgurl, n_videourl from news where seq_pid = " + seq_PID + " order by n_group desc, depth, n_date");
			list = new ArrayList<NewsVO>();
			while (rs.next()) {
				vo = new NewsVO();
				vo.setSeq_NNO(rs.getInt(1));
				vo.setSeq_PID(rs.getInt(2));
				vo.setId(rs.getString(3));
				vo.setN_contents(rs.getString(4));
				vo.setN_date(rs.getString(5));
				vo.setN_depth(rs.getInt(6));
				vo.setN_group(rs.getInt(7));
				vo.setN_imgurl(rs.getString(8));
				vo.setN_videourl(rs.getString(9));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("listNews : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// boolean insertNewsReply(NewsVO vo) : 새소식에 댓글 달기
	public boolean insertNewsReply(NewsVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into news(seq_NNO, seq_pid, id, n_contents, n_date, n_depth, n_group) values(?,?,?,?,?,?,?)");
			st.setInt(1, vo.getSeq_NNO());
			st.setInt(2, vo.getSeq_PID());
			st.setString(3, vo.getId());
			st.setString(4, vo.getN_contents());
			st.setString(5, vo.getN_date());
			st.setInt(6, vo.getN_depth());
			st.setInt(7, vo.getN_group());
			int num = st.executeUpdate();
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("insertNewsReply : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean deleteNewsReply(int seq_NNO) {
		boolean result = false;
		Connection conn = connectDB();
		Statement st = null;
		try {
			st = conn.createStatement();
			int num = st.executeUpdate("delete from news where seq_nno = " + seq_NNO); 
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("deleteNews : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean updateNewsReply(NewsVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update news set n_contents=? where seq_NNO = ?"); 
			st.setString(1, vo.getN_contents());
			st.setInt(2, vo.getSeq_NNO());
			int num = st.executeUpdate();
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("updateNewsReply : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 관리자 - 새소식 쓰기
	public boolean insertNews(NewsVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into news(seq_NNO, seq_pid, id, n_contents, n_date, n_depth, n_group, n_imgurl, n_videourl) values(?,?,?,?,?,?,?,?,?)");
			st.setInt(1, vo.getSeq_NNO());
			st.setInt(2, vo.getSeq_PID());
			st.setString(3, vo.getId());
			st.setString(4, vo.getN_contents());
			st.setString(5, vo.getN_date());
			st.setInt(6, vo.getN_depth());
			st.setInt(7, vo.getN_group());
			st.setString(8, vo.getN_imgurl());
			st.setString(9, vo.getN_videourl());
			int num = st.executeUpdate();
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("insertNews : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 관리자 - 새소식 삭제
	public boolean deleteNews(int seq_NNO) {
		boolean result = false;
		Connection conn = connectDB();
		Statement st = null;
		try {
			st = conn.createStatement();
			int num = st.executeUpdate("delete from news where n_group = " + seq_NNO); 
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("deleteNews : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 관리자 - 새소식 수정
	public boolean updateNews(NewsVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update news set n_contents=?, n_date=?, n_imgurl=?, n_videourl=? where seq_NNO = ?"); 
			st.setString(1, vo.getN_contents());
			st.setString(2, vo.getN_date());
			st.setString(3, vo.getN_imgurl());
			st.setString(4, vo.getN_videourl());
			st.setInt(5, vo.getSeq_NNO());
			int num = st.executeUpdate();
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("updateNews : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 피드백 내용 보이기
	public ArrayList<FeedbackVO> listFeedback(int seq_PID) {
		ArrayList<FeedbackVO> list = null;
		FeedbackVO vo = null;
		Connection conn = connectDB();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select seq_FNO, seq_PID, f_contents, f_date, depth, f_group, id from feedback where seq_pid = " + seq_PID + " order by f_group, depth");
			list = new ArrayList<FeedbackVO>();
			while (rs.next()) {
				vo = new FeedbackVO();
				vo.setSeq_FNO(rs.getInt(1));
				vo.setSeq_PID(rs.getInt(2));
				vo.setF_contents(rs.getString(3));
				vo.setF_date(rs.getString(4));
				vo.setDepth(rs.getInt(5));
				vo.setF_group(rs.getInt(6));
				vo.setId(rs.getString(7));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("listFeedback : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 피드백 올리기
	public boolean insertFeedback(FeedbackVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into feedback(seq_FNO, seq_PID, f_contents, f_date, depth, f_group, id) values(?,?,?,?,?,?,?)");
			st.setInt(1, vo.getSeq_FNO());
			st.setInt(2, vo.getSeq_PID());
			st.setString(3, vo.getF_contents());
			st.setString(4, vo.getF_date());
			st.setInt(5, vo.getDepth());
			st.setInt(6, vo.getF_group());
			st.setString(7, vo.getId());
			int num = st.executeUpdate();
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("insertFeedback : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//피드백 삭제
	public boolean deleteFeedback(int seq_FNO) {
		boolean result = false;
		Connection conn = connectDB();
		Statement st = null;
		try {
			st = conn.createStatement();
			int num = st.executeUpdate("delete from feedback where seq_fno = " + seq_FNO); 
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("deleteFeedback : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// feedback 수정
	public boolean updateFeedback(FeedbackVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update Feedback set f_contents=? where seq_FNO = ?"); 
			st.setString(1, vo.getF_contents());
			st.setInt(2, vo.getSeq_FNO());
			int num = st.executeUpdate();
			if (num != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("updateNews : " + e);
		} finally {
			try {
				st.close();
				conn.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//프로젝트 진행중인지 확인
	public ProjectVO checkProject(String id) {
		ProjectVO vo = null;
		Connection conn = connectDB();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select seq_PID, level_, inv_type from project where id = ? and status = 0");
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				vo = new ProjectVO();
				vo.setSeq_PID(rs.getInt(1));
				vo.setLevel_(rs.getInt(2));
				vo.setInv_type(rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println("checkProject : " + e);
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	// 프로젝트정보(project DB)에 자료 올리기
	public int insertProject(ProjectVO vo) {
		int result = -1;
		Connection conn = connectDB();
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		// vo에 있는 값을 DB의 insert 명령어를 통해 넣기.
		try {
			st = conn.prepareStatement("insert into project values(seq_PID.nextval,?,?,?,0,?,0,sysdate,?,?,?,-1,0,?,0,?)");
			st.setString(1, vo.getId());
			st.setString(2, vo.getProj());
			st.setInt(3, vo.getM_target());
			st.setString(4, vo.getEnddate());
			st.setInt(5, vo.getM_min());
			st.setInt(6, vo.getM_max());
			st.setString(7, vo.getInv_type());
			st.setString(8, vo.getPurpose());
			st.setString(9, vo.getImgurl());
			st.executeQuery();
			st1 = conn.prepareStatement("select seq_PID from project where proj = ?");
			st1.setString(1, vo.getProj());
			rs = st1.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("insertProject : " + e);
		} finally {
			try {
				rs.close();
				st1.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 프로젝트에 inv_type 'R'일때, reward DB에 자료 올리기
	public boolean insertReward(ArrayList<RewardVO> list) {
		boolean result = true;
		Connection conn = connectDB();
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			for (int i = 0; i < list.size(); ++i) {
				st = conn.prepareStatement("insert into reward values(?, ?, ?)");
				st.setInt(1, list.get(i).getSeq_PID());
				st.setInt(2, list.get(i).getStd_invest());
				st.setString(3, list.get(i).getReward());
				st.executeUpdate();
			}
			st1 = conn.prepareStatement("update project set level_ = 1 where seq_PID = ?");
			st1.setInt(1,list.get(0).getSeq_PID());
			st1.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.out.println("insertReward : " + e);
		} finally {
			try {
				st.close();
				st1.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// 프로젝트에 inv_type 'I'일때, interest DB에 자료 올리기
	public boolean insertInterest(ArrayList<InterestVO> list) {
		boolean result = true;
		Connection conn = connectDB();
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			for (int i = 0; i < list.size(); ++i) {
				st = conn.prepareStatement("insert into interest values(?, ?, ?)");
				st.setInt(1, list.get(i).getSeq_PID());
				st.setInt(2, list.get(i).getAudience());
				st.setInt(3, list.get(i).getInterest());
				st.executeUpdate();
			}
			st1 = conn.prepareStatement("update project set level_ = 1 where seq_PID = ?");
			st1.setInt(1,list.get(0).getSeq_PID());
			st1.executeUpdate();
			result = true;
			result = true;
		} catch (Exception e) {
			System.out.println("insertInterest : " + e);
		} finally {
			try {
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// 영화정보(movie DB)에 자료 올리기
	public boolean insertMovie(MovieVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		// vo에 있는 값을 DB의 insert 명령어를 통해 넣기.
		try {
			st = conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, vo.getSeq_PID());
			st.setString(2, vo.getTitle());
			st.setString(3, vo.getGenre1());
			st.setString(4, vo.getGenre2());
			st.setString(5, vo.getGenre3());
			st.setString(6, vo.getDirector());
			st.setString(7, vo.getActor1());
			st.setString(8, vo.getActor2());
			st.setString(9, vo.getActor3());
			st.setString(10, vo.getActor4());
			st.setString(11, vo.getProduction());
			st.setString(12, vo.getDistributor());
			st.setString(13, vo.getReleasedate());
			st.setString(14, vo.getOrigin_title());
			st.setString(15, vo.getImporter());
			st.executeQuery();
			st1 = conn.prepareStatement("update project set level_ = 3, status = 1 where seq_PID = ?");
			st1.setInt(1,vo.getSeq_PID());
			st1.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.out.println("insertMovie : " + e);
		} finally {
			try {
				st.close();
				st1.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 기업정보(company DB)에 자료 올리기
	public boolean insertCompany(CompanyVO vo) {
		boolean result = false;
		Connection conn = connectDB();
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		// vo에 있는 값을 DB의 insert 명령어를 통해 넣기.
		try {
			st = conn.prepareStatement("insert into company values(seq_CID.nextval,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, vo.getSeq_PID());
			st.setString(2, vo.getId());
			st.setString(3, vo.getC_name());
			st.setString(4, vo.getC_location());
			st.setString(5, vo.getC_date());
			st.setString(6, vo.getC_eoname());
			st.setInt(7, vo.getC_emp());
			st.setString(8, vo.getC_crime());
			st.setString(9, vo.getC_site());
			st.setString(10, vo.getC_mail());
			st.executeQuery();
			st1 = conn.prepareStatement("update project set level_ = 2 where seq_PID = ?");
			st1.setInt(1,vo.getSeq_PID());
			st1.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.out.println("insertCompany : " + e);
		} finally {
			try {
				st.close();
				st1.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
