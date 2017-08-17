package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;

public class LogoutService implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		String viewPage = "unitt_view/jsp/index.jsp?param=a";
		HttpSession sessionOld = request.getSession(false);
		sessionOld.invalidate(); // 세션 지움
		return viewPage;
	}
}
