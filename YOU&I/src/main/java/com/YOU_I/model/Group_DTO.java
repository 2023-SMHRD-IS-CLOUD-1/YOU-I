package com.YOU_I.model;


public class Group_DTO {
	private int groupNo;

    // 그룹 이름 
    private String groupName;

    // 취미 번호 
    private int hobbyNo;
    
    // 취미 이름
    private String hobbyName;

    public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	// 좋아요수 
    private int groupLikes;

    // 만든 날짜 
    private String createdAt;

    // 가입비 
    private Integer groupMembershipFee;

    // 그룹 소개 
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
