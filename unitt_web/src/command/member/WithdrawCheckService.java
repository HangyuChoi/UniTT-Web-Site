package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberBean;
import command.CommandHandler;
import dao.MemberDao;

public class WithdrawCheckService implements CommandHandler {
	String result;
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession sessionOld = request.getSession(false);
		result = (String) sessionOld.getAttribute("id");
		MemberDao dao = new MemberDao();
		MemberBean returnBean = dao.withdrawCheckDao(result);
		request.setAttribute("returnId", returnBean.getId());
		//request.setAttribute("returnPw", returnBean.getPW());

		return "/unitt_view/jsp/deleteForm.jsp";
	}

}
