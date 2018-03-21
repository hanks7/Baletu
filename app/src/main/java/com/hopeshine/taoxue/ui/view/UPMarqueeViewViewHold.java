package com.hopeshine.taoxue.ui.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.hopeshine.taoxue.R;
import com.hopeshine.taoxue.utils.banner.BdqdBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by User on 2017/11/7.
 */

public class UPMarqueeViewViewHold {
    @Bind(R.id.item_item_upmarqueeview_tv)
    TextView iTvContent;

    public UPMarqueeViewViewHold(View view) {
        ButterKnife.bind(this, view);
    }

    public void setView(Context context, BdqdBean bean) {
        iTvContent.setText(bean.getDiscription() + "");
    }
}
