package studentLeaveReview.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/teacher"})
public class TeacherController {

    @RequestMapping(value = {"/check", "/check.html"}, method = RequestMethod.GET)
    String check() {
        return "teacherCheck";
    }
}
