package studentLeaveReview.dao;

import org.apache.ibatis.annotations.Param;
import studentLeaveReview.pojo.User;

import java.util.List;

public interface UserMapper {
    User selectUser(String username);

    List<User> selectUsers(@Param("offset") int offset, @Param("size") int size);
}
