package studentLeaveReview.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {
    @RequestMapping(value = {"/users", "/users.html"}, method = RequestMethod.GET)
    String usersPage() {
        return "editUsers";
    }

    @RequestMapping(value = {"/leave", "/leave.html"}, method = RequestMethod.GET)
    String leaveRecord() {
        return "editLeaveRecords";
    }
}
