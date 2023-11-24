package com.YOU_I.model;

import java.sql.Date;

public class Group_DTO {
	private Long groupNo;
    private String groupName;
    private String groupCategory;
    private Long groupLikes;
    private Date createdAt;
    private int groupMembershipFee;
	public Long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupCategory() {
		return groupCategory;
	}
	public void setGroupCategory(String groupCategory) {
		this.groupCategory = groupCategory;
	}
	public Long getGroupLikes() {
		return groupLikes;
	}
	public void setGroupLikes(Long groupLikes) {
		this.groupLikes = groupLikes;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getGroupMembershipFee() {
		return groupMembershipFee;
	}
	public void setGroupMembershipFee(int groupMembershipFee) {
		this.groupMembershipFee = groupMembershipFee;
	}
    
    
	
	
}
