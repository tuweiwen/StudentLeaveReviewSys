package studentLeaveReview.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import studentLeaveReview.dao.LeaveRecordMapper;
import studentLeaveReview.dao.UserMapper;
import studentLeaveReview.pojo.LeaveRecord;
import studentLeaveReview.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    LeaveRecordMapper recordMapper;

    @RequestMapping(value = {"/users", "/users.html"}, method = RequestMethod.GET)
    String usersPage(HttpServletRequest request,
                     @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                     @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
        List<User> users = userMapper.selectUsers(offset, size);
        request.setAttribute("users", users);
        return "adminUsers";
    }

    @RequestMapping(value = {"/leave", "/leave.html"}, method = RequestMethod.GET)
    String leaveRecord(HttpServletRequest request,
                       @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                       @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
        System.out.println("-----AdminController.leaveRecord-----");
        List<LeaveRecord> records = recordMapper.selectRecords(offset, size);
        request.setAttribute("records", records);
        return "adminRecords";
    }
}
