package com.bw.movie.presenter;

import com.bw.movie.model.bean.BuyBean;
import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.model.models.BuyModel;
import com.bw.movie.model.models.SearchModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class SearchPresenter<V extends IMainView.CallBackSearch> extends BasePresenter<V> {
    public void SearchPresenter(String keyword, int page, int count) {
        new SearchModel().SearchModel(keyword, page, count, new IMainView.CallBackSearch() {
            @Override
            public void searchsuccess(SearchBean searchBean) {
                getView().searchsuccess(searchBean);
            }
        });
    }
}
