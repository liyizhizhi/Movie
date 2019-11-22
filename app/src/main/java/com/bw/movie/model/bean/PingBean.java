package com.bw.movie.model.bean;

import java.util.List;
public class PingBean {

    /**
     * result : [{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1758,"commentTime":1571627802000,"commentUserId":13548,"commentUserName":"1705","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1751,"commentTime":1571626750000,"commentUserId":13665,"commentUserName":"123456789","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"c","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1736,"commentTime":1571626719000,"commentUserId":13544,"commentUserName":"woailuo","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"啦啦啦","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1716,"commentTime":1571386111000,"commentUserId":13726,"commentUserName":"阿宽","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.3},{"commentContent":"我曹云铮到此一游","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1711,"commentTime":1571364367000,"commentUserId":13680,"commentUserName":"一飞","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":2},{"commentContent":"的算法的","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1705,"commentTime":1571301641000,"commentUserId":13696,"commentUserName":"我的神明","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"大的","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1684,"commentTime":1571229525000,"commentUserId":13585,"commentUserName":"席贵","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":3},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1681,"commentTime":1571146732000,"commentUserId":13715,"commentUserName":"张乐乐","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"非常好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-21/20191021105754.jpg","commentId":1666,"commentTime":1570603341000,"commentUserId":13597,"commentUserName":"狂饮风中血","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"�̼�","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":203,"commentTime":1569377416000,"commentUserId":13458,"commentUserName":"23","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5}]
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
         * commentContent : 好看
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 1758
         * commentTime : 1571627802000
         * commentUserId : 13548
         * commentUserName : 1705
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 4.5
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
