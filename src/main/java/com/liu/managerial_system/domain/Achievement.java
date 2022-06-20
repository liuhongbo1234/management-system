package com.liu.managerial_system.domain;

public class Achievement {
    private String id;

    private String achieveCatagory;

    private String name;

    private String firstAuthor;

    private String secondAuthor;

    private String thirdAuthor;

    private String otherAuthors;

    private String level;

    private String time;

    private String funds;

    private String process;

    private String resource;

    private String application;

    private String othermsg;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAchieveCatagory() {
        return achieveCatagory;
    }

    public void setAchieveCatagory(String achieveCatagory) {
        this.achieveCatagory = achieveCatagory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAuthor() {
        return firstAuthor;
    }

    public void setFirstAuthor(String firstAuthor) {
        this.firstAuthor = firstAuthor;
    }

    public String getSecondAuthor() {
        return secondAuthor;
    }

    public void setSecondAuthor(String secondAuthor) {
        this.secondAuthor = secondAuthor;
    }

    public String getThirdAuthor() {
        return thirdAuthor;
    }

    public void setThirdAuthor(String thirdAuthor) {
        this.thirdAuthor = thirdAuthor;
    }

    public String getOtherAuthors() {
        return otherAuthors;
    }

    public void setOtherAuthors(String otherAuthors) {
        this.otherAuthors = otherAuthors;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getOthermsg() {
        return othermsg;
    }

    public void setOthermsg(String othermsg) {
        this.othermsg = othermsg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", achieveCatagory=").append(achieveCatagory);
        sb.append(", name=").append(name);
        sb.append(", firstAuthor=").append(firstAuthor);
        sb.append(", secondAuthor=").append(secondAuthor);
        sb.append(", thirdAuthor=").append(thirdAuthor);
        sb.append(", otherAuthors=").append(otherAuthors);
        sb.append(", level=").append(level);
        sb.append(", time=").append(time);
        sb.append(", funds=").append(funds);
        sb.append(", process=").append(process);
        sb.append(", resource=").append(resource);
        sb.append(", application=").append(application);
        sb.append(", othermsg=").append(othermsg);
        sb.append(", username=").append(username);
        sb.append("]");
        return sb.toString();
    }
}