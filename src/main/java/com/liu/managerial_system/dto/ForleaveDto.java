package com.liu.managerial_system.dto;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/5 22:57
 */
public class ForleaveDto {
    private String id;

    private String username;

    private String startday;

    private String endday;

    private String reason;

    private String department;

    private String approval;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", startday=").append(startday);
        sb.append(", endday=").append(endday);
        sb.append(", reason=").append(reason);
        sb.append(", department=").append(department);
        sb.append(", approval=").append(approval);
        sb.append("]");
        return sb.toString();
    }
}
