package command.category;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CategoryBean;
import command.CommandHandler;
import dao.CategoryDao;

public class CategoryService implements CommandHandler {
	String viewPage; // 페이지 전환

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String countNum = "";
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("select"); // 카테고리 선택

		CategoryDao dao = new CategoryDao();

			System.out.println(category);
			viewPage = "/unitt_view/jsp/category.jsp"; // 강좌 리스트 페이지
			Map<Integer, Map> returnResult = dao.searchDao(category);

			ArrayList<CategoryBean> mapArr = new ArrayList<CategoryBean>();
			CategoryBean bean;

			request.setAttribute("title", category); // 클릭한 카테고리

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
					bean = new CategoryBean();
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
