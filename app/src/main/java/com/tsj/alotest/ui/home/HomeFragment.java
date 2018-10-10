package com.tsj.alotest.ui.home;

import com.tsj.alotest.R;
import com.tsj.alotest.ui.BaseActivity;
import com.tsj.alotest.ui.BaseFragment;

import butterknife.OnClick;

/**
 * Created by tunggul.jati on 09/10/2018.
 */

public class HomeFragment extends BaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.f_home;
    }

    @OnClick(R.id.rl1)
    void showMonas(){
//        DetailActivity.startActivity((BaseActivity) HomeActivity.this, "monas");
    }

    @OnClick(R.id.rl2)
    void showPancoran(){
//        DetailActivity.startActivity((BaseActivity) HomeActivity.this, "pancoran");
    }

    @OnClick(R.id.rl3)
    void showFatah(){
//        DetailActivity.startActivity((BaseActivity) HomeActivity.this, "fatah");
    }
}
