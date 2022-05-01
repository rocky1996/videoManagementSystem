package com.example.videomanagementsystem.domain;

import java.util.Date;

public class VideoSystemCustomer {
    private Integer id;

    private String customerName;

    private Integer pushVolume;

    private Integer customerStatus;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private String customerSecretKey;

    private String customerGatherAuth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPushVolume() {
        return pushVolume;
    }

    public void setPushVolume(Integer pushVolume) {
        this.pushVolume = pushVolume;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCustomerSecretKey() {
        return customerSecretKey;
    }

    public void setCustomerSecretKey(String customerSecretKey) {
        this.customerSecretKey = customerSecretKey;
    }

    public String getCustomerGatherAuth() {
        return customerGatherAuth;
    }

    public void setCustomerGatherAuth(String customerGatherAuth) {
        this.customerGatherAuth = customerGatherAuth;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerName=").append(customerName);
        sb.append(", pushVolume=").append(pushVolume);
        sb.append(", customerStatus=").append(customerStatus);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", customerSecretKey=").append(customerSecretKey);
        sb.append(", customerGatherAuth=").append(customerGatherAuth);
        sb.append("]");
        return sb.toString();
    }
}