package com.YOU_I.model;

import java.sql.Date;

import com.google.gson.annotations.SerializedName;

public class calendar_DTO {

	@SerializedName("SCHE_NO")
	private Long scheNo; // NUMBER(18, 0)
	@SerializedName("SCHE_TITLE")
    private String scheTitle; // VARCHAR2(1500)
	@SerializedName("SCHE_CONTENT")
    private String scheContent; // CLOB
	@SerializedName("SCHE_ST_DATE")
    private Date scheStDate; // DATE
	@SerializedName("SCHE_END_DATE")
    private Date scheEndDate; // DATE
	@SerializedName("GROUP_NO")
    private Long groupNo; // NUMBER(18, 0)
	@SerializedName("SCHE_COLOR")
    private String scheColor; // VARCHAR2(12)
	private char scheDoneCheck;
	public Long getScheNo() {
		return scheNo;
	}
	public void setScheNo(Long scheNo) {
		this.scheNo = scheNo;
	}
	public String getScheTitle() {
		return scheTitle;
	}
	public void setScheTitle(String scheTitle) {
		this.scheTitle = scheTitle;
	}
	public String getScheContent() {
		return scheContent;
	}
	public void setScheContent(String scheContent) {
		this.scheContent = scheContent;
	}
	public Date getScheStDate() {
		return scheStDate;
	}
	public void setScheStDate(Date scheStDate) {
		this.scheStDate = scheStDate;
	}
	public Date getScheEndDate() {
		return scheEndDate;
	}
	public void setScheEndDate(Date scheEndDate) {
		this.scheEndDate = scheEndDate;
	}
	public Long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public String getScheColor() {
		return scheColor;
	}
	public void setScheColor(String scheColor) {
		this.scheColor = scheColor;
	}
	public char getScheDoneCheck() {
		return scheDoneCheck;
	}
	public void setScheDoneCheck(char scheDoneCheck) {
		this.scheDoneCheck = scheDoneCheck;
	}
    
    
}
