package command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandHandler;

public class BoardCheckService2 implements CommandHandler{
	String result;
	public String process(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		HttpSession sessionOld = request.getSession(false);
		result = (String)sessionOld.getAttribute("id");
		if(result == null){
			return "/view/boardView/notfoundSession.jsp";
		} else {
			return "/view/boardView/myBoardList.jsp";
		}
	}
}
