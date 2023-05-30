package studentLeaveReview.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping(value = {"/home", "/home.html"}, method = RequestMethod.GET)
    String home(HttpServletRequest request, HttpSession session) {
        System.out.println("-----home-----");
        return "home";
    }

    @RequestMapping(value = {"/logoutServlet"}, method = RequestMethod.GET)
    String logoutServlet(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("isLogin");
        session.removeAttribute("username");
        return "redirect:index";
    }
}
