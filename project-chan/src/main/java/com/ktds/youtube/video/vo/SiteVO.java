package com.ktds.youtube.video.vo;

//@lombok.Data
public class SiteVO {

    private  int siteId;
    private  String siteName;

    public SiteVO() {}
    public SiteVO(String sName) {
        this.siteName = sName;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public String toString() {
        return "SiteVO{" +
            "siteId=" + siteId +
            ", siteName='" + siteName + '\'' +
            '}';
    }
}
