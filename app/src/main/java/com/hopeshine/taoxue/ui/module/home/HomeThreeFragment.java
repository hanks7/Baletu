package com.hopeshine.taoxue.ui.module.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hopeshine.taoxue.R;
import com.hopeshine.taoxue.base.BaseFragment;
import com.hopeshine.taoxue.ui.view.HeadZoomScrollView;
import com.hopeshine.taoxue.ui.view.TranslucentActionBar;
import com.hopeshine.taoxue.utils.UtilToast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeThreeFragment extends BaseFragment {
    @Bind(R.id.iv)
    ImageView iv;
    @Bind(R.id.fa_home_fg_shunfeng_ScrollView)
    HeadZoomScrollView mScrollView;
    @Bind(R.id.actionbar)
    TranslucentActionBar mActionbar;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home_three;
    }

    @Override
    protected void initView() {
        intTopBar();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onVisible() {
    }

    @Override
    protected void onInvisible() {

    }


    /**
     * 初始化头部
     */
    private void intTopBar() {
        mScrollView.setVerticalScrollBarEnabled(false);
        mScrollView.setZoomView(iv);
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

        mScrollView.setTranslucentChangedListener(new HeadZoomScrollView.TranslucentChangedListener() {
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