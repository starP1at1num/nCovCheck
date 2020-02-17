package com.example.ncovcheck.vo;

import java.util.List;

public class AreaResultVO {
    private List<AreaListVO> newslist;

    public List<AreaListVO> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<AreaListVO> newslist) {
        this.newslist = newslist;
    }

    public class AreaListVO{
        private String provinceName;
        private String provinceShortName;
        private String currentConfirmedCount;
        private String confirmedCount;
        private String suspectedCount;
        private String curedCount;
        private String deadCount;
        private String comment;
        private List<CitiesListVO> cities;
        private boolean isExpend;

        public boolean isExpend() {
            return isExpend;
        }

        public void setExpend(boolean expend) {
            isExpend = expend;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getProvinceShortName() {
            return provinceShortName;
        }

        public void setProvinceShortName(String provinceShortName) {
            this.provinceShortName = provinceShortName;
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

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public List<CitiesListVO> getCities() {
            return cities;
        }

        public void setCities(List<CitiesListVO> cities) {
            this.cities = cities;
        }
    }

    public class CitiesListVO{
        private String cityName;
        private String currentConfirmedCount;
        private String confirmedCount;
        private String suspectedCount;
        private String curedCount;
        private String deadCount;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
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
    }
}
