package command.category;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CategoryBean;
import command.CommandHandler;
import dao.CategoryDao;

public class ViewService implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String countNum ="";
		String result;
		request.setCharacterEncoding("UTF-8");
		HttpSession sessionOld = request.getSession(false);
		result = (String) sessionOld.getAttribute("id");

		String pageNum = request.getParameter("pageNum");

		CategoryDao dao = new CategoryDao();
		System.out.println(pageNum);
		ArrayList<CategoryBean> returnResult = dao.selectDao(pageNum);
		if(returnResult.get(0).getMember_id().equals(result)) {
			System.out.println("접근한 사용자가 해당 게시판의 주인입니다.");
			request.setAttribute("auth", "yes");
			request.setAttribute("uploadPath", "/unitt_web/VideoController?video=uploadCheck&pageNum="+pageNum);
			request.setAttribute("uploadName", "동영상 올리기");
		} else {
			System.out.println("조회한 아이디 : " + returnResult.get(0).getMember_id());
			System.out.println("접근한 아이디 : " + result);
			System.out.println("접근한 사용자가 해당 게시판의 주인이 아닙니다.");
			request.setAttribute("auth", "no");
			request.setAttribute("uploadPath", "");
			request.setAttribute("uploadName", "동영상 올리기를 할 수 없습니다.");
		}
		request.setAttribute("viewData", returnResult);
		request.setAttribute("pageIdx", pageNum);
		//countNum =String.valueOf(returnResult.size()-1);
		//request.setAttribute("checkCount", countNum); // 반복횟수 지정

		return "/unitt_view/jsp/eduPage.jsp";
	}
}
