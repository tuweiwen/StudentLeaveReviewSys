package studentLeaveReview.dao;

import org.apache.ibatis.annotations.Param;
import studentLeaveReview.pojo.LeaveRecord;

import java.util.Date;
import java.util.List;

public interface LeaveRecordMapper {
    LeaveRecord selectRecord(@Param("request_id") Long requestId);

    List<LeaveRecord> selectRecords(@Param("offset") int offset, @Param("size") int size);

    List<LeaveRecord> selectRecordsWithApply(@Param("username") String applyUser, @Param("offset") int offset, @Param("size") int size);

    List<LeaveRecord> selectRecordsWithApprove(@Param("username") String approveUser, @Param("offset") int offset, @Param("size") int size);

    int updateRecordStatusWithId(@Param("id") long requestId, @Param("status") short status);

    int updateRecordWithId(@Param("id") long requestId, @Param("approve_user") String approveUser, @Param("start_time") Date startTime, @Param("end_time") Date endTime, @Param("status") short status);

    int insertRecord(@Param("apply") String applyUser, @Param("approve") String approveUser, @Param("start_time") Date startTime, @Param("end_time") Date endTime);

    int deleteRecord(@Param("request_id") long requestId);
}
