package command.board;

import java.net.URLEncoder;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BoardBean;
import bean.MyCalendar;
import command.CommandHandler;
import dao.BoardDao;
import util.MultiPart;

public class WriteService implements CommandHandler{
	public String process(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		MyCalendar mycal = new MyCalendar();
/*		HttpSession sessionOld = request.getSession(false);
		String id = (String)sessionOld.getAttribute("id");*/
		
		MultiPart multiPart = new MultiPart(request);	
		
		
		
//		String title = multiPart.getParameter("title");
//		String fileName = multiPart.getFileName("upload_file");
		String id = multiPart.getParameter("id");
		String category = multiPart.getParameter("category");
		String title = multiPart.getParameter("title");
		String content = multiPart.getParameter("content");
		String image = multiPart.getFileName("image");
		String shot_introduce = multiPart.getParameter("shot_introduce");
		String plan = multiPart.getParameter("plan");
		

	 
//		String description = multiPart.getParameter("content");
		String relativePath = request.getServletContext().getRealPath("");
	
		
	
//		id = new String(id.getBytes("8859_1"),"UTF-8");
		category = new String(category.getBytes("8859_1"),"UTF-8");
		//title = new String(title.getBytes("8859_1"),"UTF-8");
//		content = new String(content.getBytes("8859_1"),"UTF-8");
		image = java.net.URLDecoder.decode(image, "utf-8");

		
//		description = new String(description.getBytes("8859_1"),"UTF-8");
//		fileName = new String(fileName.getBytes("8859_1"),"UTF-8");
//		shot_introduce = new String(shot_introduce.getBytes("8859_1"),"UTF-8");
//		plan = new String(plan.getBytes("8859_1"),"UTF-8");
				
		String newPath = response.encodeURL("C:/Java/tomcat9/webapps/img/"+ image);
						
		multiPart.saveFile("image", newPath);
		
		String url = String.format("view/boardView/writeResult.jsp?TITLE=%s&DESCRIPTION=%s&FILE_NAME=%s",
									URLEncoder.encode(title, "UTF-8"),
									URLEncoder.encode(content, "UTF-8"),
									URLEncoder.encode(image, "UTF-8"));
				
		
		String wdate = mycal.getToday();
		
		BoardBean bean = new BoardBean(id,category,title,content,image,shot_introduce,plan,wdate);
		
		
	/*	bean.setMember_id(id);
		bean.setCategory(category);
		bean.setTitle(title);
		bean.setContent(content);
		bean.setImage(image);
		bean.setShot_introduce(shot_introduce);
		bean.setPlan(plan);*/
				
				
		BoardDao dao = new BoardDao();
						
		String returnDao = dao.writeDao(bean);
		
		request.setAttribute("writeResult", returnDao);
		
//		return "/view/boardView/writeResult.jsp";	
		return url;
	}
}
