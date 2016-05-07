package org.freecoding.servicesmanager.model;


import java.io.Serializable;

public class MemberLogin implements Serializable {

	  private int memberId;
	  private String memberName;
	  private String phone;
	  private String password;
	  private int type;
	  private int state;
	  private String remark;
	  private String createTime;
	  private String updateTime;
	  private String lastFailedLogintime;
	  private int loginFailedCount;
	  private String registerTime;
	  private String loginTime;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public String getLastFailedLogintime() {
		return lastFailedLogintime;
	}
	public void setLastFailedLogintime(String lastFailedLogintime) {
		this.lastFailedLogintime = lastFailedLogintime;
	}
	public int getLoginFailedCount() {
		return loginFailedCount;
	}
	public void setLoginFailedCount(int loginFailedCount) {
		this.loginFailedCount = loginFailedCount;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
}
