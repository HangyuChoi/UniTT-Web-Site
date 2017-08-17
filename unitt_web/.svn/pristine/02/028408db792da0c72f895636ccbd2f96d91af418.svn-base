package command.video;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CategoryBean;
import bean.VideoBean;
import command.CommandHandler;
import dao.CategoryDao;
import dao.VideoDao_old;

public class ViewerListService implements CommandHandler {
	String viewPage;

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String countNum ="";
		request.setCharacterEncoding("UTF-8");
		String pageNum = request.getParameter("pageNum"); //
		VideoDao_old dao = new VideoDao_old();
		ArrayList<VideoBean> returnResult = dao.selectDao(pageNum);
		request.setAttribute("viewListData", returnResult);
		System.out.println("ViewerListService");
		request.setAttribute("pageIdx", pageNum);

		return "/view/videoView/show.jsp";
	}
}
