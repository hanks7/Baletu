package com.hopeshine.taoxue.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hopeshine.taoxue.R;
import com.hopeshine.taoxue.utils.StatusBarCompat;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by CC on 2016/6/5.
 */

public class TopBar extends RelativeLayout {

    @Bind(R.id.btn_back)
    BackButton backButton;

    @Bind(R.id.tv_topTitle)
    TextView topTitle;

    @Bind(R.id.btn_top_right)
    ImageView btnTopRight;

    @Bind(R.id.tv_top_right)
    TextView tvTopRight;

    String title;

    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_toolbar, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.search_view);
        ButterKnife.bind(this, view);

        backButton.setVisibility(array.getBoolean(R.styleable.search_view_is_has_back, true) ? VISIBLE : GONE);
        topTitle.setText(array.getString(R.styleable.search_view_title));
        btnTopRight.setImageDrawable(array.getDrawable(R.styleable.search_view_right_iv));
        tvTopRight.setText(array.getString(R.styleable.search_view_bar_right_tv));
        setPadding(0, StatusBarCompat.getStatusBarHeight(context),0,0);

    }

    public void setTitle(@StringRes int resId) {
        if (topTitle != null)
            topTitle.setText(getResources().getString(resId));
    }

    public void setTitle(CharSequence title) {
        this.title = title.toString();
        if (topTitle != null) {
            topTitle.setText(title);
        }
    }

    /**
     * 设置右边图片
     *
     * @param resId
     */
    public void setBtnTopRightIcon(@DrawableRes int resId) {
        btnTopRight.setImageResource(resId);
    }

    /**
     * 右边图片按钮点击事件
     *
     * @param clickListener
     */
    public void setBtnTopRightClickListener(OnClickListener clickListener) {
        btnTopRight.setVisibility(VISIBLE);
        btnTopRight.setOnClickListener(clickListener);
    }

    /**
     * 右边文字按钮点击事件
     *
     * @param str
     * @param clickListener
     */
    public void setTvTopRightIcon(String str, OnClickListener clickListener) {
        tvTopRight.setText(str);
        tvTopRight.setVisibility(VISIBLE);
        tvTopRight.setOnClickListener(clickListener);
    }


    /**
     * 返回按钮监听
     *
     * @param onClickListener
     */
    public void setBackButtonListener(OnClickListener onClickListener) {
        backButton.setOnClickListener(onClickListener);
    }

    /**
     * 设置是否需要渐变
     */
    public void setNeedTranslucent(int transAlpha) {
        setBackgroundColor(Color.argb(transAlpha, 30, 198, 141));
    }

}
