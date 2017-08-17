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

		// ���̵�� ���°Խ��� �ε����� �´°�. �ƴѰ� üũ





/*		String mp4 = ""; String webm = "";
		// Ȯ���� üũ
		StringTokenizer st = new StringTokenizer(fileName, ".");// �ǵڿ� true �� ���� .�� token�� ���� ��Ų��.
		// ���� �ִ� ��ū�� Ȯ���ϰ� while ������ ����
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("mp4")) {
				mp4 = token;
				//System.out.println(token +" Ȯ�����Դϴ�.");
			} else if(token.equals("webm")) {
				webm = token;
				//System.out.println(token +" Ȯ�����Դϴ�.");
			}
		}*/



		String description = multiPart.getParameter("DESCRIPTION");
		String relativePath = request.getServletContext().getRealPath("");

		String newPath = response.encodeURL("C:/Java/tomcat9/webapps/file/2/"+ fileName);

		// ���°Խ������̺��� ��ȸ�ؼ� ���̵�� ���°Խ��� �ε����� �޾ƿ;���


		//Dao �� �� ��ġ
		// ���°Խ��� �ε����� 1�̶�� ����
		//VideolistBean bean = new VideolistBean(sessionId, "1" , title, mp4, webm, description);
//		VideolistBean bean = new VideolistBean();
//		bean.setMember_id(sessionId);
//		bean.setCourseboard_idx("1");
//		bean.setTitle(title);
//		bean.setVideo_path(mp4);
//		bean.setContent(description);
//		VideoDao dao = new VideoDao();
		// ���� �ٿ� �۾� ����.

		//String returnDao = dao.loginDao(id, pw);
		//System.out.println(relativePath);


		// ���°Խ������̺��� ��ȸ�ؼ� ���̵�� ���°Խ��� �ε����� �޾ƿ;���

		multiPart.saveFile("UPLOAD_FILE", newPath);
		//System.out.println(newPath);
		/*String url = String.format("view/videoView/uploadResult.jsp?TITLE=%s&DESCRIPTION=%s&FILE_NAME=%s",
									URLEncoder.encode(title, "UTF-8"),
									URLEncoder.encode(description, "UTF-8"),
									URLEncoder.encode(fileName, "UTF-8"));*/
		//response.sendRedirect("view/categoryView/viewPage.jsp");
		System.out.println("���ε� ����");
		return "view/categoryView/viewPage.jsp";
	}
}
