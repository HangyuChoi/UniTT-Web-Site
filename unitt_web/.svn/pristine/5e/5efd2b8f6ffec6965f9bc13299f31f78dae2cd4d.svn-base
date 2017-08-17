package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.MemberDao;

public class WithdrawService implements CommandHandler {
	String result;
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession sessionOld = request.getSession(false);
		result = (String) sessionOld.getAttribute("id");
		String pw = request.getParameter("cPW");
		pw = new String(pw.getBytes("8859_1"), "UTF-8");
		MemberDao dao = new MemberDao();
		String returnDao = dao.withdrawDao(result, pw);
		if(returnDao.equals("success")) {
			//HttpSession sessionOld = request.getSession(false);
			sessionOld.invalidate(); // 세션 지움
		}
		request.setAttribute("withdrawResult", returnDao);

		return "/view/memberView/withdrawResult.jsp";
	}
}
