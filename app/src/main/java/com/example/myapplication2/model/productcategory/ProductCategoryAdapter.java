package com.example.myapplication2.model.productcategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryHodel> implements Filterable {
    private final Context mContext;
    private List<ProductCategory> mList;
    private final List<ProductCategory> mListSearch;
    private final CategoryICallBack iCallBack;


    public interface CategoryICallBack {
        void callbackId(int position);
    }

    public ProductCategoryAdapter(Context mContext, List<ProductCategory> list, CategoryICallBack iCallBack) {
        this.mContext = mContext;
        this.mList = list;
        this.iCallBack = iCallBack;
        this.mListSearch = new ArrayList<>(mList);
    }

    public void setData(List<ProductCategory> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ProductCategoryHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_category_item, parent, false);
        return new ProductCategoryHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryHodel holder, int position) {
        ProductCategory productCategory = mList.get(position);
        if (productCategory == null) {
            return;
        }
        holder.tvName.setText(productCategory.getProductCgrName());
        holder.image.setImageResource(productCategory.getProductCgrImage());
        holder.tvPrice.setText(String.valueOf(productCategory.getPrice()));
        if (productCategory.getProductFavorite() == 1) {
            holder.imageLike.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.SRC_IN);
            holder.imageLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productCategory.setProductFavorite(0);
                    holder.imageLike.setColorFilter(ContextCompat.getColor(mContext, R.color.white), android.graphics.PorterDuff.Mode.SRC_IN);
                }
            });
        } else {
            holder.imageLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productCategory.setProductFavorite(1);
                    holder.imageLike.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.SRC_IN);
                }
            });
        }
        holder.car_view_cgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCallBack.callbackId(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private final Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ProductCategory> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(mListSearch);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ProductCategory item : mListSearch) {
                    if (item.getProductCgrName().toLowerCase().contains(filterPattern)) {
                        filterList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mList.clear();
            mList.addAll((Collection<? extends ProductCategory>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ProductCategoryHodel extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvPrice;
        private final ImageView image;
        private final ImageView imageLike;
        private final CardView car_view_cgr;

        public ProductCategoryHodel(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_product_category);
            tvName = itemView.findViewById(R.id.tv_product_category);
            car_view_cgr = itemView.findViewById(R.id.card_view_product_category);
            tvPrice = itemView.findViewById(R.id.tv_price);
            imageLike = itemView.findViewById(R.id.iv_like);
        }
    }
}
