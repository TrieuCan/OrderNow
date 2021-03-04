package com.example.myapplication2.fragment.productcategory;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.activity.MainActivity;
import com.example.myapplication2.database.RoomDatabase;
import com.example.myapplication2.fragment.BaseFragment;
import com.example.myapplication2.model.productcategory.ProductCategory;
import com.example.myapplication2.model.productcategory.ProductCategoryAdapter;

import java.util.List;

public class ProductCategoryFragment extends BaseFragment {
    private Toolbar toolbar;
    private ProductCategoryAdapter adapter;
    private RecyclerView rcvProductCategory;
    private ProductCategoryViewModel productCategoryViewModel;
    private RoomDatabase roomDatabase;
    private SearchView searchView;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_product_category;
    }

    @Override
    protected void initView() {
        ActionToolbar();
        loadData();
        mutableLiveDataViewHodel();
    }

    private void ActionToolbar() {
        toolbar = findViewById(R.id.tool_bar);
        TextView textView = findViewById(R.id.toolbar_title);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setTitle("Search");
        textView.setText(toolbar.getTitle());
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
                return;
            }
        });
    }

    private void loadData() {
        searchView = findViewById(R.id.search_product_category);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        rcvProductCategory = findViewById(R.id.rcv_product_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcvProductCategory.setLayoutManager(gridLayoutManager);
        id = (int) getArguments().get("Id");
    }

    private void mutableLiveDataViewHodel() {
        roomDatabase = RoomDatabase.getInstance(mContext);
//        ProductCategory productCategory = new ProductCategory(id, "Áo", R.drawable.thoitrangnam, 10000, "Áo sơ mi",
//                "đẹp", "20", 1);
//        roomDatabase.queryDAO().insertProductCategory(productCategory);
        productCategoryViewModel = new ViewModelProvider(this).get(ProductCategoryViewModel.class);
        productCategoryViewModel.getmListProductCategory(roomDatabase, id).observe(this, new Observer<List<ProductCategory>>() {
            @Override
            public void onChanged(List<ProductCategory> productCategories) {
                adapter = new ProductCategoryAdapter(mContext, productCategories, new ProductCategoryAdapter.CategoryICallBack() {
                    @Override
                    public void callbackId(int position) {
                        ((MainActivity) getActivity()).fragmentDeatilProduct(productCategories.get(position));
                    }
                });
                rcvProductCategory.setAdapter(adapter);
            }
        });
    }


}
