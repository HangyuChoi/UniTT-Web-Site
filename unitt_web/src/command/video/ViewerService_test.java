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
	int startNum = 0; // ������ �ε��� (ù ���� �� 0, ��� Ŭ���� �ش� ������ �ε�����)
	String page = "";
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		String idx = request.getParameter("idx"); // ī�װ� ����
		page = request.getParameter("pageNum");
		if(page != null) {
			startNum = Integer.parseInt(page)-1; // ���� �ε���
		}
		System.out.println("������ ������ �ε��� : " + startNum);
		int idxx = Integer.parseInt(idx);
		VideoDao_test dao = new VideoDao_test();

			//System.out.println(idx);
			viewPage = "/view/videoView/show.jsp"; // ���� ����
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
				nParentKey_idx = parentMapEntry.getKey(); // �ε���
				childMapValue = parentMapEntry.getValue(); // Ÿ��Ʋ�� �н��� ������ ��
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
			//System.out.println("������ ���� �ε���" + countNum);
			//System.out.println("������ �������� �ε���" + startNum);
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
