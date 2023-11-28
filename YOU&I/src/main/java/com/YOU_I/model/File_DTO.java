package com.YOU_I.model;

public class File_DTO {

	// 파일 번호 
    private int fileNo;

    // 글 번호 
    private int commNo;

    // 파일 이름 
    private String fileName;

    // 파일 원본 
    private String fileOriName;

    // 파일 썸네일 
    private String fileThumb;

    // AWS S3경로 
    private String fileS3Path;

    // 파일 사이즈 
    private Integer fileSize;

    // 파일 확장자 
    private String ext;

    // 업로드 일자 
    private String uploadedAt;

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public int getCommNo() {
        return commNo;
    }

    public void setCommNo(int commNo) {
        this.commNo = commNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileOriName() {
        return fileOriName;
    }

    public void setFileOriName(String fileOriName) {
        this.fileOriName = fileOriName;
    }

    public String getFileThumb() {
        return fileThumb;
    }

    public void setFileThumb(String fileThumb) {
        this.fileThumb = fileThumb;
    }

    public String getFileS3Path() {
        return fileS3Path;
    }

    public void setFileS3Path(String fileS3Path) {
        this.fileS3Path = fileS3Path;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(String uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
	
	
}
