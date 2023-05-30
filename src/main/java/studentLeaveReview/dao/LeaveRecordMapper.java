package studentLeaveReview.dao;

import org.apache.ibatis.annotations.Param;
import studentLeaveReview.pojo.LeaveRecord;

import java.util.List;

public interface LeaveRecordMapper {
    LeaveRecord selectRecord(@Param("request_id") Long requestId);

    List<LeaveRecord> selectRecords(@Param("offset") int offset, @Param("size") int size);
}
