package com.YOU_I.model;

import java.sql.Date;

public class calendar_DTO {

	
	private Long scheNo; // NUMBER(18, 0)
    private String scheTitle; // VARCHAR2(1500)
    private String scheContent; // CLOB
    private Date scheStDate; // DATE
    private Date scheEndDate; // DATE
    private Long groupNo; // NUMBER(18, 0)
    private String scheColor; // VARCHAR2(12)
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
    
    
}
