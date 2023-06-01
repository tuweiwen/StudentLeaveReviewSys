import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import studentLeaveReview.dao.LeaveRecordMapper;
import studentLeaveReview.dao.UserMapper;
import studentLeaveReview.utils.TimeUtils;

import java.util.Date;

public class MyBatisTest {
    public static ApplicationContext ctx;

    @BeforeClass
    public static void getApplicationContext() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void userMapperTest() {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
//        System.out.println(userMapper.selectUser("admin"));
//        System.out.println(userMapper.selectUsers(0, 1));

        userMapper.updateUser("student1", "student");
        System.out.println(userMapper.selectUsers(0, 10));
    }

    @Test
    public void recordMapperTest() {
        LeaveRecordMapper recordMapper = (LeaveRecordMapper) ctx.getBean("leaveRecordMapper");
//        System.out.println(recordMapper.selectRecord(2L));
//        System.out.println(recordMapper.selectRecords(0, 10));
//        System.out.println(recordMapper.selectRecordsWithApply("student1", 0, 10));
//        System.out.println(recordMapper.selectRecordsWithApprove("teacher1", 0, 10));

//        System.out.println(recordMapper.updateRecordWithId(1L, (short) 2));
//        System.out.println(recordMapper.selectRecords(0, 10));

//        Date start = new Date(System.currentTimeMillis());
//        Date end = new Date(System.currentTimeMillis());
//        System.out.println("start -> " + start);
//        System.out.println("end -> " + end);
//        recordMapper.insertRecord("student1", "teacher1", start, end);
//        System.out.println(recordMapper.selectRecords(0, 10));
        Date d = new Date(System.currentTimeMillis());
        recordMapper.updateRecordWithId(1L, "teacher1", d, d, (short) 2);
        System.out.println(recordMapper.selectRecords(0, 1));
    }

    @Test
    public void timeUtilsTest() {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(TimeUtils.timeDateProcess(date));
    }
}
