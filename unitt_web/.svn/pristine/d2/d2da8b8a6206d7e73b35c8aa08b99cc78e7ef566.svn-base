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
         System.out.println("세션이 없다.");
         request.setAttribute("mainTop", "로그인해주세요.");
         // login path
         request.setAttribute("rPath", "unitt_view/jsp/login.jsp");
         request.setAttribute("rNote", "로그인");

         request.setAttribute("mPath", "unitt_view/jsp/register.jsp");
         request.setAttribute("mNote", "회원가입");
         request.setAttribute("mD", "d");

         request.setAttribute("dPath", "/unitt_web/view/#");
         request.setAttribute("dNote", "회원탈퇴 [이용할 수 없습니다.]");
      } else {
         System.out.println("세션이 있다.");
         result = (String) sessionOld.getAttribute("id");
         System.out.println("세션 아이디 "+result);
         request.setAttribute("mainTop", result + " 님 어서오세요.");

         // logout path
         request.setAttribute("rPath", "MemberController?member=logout");
         request.setAttribute("rNote", "로그아웃");

         // modify path
         request.setAttribute("mPath", "unitt_view/jsp/myPage.jsp");
         request.setAttribute("mNote", "마이페이지");

         // withdraw path
         request.setAttribute("dPath", "MemberController?member=withdrawCheck");
         request.setAttribute("dPath", "/unitt_web/MemberController?member=withdrawCheck");
         request.setAttribute("dNote", "회원탈퇴 [이용할 수 있습니다.]");
      }
      return "/unitt_view/jsp/main.jsp";
   }
}