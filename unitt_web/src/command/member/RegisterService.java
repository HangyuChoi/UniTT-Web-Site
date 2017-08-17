package command.member;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.MemberBean;
import command.CommandHandler;
import dao.MemberDao;


public class RegisterService implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		// 관심분야를 배열로 받는다.
		String[] interest = request.getParameterValues("interest");
		// 관심분야 다중 체크의 경우 붙힐 변수를 하나 정의
		String interests = "";


		String introduce = request.getParameter("introduce");


		// 8859_1 은 모든 문자에 대하여 대응하는 바이트 열을 가지고 있는 문자방식으로 이를 사용하여 인코딩/디코딩을 할 경우, 자신이 원하는 대부분의 데이터를 얻을 수 있다
		id = new String(id.getBytes("8859_1"), "UTF-8");
		password = new String(password.getBytes("8859_1"), "UTF-8");
		name = new String(name.getBytes("8859_1"), "UTF-8");
		email = new String(email.getBytes("8859_1"), "UTF-8");
		phone_number = new String(phone_number.getBytes("8859_1"), "UTF-8");
		question = new String(question.getBytes("8859_1"), "UTF-8");
		answer = new String(answer.getBytes("8859_1"), "UTF-8");
		introduce = new String(introduce.getBytes("8859_1"), "UTF-8");

		for(int i=0;i<interest.length;i++){
			if(interest[i]!=null) {
				interest[i] = new String(interest[i].getBytes("8859_1"), "UTF-8");
				if(i == 0) {
				interests += interest[i];
				} else {
					interests += "/" + interest[i];
				}
			}
		}

		MemberBean bean = new MemberBean(id, password, name, email, phone_number, question, answer, interests, introduce);
		MemberDao dao = new MemberDao();
		String returnDao = dao.registerDao(bean);
		request.setAttribute("registerResult", returnDao);
		return "/view/memberView/registerResult.jsp";
	}
}
