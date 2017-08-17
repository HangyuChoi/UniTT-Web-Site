package command.search;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchBean;
import command.CommandHandler;
import dao.SearchDao;

public class SearchService implements CommandHandler {
	String viewPage; // 페이지 전환

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String countNum = "";
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("aa"); // 카테고리 선택
		search = new String(search.getBytes("8859_1"), "UTF-8");
		System.out.println("검색 서비스 : " + search);
		SearchDao dao = new SearchDao();

			
			viewPage = "/unitt_view/jsp/category.jsp"; // 강좌 리스트 페이지
			Map<Integer, Map> returnResult = dao.searchDao(search);

			ArrayList<SearchBean> mapArr = new ArrayList<SearchBean>();
			SearchBean bean;

			request.setAttribute("title", search); // 검색한 단어

			int nParentKey_idx = 0;
			String nChildKey_title = "";
			String szChildValue_name = "";
			Map<String, String> childMapValue = new Hashtable<String, String>();

			for (Map.Entry<Integer, Map> parentMapEntry : returnResult.entrySet()) {
				nParentKey_idx = parentMapEntry.getKey();
				childMapValue = parentMapEntry.getValue();
				for (Map.Entry<String, String> childMapEntry : childMapValue.entrySet()) {
					nChildKey_title = childMapEntry.getKey();
					szChildValue_name = childMapEntry.getValue();
					bean = new SearchBean();
					bean.setCourseboard_idx(nParentKey_idx);
					bean.setTitle(nChildKey_title);
					bean.setName(szChildValue_name);
					mapArr.add(bean);
				}
			}
			request.setAttribute("mapArr", mapArr);
//		}
/*		else if (pageNum != 0) {	// 제목을 눌렀다면,
			viewPage = "/view/categoryView/viewPage.jsp";
			dao.selectDao(pageNum);
		}*/
		return viewPage;
	}
}
