package com.example.myapplication2.fragment;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication2.R;
import com.google.android.material.navigation.NavigationView;

public class ActionFragment extends BaseFragment implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = ActionFragment.class.getName();
    public static final String FRAGMENT_HOME = "FRAGMENT_HOME";
    public static final String FRAGMENT_HISTORY = "FRAGMENT_HISTORY";
    public static final String FRAGMENT_FAVORITE = "FRAGMENT_FAVORITE";
    public static final String FRAGMENT_EVALUATE = "FRAGMENT_EVALUATE";
    public static final String FRAGMENT_SETTING = "FRAGMENT_SETTING";
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView nav;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_action;
    }

    @Override
    protected void initView() {
        ActionButtonFloating();
        ActionDrawerNav();
        ActionToolbar();
    }

    private void ActionDrawerNav() {
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);
        nav.getMenu().findItem(R.id.nav_home).setChecked(true);
        mCallBack.callBack(FRAGMENT_HOME, null);
    }

    private void ActionButtonFloating() {
//        FloatingActionButton fab = findViewById(R.id.fabutton);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    //fragment càn truyefn đau
    private void ActionToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.custom_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.icon_cart:
                Toast.makeText(mContext, "123", Toast.LENGTH_LONG).show();
                break;
            case R.id.icon_notification:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                mCallBack.callBack(FRAGMENT_HOME, null);
                break;
            case R.id.nav_history:
                mCallBack.callBack(FRAGMENT_HISTORY, null);
                break;
            case R.id.nav_favourite:
                mCallBack.callBack(FRAGMENT_FAVORITE, null);
                break;
            case R.id.nav_evaluate:
                mCallBack.callBack(FRAGMENT_EVALUATE, null);
                break;
            case R.id.nav_setting:
                mCallBack.callBack(FRAGMENT_SETTING, null);
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}