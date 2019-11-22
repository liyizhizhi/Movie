package com.bw.movie.model.http;

import com.bw.movie.model.bean.AttentionBean;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.BuyBean;
import com.bw.movie.model.bean.DoorBean;
import com.bw.movie.model.bean.EamalBean;
import com.bw.movie.model.bean.ErJiBean;
import com.bw.movie.model.bean.FindCinemainfoBean;
import com.bw.movie.model.bean.FindCommentBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LodingBean;
import com.bw.movie.model.bean.Loginbean;
import com.bw.movie.model.bean.NearBean;
import com.bw.movie.model.bean.PaiQiBean;
import com.bw.movie.model.bean.PingBean;
import com.bw.movie.model.bean.QvBean;
import com.bw.movie.model.bean.RangeBean;
import com.bw.movie.model.bean.RecommendBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.model.bean.SchduBean;
import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.model.bean.Timebean;
import com.bw.movie.model.bean.VersionBean;
import com.bw.movie.model.bean.XiangBean;
import com.bw.movie.model.bean.ZuoBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/11<p>
 * <p>更改时间：2019/11/11<p>
 */
public interface ApiHttp {
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<Loginbean> loginbean(
            @Field("email") String email,
            @Field("pwd") String pass);

    @POST("user/v2/register")
    @FormUrlEncoded
    Observable<RegisterBean> register(@FieldMap Map<String, Object> map);

    @POST("user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<EamalBean> email(@Field("email") String email);

    @GET("tool/v2/banner")
    Observable<BannerBean> bannerbean();

    @GET("movie/v2/findReleaseMovieList?page=1&count=7")
    Observable<HotMovieBean> hotmoviebean();

    @GET("movie/v2/findComingSoonMovieList?page=1&count=4")
    Observable<LodingBean> lodingbean();

    @GET("movie/v2/findHotMovieList?page=1&count=5")
    Observable<DoorBean> doorbean();

    @GET("tool/v1/findNewVersion")
    Observable<VersionBean> version(@HeaderMap HashMap<String, Object> map, @Header("ak") String ak);

    @GET("tool/v2/findRegionList")
    Observable<QvBean> qvbean();

    @GET("cinema/v2/findCinemaByRegion")
    Observable<ErJiBean> erjibean(@Query("regionId") int regionId);

    @GET("cinema/v1/findRecommendCinemas?page=1&count=10")
    Observable<RecommendBean> recommendbean();

    @GET("cinema/v1/findNearbyCinemas?page=1&count=10")
    Observable<NearBean> nearbean();


    @GET("movie/v2/findMoviesDetail")
    Observable<XiangBean> xiangbean(@Query("movieId") int movieId);

    @GET("movie/v2/findAllMovieComment")
    Observable<PingBean> pingbean(
            @Query("movieId") int movieId,
            @Query("page") int page,
            @Query("count") int count
    );

    @FormUrlEncoded
    @POST("movie/v1/verify/movieComment")
    Observable<AttentionBean> attentbean(
            @Header("userId") int userId,
            @Header("sessionId") String sessionId,
            @Field("movieId") int movieId,
            @Field("commentContent") String commentContent,
            @Field("score") double score
    );


    //查询一周排期的时间
    @GET("tool/v2/findDateList")
    Observable<SchduBean> schdu();

    //根据区域进行查询
    @GET("movie/v2/findCinemasInfoByRegion")
    Observable<RangeBean> range(@Query("movieId") int movieId,
                                @Query("regionId") int regionId,
                                @Query("page") int page,
                                @Query("count") int count);

    @GET("cinema/v1/findCinemaInfo")
    Observable<FindCinemainfoBean> findcinemainfobean(@Query("cinemaId") int cinemaId);

    @GET("cinema/v1/findAllCinemaComment")
    Observable<FindCommentBean> findcommentbean(
            @Query("cinemaId") int cinemaId,
            @Query("page") int page,
            @Query("count") int count
    );

    @GET("tool/v2/findDateList")
    Observable<Timebean> timebean();

    @GET("cinema/v2/findCinemaScheduleList")
    Observable<PaiQiBean> paiqibean(
            @Query("cinemaId") int cinemaId,
            @Query("page") int page,
            @Query("count") int count
    );

    @GET("movie/v2/findMovieSchedule")
    Observable<BuyBean> buybean(
            @Query("cinemaId") int cinemaId,
            @Query("movieId") int movieId
    );

    @GET("movie/v2/findMovieByKeyword")
    Observable<SearchBean> searchbean(
            @Query("keyword") String keyword,
            @Query("page")      int page,
            @Query("count")     int count
    );

    @GET("movie/v2/findSeatInfo")
    Observable<ZuoBean>zuobean(
            @Query("hallId") int  hallId

    );


}
