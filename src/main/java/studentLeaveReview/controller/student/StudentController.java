package studentLeaveReview.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/student"})
public class StudentController {
    @RequestMapping(value = {"/apply", "/apply.html"}, method = RequestMethod.GET)
    String apply() {
        return "studentApply";
    }

    @RequestMapping(value = {"/check", "/check.html"}, method = RequestMethod.GET)
    String check() {
        return "studentCheck";
    }
}
