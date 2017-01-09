package com.liu.takeout.entity;

/**
 * Created by anybody on 2016/12/14.
 */
public class OrderManager {

    private Long id;
    private String merchantName;
    private String merchantAddress;
    private String merchantPhone;
    private String receipterName;
    private String receipterAddress;
    private String receipterPhone;
    private String riderName;
    private String riderPhone;
    private String statusName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public String getReceipterName() {
        return receipterName;
    }

    public void setReceipterName(String receipterName) {
        this.receipterName = receipterName;
    }

    public String getReceipterAddress() {
        return receipterAddress;
    }

    public void setReceipterAddress(String receipterAddress) {
        this.receipterAddress = receipterAddress;
    }

    public String getReceipterPhone() {
        return receipterPhone;
    }

    public void setReceipterPhone(String receipterPhone) {
        this.receipterPhone = receipterPhone;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getRiderPhone() {
        return riderPhone;
    }

    public void setRiderPhone(String riderPhone) {
        this.riderPhone = riderPhone;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "OrderManager{" +
                "id=" + id +
                ", merchantName='" + merchantName + '\'' +
                ", merchantAddress='" + merchantAddress + '\'' +
                ", merchantPhone='" + merchantPhone + '\'' +
                ", receipterName='" + receipterName + '\'' +
                ", receipterAddress='" + receipterAddress + '\'' +
                ", receipterPhone='" + receipterPhone + '\'' +
                ", riderName='" + riderName + '\'' +
                ", riderPhone='" + riderPhone + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
