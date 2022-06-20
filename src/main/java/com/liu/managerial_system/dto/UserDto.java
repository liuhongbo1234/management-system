package com.liu.managerial_system.dto;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/3 17:09
 */
public class UserDto {
    private Integer id;

    private String username;

    private String password;

    private String department;

    private String myrole;

    private String out;

    private String outtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMyrole() {
        return myrole;
    }

    public void setMyrole(String myrole) {
        this.myrole = myrole;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", department=").append(department);
        sb.append(", myrole=").append(myrole);
        sb.append(", out=").append(out);
        sb.append(", outtime=").append(outtime);
        sb.append("]");
        return sb.toString();
    }
}
