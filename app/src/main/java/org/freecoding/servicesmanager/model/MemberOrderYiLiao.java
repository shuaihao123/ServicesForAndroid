package org.freecoding.servicesmanager.model;

import java.io.Serializable;

public class MemberOrderYiLiao implements Serializable {

	  private int id;
	  private int type;
	  private String orderNo;
	  private String orderName;
	  private String serviceItem;
	  private String serviceDate;
	  private String serviceTime;
	  private int state;
	  private String custmerPhone;
	  private String orderTime;
	  private String shenheTime;
	  private String quedingTime;
	  private String cancelTime;
	  private String zuofeiTime;
	  private String remark;
	  private String customerName;
	  private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getServiceItem() {
		return serviceItem;
	}
	public void setServiceItem(String serviceItem) {
		this.serviceItem = serviceItem;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCustmerPhone() {
		return custmerPhone;
	}
	public void setCustmerPhone(String custmerPhone) {
		this.custmerPhone = custmerPhone;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getShenheTime() {
		return shenheTime;
	}
	public void setShenheTime(String shenheTime) {
		this.shenheTime = shenheTime;
	}
	public String getQuedingTime() {
		return quedingTime;
	}
	public void setQuedingTime(String quedingTime) {
		this.quedingTime = quedingTime;
	}
	public String getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getZuofeiTime() {
		return zuofeiTime;
	}
	public void setZuofeiTime(String zuofeiTime) {
		this.zuofeiTime = zuofeiTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
