package com.example.myapplication2.fragment.home;

import android.view.View;
import android.widget.Button;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.activity.MainActivity;
import com.example.myapplication2.database.RoomDatabase;
import com.example.myapplication2.fragment.BaseFragment;
import com.example.myapplication2.model.category.Category;
import com.example.myapplication2.model.category.CategoryAdapter;

import java.util.List;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = HomeFragment.class.getName();

    private HomeViewModel homeViewModel;
    private RecyclerView rcvCategory, rcvProductHot, rcvProductSale, rcvProductNew;
    private CategoryAdapter categoryAdapter;
    private RoomDatabase roomDatabase;
    private Button button;
    private int index;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        LoadData();
        mutableLiveDataViewHodel();
    }

    private void LoadData() {
        button = findViewById(R.id.bt_add);
        button.setOnClickListener(this);
        roomDatabase = RoomDatabase.getInstance(mContext);
        rcvCategory = findViewById(R.id.rcv_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rcvCategory.setLayoutManager(gridLayoutManager);
    }

    private void mutableLiveDataViewHodel() {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getmListCategory(roomDatabase).observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryAdapter = new CategoryAdapter(mContext, categories, new CategoryAdapter.CategoryICallBack() {
                    @Override
                    public void onClick(int position) {
                        ((MainActivity) getActivity()).fragmentProductCategory(categories.get(position).getCID());
                    }
                });
                rcvCategory.setAdapter(categoryAdapter);
            }
        });
    }


    @Override
    public void onClick(View v) {
        index = 0;
        Category category = new Category("Thời Trang Nam" + index, R.drawable.thoitrangnam);
        homeViewModel.addCategory(category, roomDatabase);
        index++;
    }

}