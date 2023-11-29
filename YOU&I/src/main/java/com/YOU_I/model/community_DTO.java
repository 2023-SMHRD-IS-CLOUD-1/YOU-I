package com.YOU_I.model;

import java.sql.Date;

public class community_DTO {
	    //게시자아이디
	    private String postId;
	    //올린내용
	    private String commContent;
	    //댓글아이디
	    private String commentid;
	    //댓글내용
	    private String comment_content;
	    // 게시 일자
	    private Date postDate;
	    //좋아요
	    private int likes;
		public String getPostId() {
			return postId;
		}
		public void setPostId(String postId) {
			this.postId = postId;
		}
		public String getCommContent() {
			return commContent;
		}
		public void setCommContent(String commContent) {
			this.commContent = commContent;
		}
		public String getCommentid() {
			return commentid;
		}
		public void setCommentid(String commentid) {
			this.commentid = commentid;
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
	    
}