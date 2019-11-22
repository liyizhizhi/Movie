package com.bw.movie.model.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/10/11<p>
 * <p>更改时间：2019/10/11<p>
 */
public class LodingBean {

    /**
     * result : [{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"name":"碟中谍6：全面瓦解","releaseTime":1600704000000,"wantSeeNum":23,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/jmyx/jmyx1.jpg","movieId":14,"name":"解码游戏","releaseTime":1599062400000,"wantSeeNum":26,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/drjzsdtw/drjzsdtw1.jpg","movieId":4,"name":"狄仁杰之四大天王","releaseTime":1598457600000,"wantSeeNum":20,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/aqgy/aqgy1.jpg","movieId":15,"name":"爱情公寓","releaseTime":1596988800000,"wantSeeNum":10,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/xhssf/xhssf1.jpg","movieId":3,"name":"西虹市首富","releaseTime":1595779200000,"wantSeeNum":14,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/mtyj/mtyj1.jpg","movieId":2,"name":"摩天营救","releaseTime":1595174400000,"wantSeeNum":10,"whetherReserve":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz1.jpg","movieId":5,"name":"邪不压正","releaseTime":1594569600000,"wantSeeNum":8,"whetherReserve":2}]
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
         * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg
         * movieId : 16
         * name : 碟中谍6：全面瓦解
         * releaseTime : 1600704000000
         * wantSeeNum : 23
         * whetherReserve : 2
         */

        private String imageUrl;
        private int movieId;
        private String name;
        private long releaseTime;
        private int wantSeeNum;
        private int whetherReserve;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getWantSeeNum() {
            return wantSeeNum;
        }

        public void setWantSeeNum(int wantSeeNum) {
            this.wantSeeNum = wantSeeNum;
        }

        public int getWhetherReserve() {
            return whetherReserve;
        }

        public void setWhetherReserve(int whetherReserve) {
            this.whetherReserve = whetherReserve;
        }
    }
}
