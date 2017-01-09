package com.liu.takeout.entity;

public class Staff {
    private Integer id;

    private String name;

    private String phone;

    private String email;

    private Short isDelete = 0;

    private Integer staffAuthorityId = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStaffAuthorityId() {
        return staffAuthorityId;
    }

    public void setStaffAuthorityId(Integer staffAuthorityId) {
        this.staffAuthorityId = staffAuthorityId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isDelete=" + isDelete +
                ", staffAuthorityId=" + staffAuthorityId +
                '}';
    }
}