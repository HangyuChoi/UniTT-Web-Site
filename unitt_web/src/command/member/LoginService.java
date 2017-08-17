package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;
import dao.MemberDao;

public class LoginService implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("password");


		// 8859_1 은 모든 문자에 대하여 대응하는 바이트 열을 가지고 있는 문자방식으로 이를 사용하여 인코딩/디코딩을 할 경우, 자신이 원하는 대부분의 데이터를 얻을 수 있다

		id = new String(id.getBytes("8859_1"), "UTF-8");
		pw = new String(pw.getBytes("8859_1"), "UTF-8");

		MemberDao dao = new MemberDao();

		String returnDao = dao.loginDao(id, pw);

		if(returnDao != null) { // 로그인 성공

			HttpSession sessionNew = request.getSession(true);

			sessionNew.setAttribute("id", id);	// 속성값 설정

			sessionNew.setAttribute("name", returnDao);

			sessionNew.setMaxInactiveInterval(120); // 시간설정  (사용하지 않는 시간)

			String result = (String) sessionNew.getAttribute("id");

			returnDao = result + " 님 로그인 성공입니다.";

		}
			request.setAttribute("loginResult", returnDao);
		return "/unitt_view/jsp/login.jsp?param=a";
	}
}
