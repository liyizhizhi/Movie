package com.bw.movie.model.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class QvBean {


    /**
     * result : [{"regionId":1,"regionName":"海淀区"},{"regionId":2,"regionName":"朝阳区"},{"regionId":3,"regionName":"东城区"},{"regionId":4,"regionName":"西城区"},{"regionId":5,"regionName":"石景山区"},{"regionId":6,"regionName":"丰台区"},{"regionId":7,"regionName":"昌平区"},{"regionId":8,"regionName":"房山区"},{"regionId":9,"regionName":"大兴区"},{"regionId":10,"regionName":"通州区"},{"regionId":11,"regionName":"顺义区"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * regionId : 1
         * regionName : 海淀区
         */

        private int regionId;
        private String regionName;

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }
    }
}
