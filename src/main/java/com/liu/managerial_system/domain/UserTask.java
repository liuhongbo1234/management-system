package com.liu.managerial_system.domain;

public class UserTask {
    private String id;

    private String username;

    private String newtask;

    private String taskid;

    private String department;

    private String assigner;

    private String content;

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

    public String getNewtask() {
        return newtask;
    }

    public void setNewtask(String newtask) {
        this.newtask = newtask;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", newtask=").append(newtask);
        sb.append(", taskid=").append(taskid);
        sb.append(", department=").append(department);
        sb.append(", assigner=").append(assigner);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}