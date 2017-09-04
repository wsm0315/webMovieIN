package model;

import model.ProjectDAO;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;


public class ProjectTest {

	@Test
	public void test() {
		ArrayList<FilterVO> list = null;
		ProjectDAO dao = new ProjectDAO();
		/*list = dao.listFilter("enddate");
		for (FilterVO vo: list) {
			System.out.println(vo);
		}*/
		/*ArrayList<ProjectVO> searchList = dao.search("p");
		for (ProjectVO vo: searchList) {
			System.out.println(vo);
		}*/
		/*ProjectVO vo = dao.listOneProject(10);
		System.out.println(vo);*/
		/*System.out.println(dao.likeProjectChange(6, "3"));
		System.out.println(dao.likeProjectChange(7, "4"));
		System.out.println(dao.likeProjectChange(6, "5"));
		System.out.println(dao.likeProjectChange(6, "7"));
		System.out.println(dao.likeProjectChange(7, "2"));*/
		/*System.out.println(dao.likeProjectCheck(6, "3"));
		System.out.println(dao.likeProjectCheck(7, "11"));
		System.out.println(dao.likeProjectCheck(6, "8"));
		System.out.println(dao.likeProjectCheck(6, "7"));
		System.out.println(dao.likeProjectCheck(7, "2"));*/
		/*dao.insertInvest(6, "aa", 1000);
		dao.insertInvest(6, "bb", 10000);
		dao.insertInvest(7, "cc", 100);
		dao.insertInvest(7, "dd", 1000);*/
		/*System.out.println(dao.investCheck(6, "aa"));
		System.out.println(dao.investCheck(6, "11"));
		System.out.println(dao.investCheck(6, "bb"));
		System.out.println(dao.investCheck(7, "cc"));
		System.out.println(dao.investCheck(7, "dd"));
		System.out.println(dao.investCheck(7, "12"));*/
	}

}