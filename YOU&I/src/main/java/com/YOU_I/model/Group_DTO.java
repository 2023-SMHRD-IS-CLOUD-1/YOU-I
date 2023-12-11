package com.YOU_I.model;


public class Group_DTO {
	private int groupNo;
    private String groupName;
    private int hobbyNo;
    private String hobbyName;

    public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

    private int groupLikes;
    private String createdAt;
    private Integer groupMembershipFee;
    private String groupInfo;

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getHobbyNo() {
        return hobbyNo;
    }

    public void setHobbyNo(int hobbyNo) {
        this.hobbyNo = hobbyNo;
    }

    public int getGroupLikes() {
        return groupLikes;
    }

    public void setGroupLikes(int groupLikes) {
        this.groupLikes = groupLikes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getGroupMembershipFee() {
        return groupMembershipFee;
    }

    public void setGroupMembershipFee(Integer groupMembershipFee) {
        this.groupMembershipFee = groupMembershipFee;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }
    
    
	
	
}
