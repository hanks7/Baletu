package com.hopeshine.taoxue;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;

import com.hopeshine.taoxue.base.BaseActivity;
import com.hopeshine.taoxue.base.BaseFragment;
import com.hopeshine.taoxue.ui.module.home.HomeOneFragment;
import com.hopeshine.taoxue.ui.module.home.HomeThreeFragment;
import com.hopeshine.taoxue.ui.module.home.HomeTwoFragment;
import com.hopeshine.taoxue.ui.view.EasyRadioGroup;
import com.hopeshine.taoxue.ui.view.MyFragmentAdapter;
import com.hopeshine.taoxue.utils.permission.PermissionReq;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.home_bottom)
    EasyRadioGroup easyRadioGroup;
    @Bind(R.id.pager)
    ViewPager mViewPager;

    BaseFragment fragmentOne;
    BaseFragment fragmentTwo;
    BaseFragment fragmentThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        getPermission();//获取权限

        fragmentTwo = new HomeOneFragment();
        fragmentOne = new HomeTwoFragment();
        fragmentThree = new HomeThreeFragment();

        // 将要分页显示的View装入数组中
        List<Fragment> list = new ArrayList<>();
        list.add(fragmentThree);
        list.add(fragmentTwo);
        list.add(fragmentOne);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                easyRadioGroup.setPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });//设置页面切换时的监听器(可选，用了之后要重写它的回调方法处理页面切换时候的事务)
        mViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), list));

        easyRadioGroup.setOnTabSelectListener(new EasyRadioGroup.OnTabSelectListener() {
            @Override
            public void onSelect(View view, int position) {
                mViewPager.setCurrentItem(position);
            }
        });
    }



    /**
     * 获取权限
     */
    private void getPermission() {
        PermissionReq.RxPermissionsTool.
                with(this).
                addPermission(Manifest.permission.ACCESS_FINE_LOCATION).
                addPermission(Manifest.permission.ACCESS_COARSE_LOCATION).
                addPermission(Manifest.permission.READ_EXTERNAL_STORAGE).
                addPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE).
                addPermission(Manifest.permission.CAMERA).
                addPermission(Manifest.permission.CALL_PHONE).
                addPermission(Manifest.permission.READ_PHONE_STATE).
                initPermission();
    }

    private long mkeyTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mkeyTime) > 2000) {
                mkeyTime = System.currentTimeMillis();
                showToast("再按一次退出程序");
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
