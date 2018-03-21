package com.hopeshine.taoxue.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hopeshine.taoxue.utils.UtilLog;
import com.hopeshine.taoxue.utils.StatusbarUtils;
import com.hopeshine.taoxue.utils.UtilToast;
import com.hopeshine.taoxue.utils.permission.PermissionReq;

import butterknife.ButterKnife;

/**
 * Created by CC on 2016/5/25.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public BaseActivity mActivity;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionReq.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setOnTranslucent();
        super.onCreate(savedInstanceState);
        ButterKnife.setDebug(true);
        mActivity = this;
    }

    /**
     * 启用 透明状态栏
     */
    protected void setOnTranslucent() {
        StatusbarUtils.enableTranslucentStatusbar(this);
    }


    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    public void showToast(String text) {
        UtilToast.showText(text);
    }

    @Override
    public void onBackPressed() {
        dealOnBackPressed();
        super.onBackPressed();
    }

    protected void dealOnBackPressed() {
    }


    @Override
    protected void onResume() {
        UtilLog.i("activity", this.getClass().getName());
        super.onResume();
    }



}
