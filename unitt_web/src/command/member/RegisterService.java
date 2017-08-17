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
		// ���ɺо߸� �迭�� �޴´�.
		String[] interest = request.getParameterValues("interest");
		// ���ɺо� ���� üũ�� ��� ���� ������ �ϳ� ����
		String interests = "";


		String introduce = request.getParameter("introduce");


		// 8859_1 �� ��� ���ڿ� ���Ͽ� �����ϴ� ����Ʈ ���� ������ �ִ� ���ڹ������ �̸� ����Ͽ� ���ڵ�/���ڵ��� �� ���, �ڽ��� ���ϴ� ��κ��� �����͸� ���� �� �ִ�
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
