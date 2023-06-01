package studentLeaveReview.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import studentLeaveReview.dao.LeaveRecordMapper;
import studentLeaveReview.dao.UserMapper;
import studentLeaveReview.pojo.LeaveRecord;
import studentLeaveReview.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static studentLeaveReview.utils.TimeUtils.timeStringProcess;

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

    @RequestMapping(value = {"/editUser", "/editUser.html"}, method = RequestMethod.GET)
    ModelAndView editUserPage(@RequestParam(value = "username") String username) {
        User user = userMapper.selectUser(username);
        ModelAndView modelAndView = new ModelAndView("adminEditUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = {"/editUserServlet"}, method = RequestMethod.POST)
    String editUserServlet(@RequestParam("username") String username, @RequestParam("password") String password) {
        userMapper.updateUser(username, password);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = {"/editRecord", "/editRecord.html"}, method = RequestMethod.GET)
    String editRecordPage(HttpServletRequest request,
                          @RequestParam("request_id") long requestId) {
        LeaveRecord record = recordMapper.selectRecord(requestId);
        request.setAttribute("record", record);
        return "adminEditRecord";
    }

    @RequestMapping(value = {"/editRecordServlet"}, method = RequestMethod.POST)
    String editRecordServlet(@RequestParam("request_id") long requestId,
                             @RequestParam("approve_user") String approveUser,
                             @RequestParam("start_time") String start_time,
                             @RequestParam("end_time") String end_time,
                             @RequestParam("status") short status) {
        recordMapper.updateRecordWithId(requestId, approveUser, timeStringProcess(start_time), timeStringProcess(end_time), status);
        return "redirect:/admin/leave";
    }

    @RequestMapping(value = {"/deleteUserServlet"}, method = RequestMethod.GET)
    String deleteUserServlet(@RequestParam("username") String username) {
        userMapper.deleteUser(username);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = {"/deleteRecordServlet"}, method = RequestMethod.GET)
    String deleteRecordServlet(@RequestParam("request_id") long requestId) {
        recordMapper.deleteRecord(requestId);
        return "redirect:/admin/leave";
    }
}
