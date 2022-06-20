package com.liu.managerial_system.domain;

public class Task {
    private String id;

    private String start;

    private String end;

    private String name;

    private String content;

    private String assigndepartment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAssigndepartment() {
        return assigndepartment;
    }

    public void setAssigndepartment(String assigndepartment) {
        this.assigndepartment = assigndepartment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", name=").append(name);
        sb.append(", content=").append(content);
        sb.append(", assigndepartment=").append(assigndepartment);
        sb.append("]");
        return sb.toString();
    }
}