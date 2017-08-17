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

public class ViewerService_old implements CommandHandler {
	String viewPage;
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int countNum = 0;
		request.setCharacterEncoding("UTF-8");
		String idx = request.getParameter("idx"); // 카테고리 선택
		int idxx = Integer.parseInt(idx);
		VideoDao_old dao = new VideoDao_old();

			System.out.println(idx);
			viewPage = "/view/videoView/show.jsp"; // 비디오 보기
			Map<Integer, Map> returnResult = dao.showVideoDao(idxx);

			ArrayList<VideoBean> mapArr = new ArrayList<VideoBean>();
			VideoBean bean;

			int nParentKey_idx = 0;
			String nChildKey_title = "";
			String szChildValue_name = "";
			Map<String, String> childMapValue = new Hashtable<String, String>();

			System.out.println("ViewerService");
			for (Map.Entry<Integer, Map> parentMapEntry : returnResult.entrySet()) {
				nParentKey_idx = parentMapEntry.getKey(); // 인덱스
				childMapValue = parentMapEntry.getValue(); // 타이틀과 패스를 가지는 맵
				for (Map.Entry<String, String> childMapEntry : childMapValue.entrySet()) {
					nChildKey_title = childMapEntry.getKey(); // 타이틀
					szChildValue_name = childMapEntry.getValue(); // 패스
					bean = new VideoBean();
					bean.setVideolist_idx(nParentKey_idx);
					bean.setTitle(nChildKey_title);
					bean.setVideo_path(szChildValue_name);
					System.out.println("VideoService : "+bean.getVideo_path());
					mapArr.add(bean);
					countNum++;
				}
			}
			//countNum = countNum+1;
			request.setAttribute("countNum", countNum);
			request.setAttribute("mapArr", mapArr);
		return viewPage;
	}
}
