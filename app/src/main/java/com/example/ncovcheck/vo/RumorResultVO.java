package com.example.ncovcheck.vo;

import java.util.List;

public class RumorResultVO {
    private List<RumorListVO> newslist;

    public List<RumorListVO> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<RumorListVO> newslist) {
        this.newslist = newslist;
    }

    public class RumorListVO{
        private String date;
        private String title;
        private String explain;
        private String imgsrc;
        private String markstyle;
        private String desc;
        private String author;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getMarkstyle() {
            return markstyle;
        }

        public void setMarkstyle(String markstyle) {
            this.markstyle = markstyle;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
