package com.bc.lkh.ctrip.bean;

import java.util.List;

/**
 * Created by 刘凯华 on 2017/10/11.
 */

public class FilmBean {

    /**
     * msg : success
     * result : [{"cur":844.84,"days":13,"name":"缝纫机乐队","sum":29077.21},{"cur":890.13,"days":12,"name":"追龙","sum":43714.95},{"cur":2921.09,"days":12,"name":"羞羞的铁拳","sum":159558.11},{"cur":18.32,"days":11,"name":"昆塔：反转星球","sum":4465.94},{"cur":586.2,"days":12,"name":"英伦对决","sum":47032.08},{"cur":39.25,"days":27,"name":"猩球崛起3：终极之战","sum":73869.01},{"cur":14.83,"days":12,"name":"极致追击","sum":1635.32},{"cur":83.26,"days":27,"name":"看不见的客人","sum":16637.69},{"cur":344.28,"days":13,"name":"空天猎","sum":26743.34},{"cur":23.71,"days":77,"name":"战狼2","sum":567519.21},{"cur":5.35,"days":11,"name":"钢铁飞龙之再见奥特曼","sum":3917.75}]
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
         * cur : 844.84
         * days : 13
         * name : 缝纫机乐队
         * sum : 29077.21
         */

        private double cur;
        private int days;
        private String name;
        private double sum;

        public double getCur() {
            return cur;
        }

        public void setCur(double cur) {
            this.cur = cur;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }
    }
}
