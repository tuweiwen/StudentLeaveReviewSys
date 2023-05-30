package studentLeaveReview.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import studentLeaveReview.dao.UserMapper;
import studentLeaveReview.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = {"/", "/index.html", "index"})
    public String index() {
        System.out.println("-----index-----");
        return "index";
    }

    @RequestMapping(value = "/loginServlet", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session) {
        System.out.println("-----login-----");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userMapper.selectUser(username);

        if (password.equals(user.getPassword())) {
            session.setAttribute("isLogin", true);
            session.setAttribute("username", username);
            session.setAttribute("type", user.getType());
            return "redirect:/home";
        } else {
            return "redirect:/index";
        }
    }
}
