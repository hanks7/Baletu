package com.hopeshine.taoxue.ui.module;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.hopeshine.taoxue.MainActivity;
import com.hopeshine.taoxue.R;
import com.hopeshine.taoxue.base.BaseActivity;
import com.hopeshine.taoxue.ui.view.CustomVideoView;
import com.hopeshine.taoxue.utils.UtilIntent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class GuildActivity extends BaseActivity {

    @Bind(R.id.CustomVideoView)
    CustomVideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guild);
        ButterKnife.bind(this);initView();
    }

    /**
     * @author 侯建军
     * create at
     * @function 功能注释
     */
    protected void initView() {
        //设置播放加载路径
        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.opening_ad));
        //播放
        vv.start();
        //循环播放
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                UtilIntent.intentDIY(GuildActivity.this, MainActivity.class);
                finish();
            }
        });

    }

}
