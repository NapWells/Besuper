package com.liu.takeout.entity;

import java.util.Date;

public class Rider {
    private Integer id;



    private String name;

    private String phone;

    private Date applyTime;

    private Date passTime;

    private String idCardNumber;

    private String picUrl;

    private Integer riderStatusId;

    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getPassTime() {
        return passTime;
    }

    public void setPassTime(Date passTime) {
        this.passTime = passTime;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber == null ? null : idCardNumber.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getRiderStatusId() {
        return riderStatusId;
    }

    public void setRiderStatusId(Integer riderStatusId) {
        this.riderStatusId = riderStatusId;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}