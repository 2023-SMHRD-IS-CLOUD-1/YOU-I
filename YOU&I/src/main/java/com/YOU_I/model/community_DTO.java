package com.YOU_I.model;

import java.sql.Date;

public class community_DTO {
		private int comm_no;
		private int comment_no;
		
		private int groupNo;
	    //게시자아이디
	    private String id;
	    //올린내용
	    private String commContent;
	    //댓글내용
	    private String comment_content;
	    // 게시 일자
	    private Date postDate;
	    //좋아요
	    private int likes;
		public int getComm_no() {
			return comm_no;
		}
		public void setComm_no(int comm_no) {
			this.comm_no = comm_no;
		}
		public int getGroupNo() {
			return groupNo;
		}
		public void setGroupNo(int groupNo) {
			this.groupNo = groupNo;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getCommContent() {
			return commContent;
		}
		public void setCommContent(String commContent) {
			this.commContent = commContent;
		}
		public String getComment_content() {
			return comment_content;
		}
		public void setComment_content(String comment_content) {
			this.comment_content = comment_content;
		}
		public Date getPostDate() {
			return postDate;
		}
		public void setPostDate(Date postDate) {
			this.postDate = postDate;
		}
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		public int getComment_no() {
			return comment_no;
		}
		public void setComment_no(int comment_no) {
			this.comment_no = comment_no;
		}
	
	    
		
	    
}