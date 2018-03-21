package com.hopeshine.taoxue.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hopeshine.taoxue.R;
import com.hopeshine.taoxue.utils.StatusBarCompat;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 支持渐变的 actionBar
 * Created by 晖仔(Milo) on 2016/12/28.
 * email:303767416@qq.com
 */

public final class TranslucentActionBar extends LinearLayout {

    @Bind(R.id.fa_home_iv_head)
    ImageView leftCilck;
    @Bind(R.id.et_search)
    EditText etSearch;

    private View contentView;

    public TranslucentActionBar(Context context) {
        this(context, null);
    }

    public TranslucentActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
        contentView = inflate(getContext(), R.layout.include_title_search, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.search_view);
        ButterKnife.bind(this, contentView);
        etSearch.setHint(array.getString(R.styleable.search_view_search_text));
        etSearch.setFocusable(false);
        setPadding(0, StatusBarCompat.getStatusBarHeight(context),0,0);

    }

    public TranslucentActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 设置是否需要渐变
     */
    public void setNeedTranslucent(int transAlpha) {
        setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary));
        getBackground().setAlpha(transAlpha);
    }


    /**
     * 设置数据
     *
     * @param listener
     */
    public void setData(final ActionBarClickListener listener) {

        leftCilck.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLeftClick();
            }
        });
        etSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSearchClick();
            }
        });
    }


    /**
     * [ActionBar点击监听器]
     * Created by yanjunhui
     * on 2016/8/17.
     * email:303767416@qq.com
     */
    public interface ActionBarClickListener {

        void onLeftClick();

        void onSearchClick();

    }
}
