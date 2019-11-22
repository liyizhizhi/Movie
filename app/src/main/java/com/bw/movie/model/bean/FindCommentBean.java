package com.bw.movie.model.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class FindCommentBean {

    /**
     * result : [{"commentContent":"这接口是不是有问题啊！！！","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":125,"commentTime":1574211703000,"commentUserId":13821,"commentUserName":"老丁万岁","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"真好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":123,"commentTime":1574162477000,"commentUserId":13766,"commentUserName":"nideyifa","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-27/20190827104532.png","commentId":106,"commentTime":1574135540000,"commentUserId":13541,"commentUserName":"大仙","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":" 好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-15/20190815170633.png","commentId":103,"commentTime":1574135338000,"commentUserId":13485,"commentUserName":"秋冬","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-24/20191024160418.unknown","commentId":102,"commentTime":1574135145000,"commentUserId":13542,"commentUserName":"杨海鹏","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115194408.jpg","commentId":100,"commentTime":1573797666000,"commentUserId":13818,"commentUserName":"你的名字","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":94,"commentTime":1573480318000,"commentUserId":13771,"commentUserName":"tzy","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"咋的了","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-31/20191031165328.png","commentId":93,"commentTime":1572512635000,"commentUserId":13678,"commentUserName":"abnetming","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"耐思","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115201537.jpg","commentId":90,"commentTime":1571986952000,"commentUserId":13715,"commentUserName":"张乐乐","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"就很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-24/20190824094957.jpg","commentId":85,"commentTime":1571826049000,"commentUserId":13501,"commentUserName":"哥哥","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0}]
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
         * commentContent : 这接口是不是有问题啊！！！
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 125
         * commentTime : 1574211703000
         * commentUserId : 13821
         * commentUserName : 老丁万岁
         * greatHeadPic : []
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private List<?> greatHeadPic;

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

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
