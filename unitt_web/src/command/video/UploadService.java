package command.video;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.StringTokenizer;

import com.oreilly.servlet.MultipartRequest;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.CategoryBean;
import bean.VideoBean;
import command.CommandHandler;
import dao.VideoDao;
import util.MultiPart;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UploadService implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		String path = request.getParameter("");
		String page = request.getParameter("pageNum");
		int pageInt = Integer.parseInt(page);

		System.out.println("업로드 클래스 접근");
		System.out.println(page);
		//MultiPart multiPart = new MultiPart(request);
		String fileName = "";
	    String fileLength = "";
	    File file = null;
	    String savePath = "C:/Java/tomcat9/webapps/file/"+page+"/";
	    String count = "";
	    VideoBean bean;
	    int maxSize = 500 * 1024 * 1024; // 최대 업로드 파일 크기 500MB(메가)로 제한
	    String str ="";
	    String tokenArr[] = new String[100];
	    
             try {
            	
            	 ArrayList<VideoBean> arr = new ArrayList<VideoBean>();
                 MultipartRequest multi = new MultipartRequest(request,
                   savePath, maxSize, "euc-kr", new DefaultFileRenamePolicy()); // 중복 이름 뒤에 숫자붙힘 정책
                 count = multi.getParameter("count");
                 Enumeration efiles = multi.getFileNames();
                 String title[] =  multi.getParameterValues("title");
                 String content[] =  multi.getParameterValues("content");
/*                 System.out.println("동영상 강좌 제목"+title[0]);
                 System.out.println("동영상 강좌 내용"+content[0]);
                 System.out.println("동영상 강좌 제목"+title[1]);
                 System.out.println("동영상 강좌 내용"+content[1]);
                 System.out.println("동영상 강좌 제목"+title[2]);
                 System.out.println("동영상 강좌 내용"+content[2]);*/
                 // uploadVideoDao 
                 int fn = 0;
                 while(efiles.hasMoreElements()){
                	 String name = (String)efiles.nextElement();
                     file = multi.getFile(name);    
                     str = file.getName();
                     fn++;
                     if(fn == 1) {
                    	 fileName = str; 
                     } else {
                    	 fileName = fileName+ "/" + str;
                     }
                }
                 System.out.println("5 : "+ fileName);
                 if(!fileName.equals(null)){
                		StringTokenizer st = new StringTokenizer(fileName, "/");// 맨뒤에 true 를 쓰면 /도 token에 포함 시킨다.
                		int countTokens = st.countTokens();
                		System.out.println(st.countTokens());

                		for(int i = 0; i < countTokens; i++) {
                			String token = st.nextToken();
                			tokenArr[countTokens-(i+1)] = token;
                			System.out.println("파일이름" +tokenArr[i]);
                		}	 
                 	}

                 for(int i = 0; i < title.length; i++) {
                	 bean = new VideoBean();
                     bean.setCourseboard_idx(pageInt);
                     bean.setTitle(title[i]);
                     bean.setVideo_path("/"+pageInt+"/"+tokenArr[i]);
                     bean.setContent(content[i]);
                     arr.add(bean);
                 }
                 
                 VideoDao dao = new VideoDao();
                 String returnResult = dao.uploadVideoDao(arr);
                 System.out.print("마지막 결과 : " + returnResult);
                 }catch (Exception e) {
                    System.out.print("예외 발생 : " + e);
                }
     return "CategoryController?category=view&pageNum="+page;  
	}
}
