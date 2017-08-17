package command.video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CategoryBean;
import bean.VideoBean;
import command.CommandHandler;
import dao.CategoryDao;
import dao.VideoDao_old;
import dao.VideoDao;

public class UploadCheckService implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String page = "";
		request.setCharacterEncoding("UTF-8");
		page = request.getParameter("pageNum");
		request.setAttribute("page", page);
		
		return "/view/uploadView/upload.jsp";
	}
}
