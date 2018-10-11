package com.tsj.alotest.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.tsj.alotest.R;
import com.tsj.alotest.ui.BaseActivity;

import butterknife.Bind;

/**
 * Created by tunggul.jati on 10/10/2018.
 */

public class DetailActivity extends BaseActivity {

    @Bind(R.id.rl_monas)
    RelativeLayout rl_monas;

    @Bind(R.id.rl_pancoran)
    RelativeLayout rl_pancoran;

    @Bind(R.id.rl_fatah)
    RelativeLayout rl_fatah;

    private static final String STATUS = "logo";
    private String stts = "";

    @Override
    protected int getLayout() {
        return R.layout.a_detail;
    }

    public static void startActivity(BaseActivity sourceActivity, String status) {
        Intent i = new Intent(sourceActivity, DetailActivity.class);
        i.putExtra(STATUS, status);
        sourceActivity.startActivity(i);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stts = getIntent().getStringExtra(STATUS);
        Log.d("onCreate: ", stts);
        switch (stts) {
            case "monas":
                Log.d("onCreateView: ", "monas");
                showMonas();
                break;
            case "pancoran":
                Log.d("onCreateView: ", "pancoran");
                showPancoran();
                break;
            case "fatah":
                Log.d("onCreateView: ", "fatah");
                showFatah();
                break;
        }
    }

    private void showMonas(){
        rl_monas.setVisibility(View.VISIBLE);
        rl_pancoran.setVisibility(View.GONE);
        rl_fatah.setVisibility(View.GONE);
    }

    private void showPancoran(){
        rl_monas.setVisibility(View.GONE);
        rl_pancoran.setVisibility(View.VISIBLE);
        rl_fatah.setVisibility(View.GONE);
    }

    private void showFatah(){
        rl_monas.setVisibility(View.GONE);
        rl_pancoran.setVisibility(View.GONE);
        rl_fatah.setVisibility(View.VISIBLE);
    }

}
