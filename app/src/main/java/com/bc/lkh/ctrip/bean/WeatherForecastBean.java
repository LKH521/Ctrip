package com.bc.lkh.ctrip.bean;

import java.util.List;

/**
 * Created by 刘凯华 on 2017/8/2.
 */

public class WeatherForecastBean {

    /**
     * msg : success
     * result : [{"airCondition":"良","city":"北京","coldIndex":"低发期","date":"2017-08-02","distrct":"北京","dressingIndex":"薄短袖类","exerciseIndex":"不适宜","future":[{"date":"2017-08-02","dayTime":"中雨","night":"中雨","temperature":"29°C / 24°C","week":"今天","wind":"东风 小于3级"},{"date":"2017-08-03","dayTime":"阴","night":"晴","temperature":"33°C / 24°C","week":"星期四","wind":"南风 小于3级"},{"date":"2017-08-04","dayTime":"多云","night":"多云","temperature":"33°C / 25°C","week":"星期五","wind":"南风 小于3级"},{"date":"2017-08-05","dayTime":"阴","night":"雷阵雨","temperature":"33°C / 24°C","week":"星期六","wind":"南风 小于3级"},{"date":"2017-08-06","dayTime":"多云","night":"多云","temperature":"32°C / 24°C","week":"星期日","wind":"南风 小于3级"},{"date":"2017-08-07","dayTime":"多云","night":"多云","temperature":"32°C / 24°C","week":"星期一","wind":"南风 小于3级"},{"date":"2017-08-08","dayTime":"阴","night":"雷阵雨","temperature":"32°C / 23°C","week":"星期二","wind":"南风 小于3级"},{"date":"2017-08-09","dayTime":"零散雷雨","night":"局部多云","temperature":"29°C / 22°C","week":"星期三","wind":"东北风 2级"},{"date":"2017-08-10","dayTime":"局部多云","night":"局部多云","temperature":"30°C / 22°C","week":"星期四","wind":"东北偏北风 2级"},{"date":"2017-08-11","dayTime":"零散雷雨","night":"零散雷雨","temperature":"30°C / 22°C","week":"星期五","wind":"西北偏北风 2级"}],"humidity":"湿度：90%","pollutionIndex":"69","province":"北京","sunrise":"05:14","sunset":"19:27","temperature":"26℃","time":"10:30","updateTime":"20170802104509","washIndex":"比较适宜","weather":"中雨","week":"周三","wind":"东北风2级"}]
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
         * airCondition : 良
         * city : 北京
         * coldIndex : 低发期
         * date : 2017-08-02
         * distrct : 北京
         * dressingIndex : 薄短袖类
         * exerciseIndex : 不适宜
         * future : [{"date":"2017-08-02","dayTime":"中雨","night":"中雨","temperature":"29°C / 24°C","week":"今天","wind":"东风 小于3级"},{"date":"2017-08-03","dayTime":"阴","night":"晴","temperature":"33°C / 24°C","week":"星期四","wind":"南风 小于3级"},{"date":"2017-08-04","dayTime":"多云","night":"多云","temperature":"33°C / 25°C","week":"星期五","wind":"南风 小于3级"},{"date":"2017-08-05","dayTime":"阴","night":"雷阵雨","temperature":"33°C / 24°C","week":"星期六","wind":"南风 小于3级"},{"date":"2017-08-06","dayTime":"多云","night":"多云","temperature":"32°C / 24°C","week":"星期日","wind":"南风 小于3级"},{"date":"2017-08-07","dayTime":"多云","night":"多云","temperature":"32°C / 24°C","week":"星期一","wind":"南风 小于3级"},{"date":"2017-08-08","dayTime":"阴","night":"雷阵雨","temperature":"32°C / 23°C","week":"星期二","wind":"南风 小于3级"},{"date":"2017-08-09","dayTime":"零散雷雨","night":"局部多云","temperature":"29°C / 22°C","week":"星期三","wind":"东北风 2级"},{"date":"2017-08-10","dayTime":"局部多云","night":"局部多云","temperature":"30°C / 22°C","week":"星期四","wind":"东北偏北风 2级"},{"date":"2017-08-11","dayTime":"零散雷雨","night":"零散雷雨","temperature":"30°C / 22°C","week":"星期五","wind":"西北偏北风 2级"}]
         * humidity : 湿度：90%
         * pollutionIndex : 69
         * province : 北京
         * sunrise : 05:14
         * sunset : 19:27
         * temperature : 26℃
         * time : 10:30
         * updateTime : 20170802104509
         * washIndex : 比较适宜
         * weather : 中雨
         * week : 周三
         * wind : 东北风2级
         */

        private String airCondition;
        private String city;
        private String coldIndex;
        private String date;
        private String distrct;
        private String dressingIndex;
        private String exerciseIndex;
        private String humidity;
        private String pollutionIndex;
        private String province;
        private String sunrise;
        private String sunset;
        private String temperature;
        private String time;
        private String updateTime;
        private String washIndex;
        private String weather;
        private String week;
        private String wind;
        private List<FutureBean> future;

        public String getAirCondition() {
            return airCondition;
        }

        public void setAirCondition(String airCondition) {
            this.airCondition = airCondition;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getColdIndex() {
            return coldIndex;
        }

        public void setColdIndex(String coldIndex) {
            this.coldIndex = coldIndex;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDistrct() {
            return distrct;
        }

        public void setDistrct(String distrct) {
            this.distrct = distrct;
        }

        public String getDressingIndex() {
            return dressingIndex;
        }

        public void setDressingIndex(String dressingIndex) {
            this.dressingIndex = dressingIndex;
        }

        public String getExerciseIndex() {
            return exerciseIndex;
        }

        public void setExerciseIndex(String exerciseIndex) {
            this.exerciseIndex = exerciseIndex;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPollutionIndex() {
            return pollutionIndex;
        }

        public void setPollutionIndex(String pollutionIndex) {
            this.pollutionIndex = pollutionIndex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWashIndex() {
            return washIndex;
        }

        public void setWashIndex(String washIndex) {
            this.washIndex = washIndex;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class FutureBean {
            /**
             * date : 2017-08-02
             * dayTime : 中雨
             * night : 中雨
             * temperature : 29°C / 24°C
             * week : 今天
             * wind : 东风 小于3级
             */

            private String date;
            private String dayTime;
            private String night;
            private String temperature;
            private String week;
            private String wind;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDayTime() {
                return dayTime;
            }

            public void setDayTime(String dayTime) {
                this.dayTime = dayTime;
            }

            public String getNight() {
                return night;
            }

            public void setNight(String night) {
                this.night = night;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }
        }
    }
}
