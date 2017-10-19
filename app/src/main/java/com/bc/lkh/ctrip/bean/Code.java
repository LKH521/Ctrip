package com.bc.lkh.ctrip.bean;

import java.util.List;

/**
 * Created by 刘凯华 on 2017/9/5.
 */

public class Code {

    /**
     * msg : success
     * result : [{"arriveTime":"----","endStationName":"邯郸","startStationName":"银川","startTime":"08:35","stationName":"银川","stationNo":"01","stationTrainCode":"K218","stopoverTime":"----","trainClassName":"快速"},{"arriveTime":"09:11","startTime":"09:14","stationName":"石嘴山","stationNo":"02","stopoverTime":"3分钟"},{"arriveTime":"09:52","startTime":"10:02","stationName":"惠农","stationNo":"03","stopoverTime":"10分钟"},{"arriveTime":"12:14","startTime":"12:21","stationName":"临河","stationNo":"04","stopoverTime":"7分钟"},{"arriveTime":"14:39","startTime":"14:53","stationName":"包头","stationNo":"05","stopoverTime":"14分钟"},{"arriveTime":"16:38","startTime":"17:09","stationName":"呼和浩特东","stationNo":"06","stopoverTime":"31分钟"},{"arriveTime":"18:46","startTime":"18:54","stationName":"集宁南","stationNo":"07","stopoverTime":"8分钟"},{"arriveTime":"20:38","startTime":"20:53","stationName":"大同","stationNo":"08","stopoverTime":"15分钟"},{"arriveTime":"21:38","startTime":"21:41","stationName":"阳高","stationNo":"09","stopoverTime":"3分钟"},{"arriveTime":"22:04","startTime":"22:07","stationName":"天镇","stationNo":"10","stopoverTime":"3分钟"},{"arriveTime":"22:53","startTime":"22:56","stationName":"柴沟堡","stationNo":"11","stopoverTime":"3分钟"},{"arriveTime":"23:33","startTime":"23:59","stationName":"张家口南","stationNo":"12","stopoverTime":"26分钟"},{"arriveTime":"00:21","startTime":"00:25","stationName":"宣化","stationNo":"13","stopoverTime":"4分钟"},{"arriveTime":"01:09","startTime":"01:14","stationName":"沙城","stationNo":"14","stopoverTime":"5分钟"},{"arriveTime":"04:05","startTime":"04:32","stationName":"北京西","stationNo":"15","stopoverTime":"27分钟"},{"arriveTime":"05:27","startTime":"05:29","stationName":"高碑店","stationNo":"16","stopoverTime":"2分钟"},{"arriveTime":"06:07","startTime":"06:11","stationName":"保定","stationNo":"17","stopoverTime":"4分钟"},{"arriveTime":"06:51","startTime":"06:54","stationName":"定州","stationNo":"18","stopoverTime":"3分钟"},{"arriveTime":"07:46","startTime":"08:13","stationName":"石家庄","stationNo":"19","stopoverTime":"27分钟"},{"arriveTime":"08:42","startTime":"08:45","stationName":"高邑","stationNo":"20","stopoverTime":"3分钟"},{"arriveTime":"09:25","startTime":"09:36","stationName":"邢台","stationNo":"21","stopoverTime":"11分钟"},{"arriveTime":"10:42","startTime":"10:42","stationName":"邯郸","stationNo":"22","stopoverTime":"----"}]
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
         * arriveTime : ----
         * endStationName : 邯郸
         * startStationName : 银川
         * startTime : 08:35
         * stationName : 银川
         * stationNo : 01
         * stationTrainCode : K218
         * stopoverTime : ----
         * trainClassName : 快速
         */

        private String arriveTime;
        private String endStationName;
        private String startStationName;
        private String startTime;
        private String stationName;
        private String stationNo;
        private String stationTrainCode;
        private String stopoverTime;
        private String trainClassName;

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

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getStationNo() {
            return stationNo;
        }

        public void setStationNo(String stationNo) {
            this.stationNo = stationNo;
        }

        public String getStationTrainCode() {
            return stationTrainCode;
        }

        public void setStationTrainCode(String stationTrainCode) {
            this.stationTrainCode = stationTrainCode;
        }

        public String getStopoverTime() {
            return stopoverTime;
        }

        public void setStopoverTime(String stopoverTime) {
            this.stopoverTime = stopoverTime;
        }

        public String getTrainClassName() {
            return trainClassName;
        }

        public void setTrainClassName(String trainClassName) {
            this.trainClassName = trainClassName;
        }
    }
}
