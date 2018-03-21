package com.hopeshine.taoxue.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.hopeshine.taoxue.ui.model.UserModel;
import com.hopeshine.taoxue.utils.CacheKey;
import com.hopeshine.taoxue.utils.SPUtil;
import com.hopeshine.taoxue.utils.UtilGson;
import com.hopeshine.taoxue.utils.UtilSystem;


public class BaseApplication extends MultiDexApplication{
    private static BaseApplication app;
    private UserModel userModel;
    private SharedPreferences sp;
    private boolean islogin;


    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        app = this;
//        HttpAdapter.init();
        JudgeisLogin();

    }


    public static BaseApplication get() {
        return app;
    }


    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
        islogin=true;
        SPUtil.put("UserModel", UtilGson.toJson(userModel));

    }

    public UserModel getUserModel() {
        if (!isLogin()) return new UserModel();
        userModel = (UserModel) UtilGson.fromJson((String) SPUtil.get("UserModel", ""), UserModel.class);
        return userModel;

    }

    public boolean isLogin() {
        return islogin;
    }

    public boolean JudgeisLogin() {
        getUserModel();
        islogin=!(SPUtil.get("UserModel", "")).equals("");
        return islogin;
    }

    public void quitLogin() {
        SPUtil.clear(getApplicationContext());
        getUserModel();
        JudgeisLogin();
    }

    public boolean isFirstEnter() {
        sp = getApplicationContext().getSharedPreferences("info", Context.MODE_PRIVATE);
        return sp.getInt(CacheKey.FIRST_ENTER, 0)!=UtilSystem.getVersionCode();
    }

    public void setNotFirstEnter() {
        sp = getApplicationContext().getSharedPreferences("info", Context.MODE_PRIVATE);
        sp.edit().putInt(CacheKey.FIRST_ENTER, UtilSystem.getVersionCode()).commit();
    }



}
