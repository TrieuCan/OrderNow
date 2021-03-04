package com.example.myapplication2.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication2.R;
import com.example.myapplication2.activity.MainActivity;

public class LogoutFragment extends BaseFragment {
    public static final String TAG = LogoutFragment.class.getName();
    private ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.test_fragment;
    }

    @Override
    protected void initView() {
        // THử toatokookm
//       chay

        imageView = findViewById(R.id.tv_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
