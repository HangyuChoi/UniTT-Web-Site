package command.member;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberBean;
import command.CommandHandler;
import dao.MemberDao;

public class ModifyCheckService implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = 0;
		String result ="";
		ArrayList<MemberBean> arrBean = new ArrayList<MemberBean>();
		request.setCharacterEncoding("UTF-8");
		HttpSession sessionOld = request.getSession(false);
		result = (String) sessionOld.getAttribute("id");
		MemberDao dao = new MemberDao();
		ArrayList<MemberBean> returnArr = dao.modifyCheckDao(result);
		while(num < 1) {
			request.setAttribute("uid", returnArr.get(0).getId());
			request.setAttribute("upw", returnArr.get(0).getPassword());
			request.setAttribute("uname", returnArr.get(0).getName());
			request.setAttribute("uphone_number", returnArr.get(0).getPhone_number());
			request.setAttribute("uemail", returnArr.get(0).getEmail());
			request.setAttribute("uquestion", returnArr.get(0).getQuestion());
			request.setAttribute("uanswer", returnArr.get(0).getAnswer());
			request.setAttribute("uinterest", returnArr.get(0).getInterest());
			request.setAttribute("uintroduce", returnArr.get(0).getIntroduce());
			num++;
		}
		String text = "";
		text = (String)request.getAttribute("uinterest");
		if(!text.equals(null)){
			StringTokenizer st = new StringTokenizer(text, "/");// 맨뒤에 true 를 쓰면 /도 token에 포함 시킨다.
			int countTokens = st.countTokens();
			System.out.println(st.countTokens());

			for(int i = 0; i < countTokens; i++) {
				String token = st.nextToken();
				request.setAttribute(token, token);
			}
		}
		return "/unitt_view/jsp/updateForm.jsp";
	}

}
