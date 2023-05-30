package studentLeaveReview.dao;

import studentLeaveReview.pojo.User;

public interface UserMapper {
    User selectUser(String username);
}
