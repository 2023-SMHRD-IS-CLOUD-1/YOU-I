package com.YOU_I.model;

import javax.xml.crypto.Data;

public class User_DTO {
	// 웹페이지 사용자
	public class tblUser {

		// 사용자 아이디
		private String id;

		// 사용자 비밀번호
		private String pw;

		// 사용자 성별
		private String gender;

		// 사용자 닉네임
		private String nick;

		// 사용자 활동지역
		private String region;

		// 사용자 관심취미
		private String hobby;

		// 사용자 전화번호
		private String phone;

		// 사용자 튜토리얼유무
		private String tutorialSt;

		// 사용자 프로필사진
		private String profileImg;

		// 사용자 권한
		private String userRole;

		// 가입일자
		private Data joinedAt;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPw() {
			return pw;
		}

		public void setPw(String pw) {
			this.pw = pw;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getHobby() {
			return hobby;
		}

		public void setHobby(String hobby) {
			this.hobby = hobby;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getTutorialSt() {
			return tutorialSt;
		}

		public void setTutorialSt(String tutorialSt) {
			this.tutorialSt = tutorialSt;
		}

		public String getProfileImg() {
			return profileImg;
		}

		public void setProfileImg(String profileImg) {
			this.profileImg = profileImg;
		}

		public String getUserRole() {
			return userRole;
		}

		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}

		public Data getJoinedAt() {
			return joinedAt;
		}

		public void setJoinedAt(Data joinedAt) {
			this.joinedAt = joinedAt;
		}

		// tblUser 모델 복사
		public void CopyData(tblUser param) {
			this.id = param.getId();
			this.pw = param.getPw();
			this.gender = param.getGender();
			this.nick = param.getNick();
			this.region = param.getRegion();
			this.hobby = param.getHobby();
			this.phone = param.getPhone();
			this.tutorialSt = param.getTutorialSt();
			this.profileImg = param.getProfileImg();
			this.userRole = param.getUserRole();
			this.joinedAt = param.getJoinedAt();
		}
	}
}
