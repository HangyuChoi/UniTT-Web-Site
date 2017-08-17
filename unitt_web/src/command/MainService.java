package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import command.CommandHandler;

public class MainService implements CommandHandler {
   String result;
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
      request.setCharacterEncoding("UTF-8");
      HttpSession sessionOld = request.getSession(false);
      result = (String) sessionOld.getAttribute("id");
      if(result == null) {
         System.out.println("������ ����.");
         request.setAttribute("mainTop", "�α������ּ���.");
         // login path
         request.setAttribute("rPath", "unitt_view/jsp/login.jsp");
         request.setAttribute("rNote", "�α���");

         request.setAttribute("mPath", "unitt_view/jsp/register.jsp");
         request.setAttribute("mNote", "ȸ������");
         request.setAttribute("mD", "d");

         request.setAttribute("dPath", "/unitt_web/view/#");
         request.setAttribute("dNote", "ȸ��Ż�� [�̿��� �� �����ϴ�.]");
      } else {
         System.out.println("������ �ִ�.");
         result = (String) sessionOld.getAttribute("id");
         System.out.println("���� ���̵� "+result);
         request.setAttribute("mainTop", result + " �� �������.");

         // logout path
         request.setAttribute("rPath", "MemberController?member=logout");
         request.setAttribute("rNote", "�α׾ƿ�");

         // modify path
         request.setAttribute("mPath", "unitt_view/jsp/myPage.jsp");
         request.setAttribute("mNote", "����������");

         // withdraw path
         request.setAttribute("dPath", "MemberController?member=withdrawCheck");
         request.setAttribute("dPath", "/unitt_web/MemberController?member=withdrawCheck");
         request.setAttribute("dNote", "ȸ��Ż�� [�̿��� �� �ֽ��ϴ�.]");
      }
      return "/unitt_view/jsp/main.jsp";
   }
}