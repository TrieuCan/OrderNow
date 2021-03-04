package com.example.myapplication2.model.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHodel> {
    private final Context mContext;
    private List<Category> list;
    private final CategoryICallBack iCallBack;


    public interface CategoryICallBack {
        void onClick(int position);
    }

    public CategoryAdapter(Context mContext, List<Category> list, CategoryICallBack iCallBack) {
        this.mContext = mContext;
        this.list = list;
        this.iCallBack = iCallBack;
    }

    public void setData(List<Category> mList) {
        this.list = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHodel holder, int position) {
        Category category = list.get(position);
        if (category == null) {
            return;
        }
        holder.imageView.setImageResource(category.getImageCategory());
        holder.textView.setText(category.getNameCategory());
        holder.imageView.setOnClickListener(v -> {
            iCallBack.onClick(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class CategoryHodel extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final CircleImageView imageView;
        private final CardView car_view_cgr;

        public CategoryHodel(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_category);
            textView = itemView.findViewById(R.id.tv_category);
            car_view_cgr = itemView.findViewById(R.id.card_view_category);
        }
    }
}
