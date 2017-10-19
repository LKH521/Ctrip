package com.bc.lkh.ctrip.bean;

import java.util.List;

/**
 * Created by 刘凯华 on 2017/8/4.
 */

public class AirConditionBean {

    /**
     * msg : success
     * result : [{"aqi":63,"city":"北京","district":"北京","fetureData":[{"aqi":73,"date":"2017-08-03","quality":"良"},{"aqi":62,"date":"2017-08-04","quality":"良"},{"aqi":66,"date":"2017-08-05","quality":"良"},{"aqi":82,"date":"2017-08-06","quality":"良"},{"aqi":93,"date":"2017-08-07","quality":"良"},{"aqi":106,"date":"2017-08-08","quality":"轻度污染"}],"hourData":[{"aqi":63,"dateTime":"2017-08-02 12:00:00"},{"aqi":72,"dateTime":"2017-08-02 11:00:00"},{"aqi":72,"dateTime":"2017-08-02 10:00:00"},{"aqi":69,"dateTime":"2017-08-02 09:00:00"},{"aqi":63,"dateTime":"2017-08-02 08:00:00"},{"aqi":49,"dateTime":"2017-08-02 07:00:00"},{"aqi":43,"dateTime":"2017-08-02 06:00:00"},{"aqi":45,"dateTime":"2017-08-02 05:00:00"},{"aqi":48,"dateTime":"2017-08-02 04:00:00"},{"aqi":45,"dateTime":"2017-08-02 03:00:00"},{"aqi":44,"dateTime":"2017-08-02 02:00:00"},{"aqi":49,"dateTime":"2017-08-02 01:00:00"},{"aqi":54,"dateTime":"2017-08-02 00:00:00"},{"aqi":58,"dateTime":"2017-08-01 23:00:00"},{"aqi":60,"dateTime":"2017-08-01 22:00:00"},{"aqi":62,"dateTime":"2017-08-01 21:00:00"},{"aqi":62,"dateTime":"2017-08-01 20:00:00"},{"aqi":59,"dateTime":"2017-08-01 19:00:00"},{"aqi":57,"dateTime":"2017-08-01 18:00:00"},{"aqi":58,"dateTime":"2017-08-01 17:00:00"},{"aqi":60,"dateTime":"2017-08-01 16:00:00"},{"aqi":64,"dateTime":"2017-08-01 15:00:00"},{"aqi":74,"dateTime":"2017-08-01 14:00:00"},{"aqi":90,"dateTime":"2017-08-01 13:00:00"}],"no2":27,"pm10":56,"pm25":45,"province":"北京","quality":"良","so2":4,"updateTime":"2017-08-02 13:00:00"}]
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
         * aqi : 63
         * city : 北京
         * district : 北京
         * fetureData : [{"aqi":73,"date":"2017-08-03","quality":"良"},{"aqi":62,"date":"2017-08-04","quality":"良"},{"aqi":66,"date":"2017-08-05","quality":"良"},{"aqi":82,"date":"2017-08-06","quality":"良"},{"aqi":93,"date":"2017-08-07","quality":"良"},{"aqi":106,"date":"2017-08-08","quality":"轻度污染"}]
         * hourData : [{"aqi":63,"dateTime":"2017-08-02 12:00:00"},{"aqi":72,"dateTime":"2017-08-02 11:00:00"},{"aqi":72,"dateTime":"2017-08-02 10:00:00"},{"aqi":69,"dateTime":"2017-08-02 09:00:00"},{"aqi":63,"dateTime":"2017-08-02 08:00:00"},{"aqi":49,"dateTime":"2017-08-02 07:00:00"},{"aqi":43,"dateTime":"2017-08-02 06:00:00"},{"aqi":45,"dateTime":"2017-08-02 05:00:00"},{"aqi":48,"dateTime":"2017-08-02 04:00:00"},{"aqi":45,"dateTime":"2017-08-02 03:00:00"},{"aqi":44,"dateTime":"2017-08-02 02:00:00"},{"aqi":49,"dateTime":"2017-08-02 01:00:00"},{"aqi":54,"dateTime":"2017-08-02 00:00:00"},{"aqi":58,"dateTime":"2017-08-01 23:00:00"},{"aqi":60,"dateTime":"2017-08-01 22:00:00"},{"aqi":62,"dateTime":"2017-08-01 21:00:00"},{"aqi":62,"dateTime":"2017-08-01 20:00:00"},{"aqi":59,"dateTime":"2017-08-01 19:00:00"},{"aqi":57,"dateTime":"2017-08-01 18:00:00"},{"aqi":58,"dateTime":"2017-08-01 17:00:00"},{"aqi":60,"dateTime":"2017-08-01 16:00:00"},{"aqi":64,"dateTime":"2017-08-01 15:00:00"},{"aqi":74,"dateTime":"2017-08-01 14:00:00"},{"aqi":90,"dateTime":"2017-08-01 13:00:00"}]
         * no2 : 27
         * pm10 : 56
         * pm25 : 45
         * province : 北京
         * quality : 良
         * so2 : 4
         * updateTime : 2017-08-02 13:00:00
         */

        private int aqi;
        private String city;
        private String district;
        private int no2;
        private int pm10;
        private int pm25;
        private String province;
        private String quality;
        private int so2;
        private String updateTime;
        private List<FetureDataBean> fetureData;
        private List<HourDataBean> hourData;

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public int getNo2() {
            return no2;
        }

        public void setNo2(int no2) {
            this.no2 = no2;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public int getSo2() {
            return so2;
        }

        public void setSo2(int so2) {
            this.so2 = so2;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public List<FetureDataBean> getFetureData() {
            return fetureData;
        }

        public void setFetureData(List<FetureDataBean> fetureData) {
            this.fetureData = fetureData;
        }

        public List<HourDataBean> getHourData() {
            return hourData;
        }

        public void setHourData(List<HourDataBean> hourData) {
            this.hourData = hourData;
        }

        public static class FetureDataBean {
            /**
             * aqi : 73
             * date : 2017-08-03
             * quality : 良
             */

            private int aqi;
            private String date;
            private String quality;

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }
        }

        public static class HourDataBean {
            /**
             * aqi : 63
             * dateTime : 2017-08-02 12:00:00
             */

            private int aqi;
            private String dateTime;

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }
        }
    }
}
