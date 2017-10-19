package com.bc.lkh.ctrip.bean;

import java.util.List;

/**
 * Created by 刘凯华 on 2017/8/31.
 */

public class Travel {

    /**
     * msg : success
     * result : [{"arriveTime":"14:33","endStationName":"邢台","lishi":"04:41","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"09:52","stationTrainCode":"K279","trainClassName":"快速"},{"arriveTime":"14:45","endStationName":"邢台","lishi":"04:14","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"10:31","stationTrainCode":"K589","trainClassName":"快速"},{"arriveTime":"12:53","endStationName":"邢台","lishi":"04:47","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"08:06","stationTrainCode":"K21","trainClassName":"快速"},{"arriveTime":"18:52","endStationName":"邢台","lishi":"03:41","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"15:11","stationTrainCode":"T49","trainClassName":"特快"},{"arriveTime":"11:38","endStationName":"邢台","lishi":"04:26","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"07:12","stationTrainCode":"K819","trainClassName":"快速"},{"arriveTime":"18:40","endStationName":"邢台","lishi":"03:35","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"15:05","stationTrainCode":"T9","trainClassName":"特快"},{"arriveTime":"13:09","endStationName":"邢台","lishi":"04:24","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"08:45","stationTrainCode":"K471","trainClassName":"快速"},{"arriveTime":"09:46","endStationName":"邢台","lishi":"04:32","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"05:14","stationTrainCode":"K599","trainClassName":"快速"},{"arriveTime":"12:03","endStationName":"邢台","lishi":"03:27","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"08:36","stationTrainCode":"Z149","trainClassName":"直特"},{"arriveTime":"22:15","endStationName":"邢台","lishi":"04:57","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"17:18","stationTrainCode":"K261","trainClassName":"快速"},{"arriveTime":"09:25","endStationName":"邢台","lishi":"04:53","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"04:32","stationTrainCode":"K219","trainClassName":"快速"},{"arriveTime":"12:25","endStationName":"邢台","lishi":"04:25","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"08:00","stationTrainCode":"K817","trainClassName":"快速"},{"arriveTime":"18:07","endStationName":"邢台","lishi":"03:51","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"14:16","stationTrainCode":"T167","trainClassName":"特快"},{"arriveTime":"20:04","endStationName":"邢台","lishi":"04:14","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"15:50","stationTrainCode":"T55","trainClassName":"特快"},{"arriveTime":"16:53","endStationName":"邢台","lishi":"05:17","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"11:36","stationTrainCode":"K117","trainClassName":"快速"},{"arriveTime":"10:04","endStationName":"邢台","lishi":"05:13","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"04:51","stationTrainCode":"K7725","trainClassName":"快速"},{"arriveTime":"11:11","endStationName":"邢台","lishi":"04:11","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"07:00","stationTrainCode":"K269","trainClassName":"快速"},{"arriveTime":"00:41","endStationName":"邢台","lishi":"03:25","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"21:16","stationTrainCode":"Z53","trainClassName":"直特"},{"arriveTime":"22:31","endStationName":"邢台","lishi":"04:19","pricerw":"¥155.5","pricewz":"¥54.5","priceyw":"¥100.5","priceyz":"¥54.5","startStationName":"北京西","startTime":"18:12","stationTrainCode":"K157","trainClassName":"快速"},{"arriveTime":"09:37","endStationName":"邢台东","lishi":"01:57","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"07:40","stationTrainCode":"G71","trainClassName":"高速"},{"arriveTime":"12:20","endStationName":"邢台东","lishi":"02:05","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"10:15","stationTrainCode":"G6741","trainClassName":"高速"},{"arriveTime":"14:10","endStationName":"邢台东","lishi":"01:57","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"12:13","stationTrainCode":"G67","trainClassName":"高速"},{"arriveTime":"17:58","endStationName":"邢台东","lishi":"01:58","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"16:00","stationTrainCode":"G665","trainClassName":"高速"},{"arriveTime":"11:18","endStationName":"邢台东","lishi":"01:51","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"09:27","stationTrainCode":"G511","trainClassName":"高速"},{"arriveTime":"13:44","endStationName":"邢台东","lishi":"01:51","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"11:53","stationTrainCode":"G429","trainClassName":"高速"},{"arriveTime":"13:57","endStationName":"邢台东","lishi":"01:50","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"12:07","stationTrainCode":"G659","trainClassName":"高速"},{"arriveTime":"08:49","endStationName":"邢台东","lishi":"01:51","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"06:58","stationTrainCode":"G651","trainClassName":"高速"},{"arriveTime":"08:56","endStationName":"邢台东","lishi":"01:51","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"07:05","stationTrainCode":"G401","trainClassName":"高速"},{"arriveTime":"16:28","endStationName":"邢台东","lishi":"01:50","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"14:38","stationTrainCode":"G503","trainClassName":"高速"},{"arriveTime":"16:15","endStationName":"邢台东","lishi":"01:50","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"14:25","stationTrainCode":"G6733","trainClassName":"高速"},{"arriveTime":"19:04","endStationName":"邢台东","lishi":"01:50","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"17:14","stationTrainCode":"G525","trainClassName":"高速"},{"arriveTime":"12:30","endStationName":"邢台东","lishi":"01:57","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"10:33","stationTrainCode":"G65","trainClassName":"高速"},{"arriveTime":"11:48","endStationName":"邢台东","lishi":"02:05","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"09:43","stationTrainCode":"G655","trainClassName":"高速"},{"arriveTime":"18:31","endStationName":"邢台东","lishi":"01:56","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"16:35","stationTrainCode":"G6743","trainClassName":"高速"},{"arriveTime":"21:06","endStationName":"邢台东","lishi":"01:50","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"19:16","stationTrainCode":"G567","trainClassName":"高速"},{"arriveTime":"09:32","endStationName":"邢台东","lishi":"02:06","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"07:26","stationTrainCode":"G529","trainClassName":"高速"},{"arriveTime":"17:36","endStationName":"邢台东","lishi":"01:51","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"15:45","stationTrainCode":"G663","trainClassName":"高速"},{"arriveTime":"16:33","endStationName":"邢台东","lishi":"01:50","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"14:43","stationTrainCode":"G673","trainClassName":"高速"},{"arriveTime":"11:23","endStationName":"邢台东","lishi":"01:51","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"09:32","stationTrainCode":"G309","trainClassName":"高速"},{"arriveTime":"22:15","endStationName":"邢台东","lishi":"01:55","priceed":"¥124.5","pricerw":"¥180.0","pricewz":"¥124.5","startStationName":"北京西","startTime":"20:20","stationTrainCode":"D909","trainClassName":"动车"},{"arriveTime":"09:55","endStationName":"邢台东","lishi":"01:58","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"07:57","stationTrainCode":"G653","trainClassName":"高速"},{"arriveTime":"19:16","endStationName":"邢台东","lishi":"01:57","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"17:19","stationTrainCode":"G1563","trainClassName":"高速"},{"arriveTime":"09:22","endStationName":"邢台东","lishi":"02:12","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"07:10","stationTrainCode":"G501","trainClassName":"高速"},{"arriveTime":"17:31","endStationName":"邢台东","lishi":"01:51","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"15:40","stationTrainCode":"G505","trainClassName":"高速"},{"arriveTime":"16:46","endStationName":"邢台东","lishi":"01:58","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"14:48","stationTrainCode":"G661","trainClassName":"高速"},{"arriveTime":"19:09","endStationName":"邢台东","lishi":"02:06","priceed":"¥185.5","pricesw":"¥584.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"17:03","stationTrainCode":"G561","trainClassName":"高速"},{"arriveTime":"14:24","endStationName":"邢台东","lishi":"01:50","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"12:34","stationTrainCode":"G491","trainClassName":"高速"},{"arriveTime":"22:42","endStationName":"邢台东","lishi":"01:56","priceed":"¥185.5","pricetd":"¥352.5","pricewz":"¥185.5","priceyd":"¥296.5","startStationName":"北京西","startTime":"20:46","stationTrainCode":"G6735","trainClassName":"高速"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * arriveTime : 14:33
         * endStationName : 邢台
         * lishi : 04:41
         * pricerw : ¥155.5
         * pricewz : ¥54.5
         * priceyw : ¥100.5
         * priceyz : ¥54.5
         * startStationName : 北京西
         * startTime : 09:52
         * stationTrainCode : K279
         * trainClassName : 快速
         * priceed : ¥185.5
         * pricesw : ¥584.5
         * priceyd : ¥296.5
         * pricetd : ¥352.5
         */

        private String arriveTime;
        private String endStationName;
        private String lishi;
        private String pricerw;
        private String pricewz;
        private String priceyw;
        private String priceyz;
        private String startStationName;
        private String startTime;
        private String stationTrainCode;
        private String trainClassName;
        private String priceed;
        private String pricesw;
        private String priceyd;
        private String pricetd;

        public String getArriveTime() {
            return arriveTime;
        }

        public void setArriveTime(String arriveTime) {
            this.arriveTime = arriveTime;
        }

        public String getEndStationName() {
            return endStationName;
        }

        public void setEndStationName(String endStationName) {
            this.endStationName = endStationName;
        }

        public String getLishi() {
            return lishi;
        }

        public void setLishi(String lishi) {
            this.lishi = lishi;
        }

        public String getPricerw() {
            return pricerw;
        }

        public void setPricerw(String pricerw) {
            this.pricerw = pricerw;
        }

        public String getPricewz() {
            return pricewz;
        }

        public void setPricewz(String pricewz) {
            this.pricewz = pricewz;
        }

        public String getPriceyw() {
            return priceyw;
        }

        public void setPriceyw(String priceyw) {
            this.priceyw = priceyw;
        }

        public String getPriceyz() {
            return priceyz;
        }

        public void setPriceyz(String priceyz) {
            this.priceyz = priceyz;
        }

        public String getStartStationName() {
            return startStationName;
        }

        public void setStartStationName(String startStationName) {
            this.startStationName = startStationName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStationTrainCode() {
            return stationTrainCode;
        }

        public void setStationTrainCode(String stationTrainCode) {
            this.stationTrainCode = stationTrainCode;
        }

        public String getTrainClassName() {
            return trainClassName;
        }

        public void setTrainClassName(String trainClassName) {
            this.trainClassName = trainClassName;
        }

        public String getPriceed() {
            return priceed;
        }

        public void setPriceed(String priceed) {
            this.priceed = priceed;
        }

        public String getPricesw() {
            return pricesw;
        }

        public void setPricesw(String pricesw) {
            this.pricesw = pricesw;
        }

        public String getPriceyd() {
            return priceyd;
        }

        public void setPriceyd(String priceyd) {
            this.priceyd = priceyd;
        }

        public String getPricetd() {
            return pricetd;
        }

        public void setPricetd(String pricetd) {
            this.pricetd = pricetd;
        }
    }
}
