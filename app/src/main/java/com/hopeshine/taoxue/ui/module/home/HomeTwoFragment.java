package com.hopeshine.taoxue.ui.module.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.hopeshine.taoxue.R;
import com.hopeshine.taoxue.base.BaseFragment;
import com.hopeshine.taoxue.ui.view.TranslucentActionBar;
import com.hopeshine.taoxue.ui.view.TranslucentScrollView;
import com.hopeshine.taoxue.ui.view.UPMarqueeView;
import com.hopeshine.taoxue.utils.UtilToast;
import com.hopeshine.taoxue.utils.banner.BannerHelp;
import com.hopeshine.taoxue.utils.banner.BdqdBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeTwoFragment extends BaseFragment {

    @Bind(R.id.fa_home_convenientBanner)
    ConvenientBanner convenientBanner;

    @Bind(R.id.fa_home_fg_shunfeng_ScrollView)
    TranslucentScrollView mScrollView;

    @Bind(R.id.actionbar)
    TranslucentActionBar mActionbar;

    @Bind(R.id.upview1)
    UPMarqueeView mUPMarqueeView;

    private BannerHelp bannerHelp;//轮播图

    @Override
    protected int getLayout() {
        return R.layout.fragment_home_one;
    }

    @Override
    protected void initView() {
        intTopBar();
        initBanner();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onVisible() {
        if (null == bannerHelp) return;
        bannerHelp.start();
        if (null == mUPMarqueeView) return;
        mUPMarqueeView.startFlipping();
    }

    @Override
    protected void onInvisible() {
        if (null == bannerHelp) return;
        bannerHelp.stop();
        if (null == mUPMarqueeView) return;
        mUPMarqueeView.stopFlipping();
    }

    /**
     * 初始化banner
     */
    private void initBanner() {
        List<BdqdBean> textUrlList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BdqdBean bdqdBean = new BdqdBean();
            bdqdBean.setDiscription(i + "房间爱思考的法律就爱上课的房间爱思考的法律");
            bdqdBean.setResource_picture("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2188762198,1587680554&fm=27&gp=0.jpg");
            textUrlList.add(bdqdBean);
        }
        bannerHelp = new BannerHelp(convenientBanner);
        bannerHelp.addData(textUrlList);
        mUPMarqueeView.addData(textUrlList, new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                UtilToast.showText("test" + position);
            }
        });//广告垂直滚动
        mUPMarqueeView.startFlipping();

    }

    /**
     * 初始化头部
     */
    private void intTopBar() {
        mScrollView.setVerticalScrollBarEnabled(false);
        mActionbar.setData(new TranslucentActionBar.ActionBarClickListener() {
            @Override
            public void onLeftClick() {
                UtilToast.showText("onLeftClick");
            }

            @Override
            public void onSearchClick() {
                UtilToast.showText("onSearchClick");
            }
        });

        mScrollView.setTranslucentChangedListener(new TranslucentScrollView.TranslucentChangedListener() {
            @Override
            public void onTranslucentChanged(int transAlpha) {
                mActionbar.setNeedTranslucent(transAlpha);
            }

        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}