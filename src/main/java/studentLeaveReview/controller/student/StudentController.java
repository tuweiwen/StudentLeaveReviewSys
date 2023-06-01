package studentLeaveReview.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import studentLeaveReview.dao.LeaveRecordMapper;
import studentLeaveReview.pojo.LeaveRecord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static studentLeaveReview.utils.TimeUtils.timeStringProcess;

@Controller
@RequestMapping(value = {"/student"})
public class StudentController {
    @Autowired
    LeaveRecordMapper recordMapper;

    @RequestMapping(value = {"/apply", "/apply.html"}, method = RequestMethod.GET)
    String apply() {
        return "studentApply";
    }

    @RequestMapping(value = {"/check", "/check.html"}, method = RequestMethod.GET)
    String check(HttpServletRequest request, HttpSession session,
                 @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                 @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
        System.out.println("-----StudentController.check-----");

        Object usernameObject = session.getAttribute("username");
        String username = (usernameObject != null) ? (String) usernameObject : "";

        List<LeaveRecord> records = recordMapper.selectRecordsWithApply(username, offset, size);
        request.setAttribute("records", records);

        System.out.println("records -> " + records);
        return "studentCheck";
    }

    @RequestMapping(value = {"/applyServlet"}, method = RequestMethod.POST)
    String applyServlet(@RequestParam(value = "approve_user") String approveUser,
                        @RequestParam(value = "apply_user") String applyUser,
                        @RequestParam(value = "start_time") String startTimeString,
                        @RequestParam(value = "end_time") String endTimeString) {
        System.out.println("-----StudentController.applyServlet-----");
        Date start = timeStringProcess(startTimeString);
        Date end = timeStringProcess(endTimeString);
        if (start.before(end)) {
            recordMapper.insertRecord(applyUser, approveUser, start, end);
        }
        return "redirect:/student/check";
    }
}
