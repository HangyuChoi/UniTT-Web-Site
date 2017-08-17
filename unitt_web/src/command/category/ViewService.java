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
			System.out.println("������ ����ڰ� �ش� �Խ����� �����Դϴ�.");
			request.setAttribute("auth", "yes");
			request.setAttribute("uploadPath", "/unitt_web/VideoController?video=uploadCheck&pageNum="+pageNum);
			request.setAttribute("uploadName", "������ �ø���");
		} else {
			System.out.println("��ȸ�� ���̵� : " + returnResult.get(0).getMember_id());
			System.out.println("������ ���̵� : " + result);
			System.out.println("������ ����ڰ� �ش� �Խ����� ������ �ƴմϴ�.");
			request.setAttribute("auth", "no");
			request.setAttribute("uploadPath", "");
			request.setAttribute("uploadName", "������ �ø��⸦ �� �� �����ϴ�.");
		}
		request.setAttribute("viewData", returnResult);
		request.setAttribute("pageIdx", pageNum);
		//countNum =String.valueOf(returnResult.size()-1);
		//request.setAttribute("checkCount", countNum); // �ݺ�Ƚ�� ����

		return "/unitt_view/jsp/eduPage.jsp";
	}
}
