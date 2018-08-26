package com.company.demo3;


public class BoardVO {

    private int id;
    private String subject;
    private String content;
    private String email;
    private String crtDt;
    private String mdfyDt;
    private String fileName;
    private String originFileName;

    @Override
    public String toString() {
        return "BoardVO{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", crtDt='" + crtDt + '\'' +
                ", mdfyDt='" + mdfyDt + '\'' +
                ", fileName='" + fileName + '\'' +
                ", originFileName='" + originFileName + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(String crtDt) {
        this.crtDt = crtDt;
    }

    public String getMdfyDt() {
        return mdfyDt;
    }

    public void setMdfyDt(String mdfyDt) {
        this.mdfyDt = mdfyDt;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }
}
