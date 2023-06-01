package studentLeaveReview.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import studentLeaveReview.dao.LeaveRecordMapper;
import studentLeaveReview.pojo.LeaveRecord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = {"/teacher"})
public class TeacherController {
    @Autowired
    LeaveRecordMapper recordMapper;

    @RequestMapping(value = {"/check", "/check.html", "/check.jsp"}, method = RequestMethod.GET)
    String check(HttpServletRequest request, HttpSession session,
                 @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                 @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
        System.out.println("-----TeacherController.check-----");
        Object usernameObject = session.getAttribute("username");
        String username = (usernameObject != null) ? (String) usernameObject : "";
        List<LeaveRecord> records = recordMapper.selectRecordsWithApprove(username, offset, size);
        request.setAttribute("records", records);
        return "teacherCheck";
    }

    @RequestMapping(value = "/handleRecordServlet", method = RequestMethod.GET)
    String handleRecordServlet(@RequestParam(value = "id") long requestId,
                               @RequestParam(value = "status") short status) {
        System.out.println("-----TeacherController.handleRecordServlet-----");
        recordMapper.updateRecordStatusWithId(requestId, status);
        return "redirect:/teacher/check";
    }
}
