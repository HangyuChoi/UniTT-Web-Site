package command.video;

import java.net.URLEncoder;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.VideoBean;
import command.CommandHandler;

import util.MultiPart;

public class UploadService_old implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");

		HttpSession sessionOld = request.getSession(false);
		String sessionId = (String) sessionOld.getAttribute("id");

		MultiPart multiPart = new MultiPart(request);

		String title = multiPart.getParameter("TITLE");
		String fileName = multiPart.getFileName("UPLOAD_FILE");

		// 아이디와 강좌게시판 인덱스가 맞는가. 아닌가 체크





/*		String mp4 = ""; String webm = "";
		// 확장자 체크
		StringTokenizer st = new StringTokenizer(fileName, ".");// 맨뒤에 true 를 쓰면 .도 token에 포함 시킨다.
		// 남아 있는 토큰을 확인하고 while 문으로 루핑
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("mp4")) {
				mp4 = token;
				//System.out.println(token +" 확장자입니다.");
			} else if(token.equals("webm")) {
				webm = token;
				//System.out.println(token +" 확장자입니다.");
			}
		}*/



		String description = multiPart.getParameter("DESCRIPTION");
		String relativePath = request.getServletContext().getRealPath("");

		String newPath = response.encodeURL("C:/Java/tomcat9/webapps/file/2/"+ fileName);

		// 강좌게시판테이블을 조회해서 아이디와 강좌게시판 인덱스를 받아와야함


		//Dao 가 들어갈 위치
		// 강좌게시판 인덱스는 1이라고 지정
		//VideolistBean bean = new VideolistBean(sessionId, "1" , title, mp4, webm, description);
//		VideolistBean bean = new VideolistBean();
//		bean.setMember_id(sessionId);
//		bean.setCourseboard_idx("1");
//		bean.setTitle(title);
//		bean.setVideo_path(mp4);
//		bean.setContent(description);
//		VideoDao dao = new VideoDao();
		// 비디오 다오 작업 안함.

		//String returnDao = dao.loginDao(id, pw);
		//System.out.println(relativePath);


		// 강좌게시판테이블을 조회해서 아이디와 강좌게시판 인덱스를 받아와야함

		multiPart.saveFile("UPLOAD_FILE", newPath);
		//System.out.println(newPath);
		/*String url = String.format("view/videoView/uploadResult.jsp?TITLE=%s&DESCRIPTION=%s&FILE_NAME=%s",
									URLEncoder.encode(title, "UTF-8"),
									URLEncoder.encode(description, "UTF-8"),
									URLEncoder.encode(fileName, "UTF-8"));*/
		//response.sendRedirect("view/categoryView/viewPage.jsp");
		System.out.println("업로드 성공");
		return "view/categoryView/viewPage.jsp";
	}
}
