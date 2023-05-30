package studentLeaveReview.pojo;

import org.apache.ibatis.type.Alias;

import java.util.Date;

public class LeaveRecord {
    Long requestId;
    String applyUser;
    String approveUser;
    Date startTime;
    Date endTime;
    Date requestTime;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public String toString() {
        return "LeaveRecord{" +
                "requestId=" + requestId +
                ", applyUser='" + applyUser + '\'' +
                ", approveUser='" + approveUser + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", requestTime=" + requestTime +
                '}';
    }
}
