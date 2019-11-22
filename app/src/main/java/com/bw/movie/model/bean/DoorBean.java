package com.bw.movie.model.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/10/12<p>
 * <p>更改时间：2019/10/12<p>
 */
public class DoorBean {

    /**
     * result : [{"director":"庄文强","horizontalImage":"http://172.17.8.100/images/movie/stills/ws/ws1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/ws/ws1.jpg","movieId":20,"name":"无双","score":8.6,"starring":"周润发,郭富城,张静初,冯文娟,廖启智"},{"director":"贾樟柯","horizontalImage":"http://172.17.8.100/images/movie/stills/jhen/jhen1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/jhen/jhen1.jpg","movieId":19,"name":"江湖儿女","score":9.7,"starring":"赵涛,廖凡,徐峥,梁嘉艳"},{"director":"克里斯托弗·麦奎里","horizontalImage":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"name":"碟中谍6：全面瓦解","score":8.9,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},{"director":"林德禄","horizontalImage":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","movieId":17,"name":"反贪风暴3","score":9.1,"starring":"古天乐,张智霖,郑嘉颖,邓丽欣,谢天华"},{"director":"钱嘉乐","horizontalImage":"http://172.17.8.100/images/movie/stills/hjxd/hjxd1_h.jpg","imageUrl":"http://172.17.8.100/images/movie/stills/hjxd/hjxd1.jpg","movieId":18,"name":"黄金兄弟","score":9.3,"starring":"郑伊健,陈小春,谢天华,林晓峰"}]
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
         * director : 庄文强
         * horizontalImage : http://172.17.8.100/images/movie/stills/ws/ws1_h.jpg
         * imageUrl : http://172.17.8.100/images/movie/stills/ws/ws1.jpg
         * movieId : 20
         * name : 无双
         * score : 8.6
         * starring : 周润发,郭富城,张静初,冯文娟,廖启智
         */

        private String director;
        private String horizontalImage;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getHorizontalImage() {
            return horizontalImage;
        }

        public void setHorizontalImage(String horizontalImage) {
            this.horizontalImage = horizontalImage;
        }

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

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
