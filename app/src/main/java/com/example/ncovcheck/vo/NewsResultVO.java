package com.example.ncovcheck.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.EventLogTags;

import java.io.Serializable;
import java.util.List;

public class NewsResultVO {
    private List<NewsListVO> newslist;

    public List<NewsListVO> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewsListVO> newslist) {
        this.newslist = newslist;
    }

    public class NewsListVO{
        private List<WeiJianWeiListVO> news;
        private DescriptionVO desc;

        public List<WeiJianWeiListVO> getNews() {
            return news;
        }

        public void setNews(List<WeiJianWeiListVO> news) {
            this.news = news;
        }

        public DescriptionVO getDesc() {
            return desc;
        }

        public void setDesc(DescriptionVO desc) {
            this.desc = desc;
        }
    }

    public class WeiJianWeiListVO implements Serializable {
        private String pubDateStr;
        private String title;
        private String summary;
        private String infoSource;
        private String sourceUrl;

        public String getPubDateStr() {
            return pubDateStr;
        }

        public void setPubDateStr(String pubDateStr) {
            this.pubDateStr = pubDateStr;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getInfoSource() {
            return infoSource;
        }

        public void setInfoSource(String infoSource) {
            this.infoSource = infoSource;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

    }

    public class DescriptionVO{
        //全国地图
        private String imgurl;
        private String modifyTime;
        private String currentConfirmedCount;
        private String confirmedCount;
        private String suspectedCount;
        private String curedCount;
        private String deadCount;
        private String seriousCount;
        private String suspectedIncr;
        private String currentConfirmedIncr;
        private String confirmedIncr;
        private String curedIncr;
        private String deadIncr;
        private String seriousIncr;
        private String remark1;
        private String remark2;
        private String remark3;
        private String note1;
        private String note2;
        private String note3;
        private String generalRemark;
        private List<MapUrlVO> quanguoTrendChart;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getCurrentConfirmedCount() {
            return currentConfirmedCount;
        }

        public void setCurrentConfirmedCount(String currentConfirmedCount) {
            this.currentConfirmedCount = currentConfirmedCount;
        }

        public String getConfirmedCount() {
            return confirmedCount;
        }

        public void setConfirmedCount(String confirmedCount) {
            this.confirmedCount = confirmedCount;
        }

        public String getSuspectedCount() {
            return suspectedCount;
        }

        public void setSuspectedCount(String suspectedCount) {
            this.suspectedCount = suspectedCount;
        }

        public String getCuredCount() {
            return curedCount;
        }

        public void setCuredCount(String curedCount) {
            this.curedCount = curedCount;
        }

        public String getDeadCount() {
            return deadCount;
        }

        public void setDeadCount(String deadCount) {
            this.deadCount = deadCount;
        }

        public String getSeriousCount() {
            return seriousCount;
        }

        public void setSeriousCount(String seriousCount) {
            this.seriousCount = seriousCount;
        }

        public String getSuspectedIncr() {
            return suspectedIncr;
        }

        public void setSuspectedIncr(String suspectedIncr) {
            this.suspectedIncr = suspectedIncr;
        }

        public String getCurrentConfirmedIncr() {
            return currentConfirmedIncr;
        }

        public void setCurrentConfirmedIncr(String currentConfirmedIncr) {
            this.currentConfirmedIncr = currentConfirmedIncr;
        }

        public String getConfirmedIncr() {
            return confirmedIncr;
        }

        public void setConfirmedIncr(String confirmedIncr) {
            this.confirmedIncr = confirmedIncr;
        }

        public String getCuredIncr() {
            return curedIncr;
        }

        public void setCuredIncr(String curedIncr) {
            this.curedIncr = curedIncr;
        }

        public String getDeadIncr() {
            return deadIncr;
        }

        public void setDeadIncr(String deadIncr) {
            this.deadIncr = deadIncr;
        }

        public String getSeriousIncr() {
            return seriousIncr;
        }

        public void setSeriousIncr(String seriousIncr) {
            this.seriousIncr = seriousIncr;
        }

        public String getRemark1() {
            return remark1;
        }

        public void setRemark1(String remark1) {
            this.remark1 = remark1;
        }

        public String getRemark2() {
            return remark2;
        }

        public void setRemark2(String remark2) {
            this.remark2 = remark2;
        }

        public String getRemark3() {
            return remark3;
        }

        public void setRemark3(String remark3) {
            this.remark3 = remark3;
        }

        public String getNote1() {
            return note1;
        }

        public void setNote1(String note1) {
            this.note1 = note1;
        }

        public String getNote2() {
            return note2;
        }

        public void setNote2(String note2) {
            this.note2 = note2;
        }

        public String getNote3() {
            return note3;
        }

        public void setNote3(String note3) {
            this.note3 = note3;
        }

        public String getGeneralRemark() {
            return generalRemark;
        }

        public void setGeneralRemark(String generalRemark) {
            this.generalRemark = generalRemark;
        }

        public List<MapUrlVO> getQuanguoTrendChart() {
            return quanguoTrendChart;
        }

        public void setQuanguoTrendChart(List<MapUrlVO> quanguoTrendChart) {
            this.quanguoTrendChart = quanguoTrendChart;
        }
    }

    public class MapUrlVO{
        private String imgUrl;
        private String title;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
