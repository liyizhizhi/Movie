package com.bw.movie.model.bean;

import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/10/23 18:53
 */
public class RangeBean {

    /**
     * result : [{"address":"远大路1号B座5层魔影国际影城","cinemaId":4,"logo":"http://172.17.8.100/images/movie/logo/mygj.jpg","name":"魔影国际影城","price":0}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * address : 远大路1号B座5层魔影国际影城
         * cinemaId : 4
         * logo : http://172.17.8.100/images/movie/logo/mygj.jpg
         * name : 魔影国际影城
         * price : 0
         */

        public String address;
        public int cinemaId;
        public String logo;
        public String name;
        public int price;
    }
}
