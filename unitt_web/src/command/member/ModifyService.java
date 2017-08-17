package command.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberBean;
import command.CommandHandler;
import dao.MemberDao;


public class ModifyService implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession sessionOld = request.getSession(false);
		String id = (String) sessionOld.getAttribute("id");
		String cpw = request.getParameter("password2"); // 바꿀 비밀번호
		String name = request.getParameter("name");
		String phone_number = request.getParameter("phone_number");
	    String email = request.getParameter("email");
	    String question = request.getParameter("question");
	    String answer = request.getParameter("answer");
	    
	    // 관심분야를 배열로 받는다.
	    String[] interest = request.getParameterValues("interest");
	 	// 관심분야 다중 체크의 경우 붙힐 변수를 하나 정의
	 	String interests = "";
	 	
	    String introduce = request.getParameter("introduce");
		cpw = new String(cpw.getBytes("8859_1"), "UTF-8");
		name = new String(name.getBytes("8859_1"), "UTF-8");
		email = new String(email.getBytes("8859_1"), "UTF-8");
		phone_number = new String(phone_number.getBytes("8859_1"), "UTF-8");
		question = new String(question.getBytes("8859_1"), "UTF-8");
		answer = new String(answer.getBytes("8859_1"), "UTF-8");
		introduce = new String(introduce.getBytes("8859_1"), "UTF-8");
		
		// ex) 게임/스포츠/교육   이런식으로 붙힌다.
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

		MemberBean bean = new MemberBean(id, cpw, name, email, phone_number, question, answer, interests, introduce);
		MemberDao dao = new MemberDao();
		String returnDao = dao.updateDao(bean);
		request.setAttribute("modifyResult", returnDao);

		return "/unitt_view/jsp/modifyResult.jsp";

	}
}
