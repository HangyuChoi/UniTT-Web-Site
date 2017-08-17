package command.video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CategoryBean;
import bean.VideolistBean;
import command.CommandHandler;
import dao.CategoryDao;
import dao.VideoDao;
import dao.VideoDao_test;

public class ViewerService_test implements CommandHandler {
	String viewPage;
	int startNum = 0; // 동영상 인덱스 (첫 시작 시 0, 목록 클릭시 해당 동영상 인덱스로)
	String page = "";
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		String idx = request.getParameter("idx"); // 카테고리 선택
		page = request.getParameter("pageNum");
		if(page != null) {
			startNum = Integer.parseInt(page)-1; // 비디오 인덱스
		}
		System.out.println("선택한 동영상 인덱스 : " + startNum);
		int idxx = Integer.parseInt(idx);
		VideoDao_test dao = new VideoDao_test();

			//System.out.println(idx);
			viewPage = "/view/videoView/show.jsp"; // 비디오 보기
			Map<Integer, ArrayList> returnResult = dao.showVideoDao(idxx);

			ArrayList<VideolistBean> mapArr = new ArrayList<VideolistBean>();
			VideolistBean bean;

			int nParentKey_idx = 0;
			String nChild_title = "";
			String szChild_path = "";
			String tChild_content = "";
			ArrayList<VideolistBean> childMapValue = new ArrayList<VideolistBean>();
			int countNum = 0;
			//System.out.println("ViewerService");
			for (Map.Entry<Integer, ArrayList> parentMapEntry : returnResult.entrySet()) {
				nParentKey_idx = parentMapEntry.getKey(); // 인덱스
				childMapValue = parentMapEntry.getValue(); // 타이틀과 패스를 가지는 맵
			}
				for (int i = 0; i < childMapValue.size(); i++) {
					bean = new VideolistBean();
					bean.setVideolist_idx(nParentKey_idx);
					bean.setTitle(childMapValue.get(i).getTitle());
					bean.setVideo_path(childMapValue.get(i).getVideo_path());
					bean.setContent(childMapValue.get(i).getContent());
					bean.setCourseboard_idx(childMapValue.get(i).getCourseboard_idx());
					//System.out.println("VideoService : "+bean.getVideo_path());
					mapArr.add(bean);
					countNum++;
				}
			//countNum = countNum+1;
			//System.out.println("선택한 강좌 인덱스" + countNum);
			//System.out.println("선택한 동영상목록 인덱스" + startNum);
			//request.setAttribute("number", startNum);
			request.setAttribute("idx", idx);
			request.setAttribute("title", mapArr.get(startNum).getTitle()); // 0
			request.setAttribute("content", mapArr.get(startNum).getContent());
			request.setAttribute("path", mapArr.get(startNum).getVideo_path());
			request.setAttribute("countNum", countNum);
			request.setAttribute("mapArr", mapArr);
		return viewPage;
	}
}
