package com.bw.movie.view.interfaces;

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
import com.bw.movie.model.bean.RecommendBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.model.bean.Timebean;
import com.bw.movie.model.bean.VersionBean;
import com.bw.movie.model.bean.XiangBean;
import com.bw.movie.model.bean.ZuoBean;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/11<p>
 * <p>更改时间：2019/11/11<p>
 */
public interface IMainView {
    //登录
    interface CallBackData extends IBaseView {
        void success(Loginbean loginbean);
    }

    //发送验证码
    interface CallBackEmail extends IBaseView {
        void success(EamalBean eamalBean);
    }

    //注册
    interface CallBackRegister extends IBaseView {
        void success(RegisterBean registerBean);
    }

    //banner
    interface CallBackBanner extends IBaseView {
        void success(BannerBean bannerBean);

        //热映
        void hotsuccess(HotMovieBean hotMovieBean);

        //即将上映
        void logingsuccess(LodingBean lodingBean);

        //热门
        void doorsuccess(DoorBean doorBean);
    }

    //    版本更新
    interface CallBackVersion extends IBaseView {
        void success(VersionBean versionBean);
    }

    //    二级联动左
    interface CallBackQv extends IBaseView {
        void success(QvBean qvBean);
    }

    //    二级联动右
    interface CallBackErji extends IBaseView {
        void success(ErJiBean erJiBean);
    }


    //推荐影院
    interface CallBackTuijian extends IBaseView {
        void success(RecommendBean recommendBean);
    }

    //附近影院
    interface CallBackNear extends IBaseView {
        void success(NearBean nearBean);
    }

    //电影详情
    interface CallBackXiang extends IBaseView {
        void success(XiangBean xiangBean);
    }

    //影评页面
    interface CallBackPing extends IBaseView {
        void success(PingBean pingBean);
    }


    //添加评论
    interface CallBackAttention extends IBaseView {
        void Attentionsuccess(AttentionBean attentionBean);
    }

    //添加评论
    interface CallBackFindCinemainfo extends IBaseView {
        void FindCinemainfosuccess(FindCinemainfoBean findCinemainfoBean);
    }

    //查询影院用户评论列表
    interface CallBackFindComment extends IBaseView {
        void FindFindCommentsuccess(FindCommentBean findCommentBean);
    }


    //查询影院用户评论列表
    interface CallBackTime extends IBaseView {
        void Timesuccess(Timebean timebean);
    }

    interface CallBackPaiqi extends IBaseView {
        void Paiqisuccess(PaiQiBean qiBean);
    }

    interface CallBackBuy extends IBaseView {
        void buysuccess(BuyBean buyBean);
    }

    interface CallBackSearch extends IBaseView {
        void searchsuccess(SearchBean searchBean);
    }
    interface CallBackZuo extends IBaseView {
        void zuosuccess(ZuoBean zuoBean);
    }
}
