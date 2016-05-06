package org.freecoding.servicesmanager.model;


import java.io.Serializable;

public class JiaZhengServiceItem implements Serializable{

	  private int id;
	  private int type;
	  private String name;
	  private String serviceItem;
	  private String remark;
	  private String createTime;
	  private String updateTime;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServiceItem() {
		return serviceItem;
	}
	public void setServiceItem(String serviceItem) {
		this.serviceItem = serviceItem;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	  
}
