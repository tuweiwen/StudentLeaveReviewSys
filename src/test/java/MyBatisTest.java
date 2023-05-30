import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import studentLeaveReview.dao.LeaveRecordMapper;
import studentLeaveReview.dao.UserMapper;

public class MyBatisTest {
    public static ApplicationContext ctx;

    @BeforeClass
    public static void getApplicationContext() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void userMapperTest() {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        System.out.println(userMapper.selectUser("admin"));
        System.out.println(userMapper.selectUsers(0, 1));
    }

    @Test
    public void recordMapperTest() {
        LeaveRecordMapper recordMapper = (LeaveRecordMapper) ctx.getBean("leaveRecordMapper");
        System.out.println(recordMapper.selectRecord(2L));
        System.out.println(recordMapper.selectRecords(1, 1));
    }
}
