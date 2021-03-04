package com.example.myapplication2.fragment.detailproduct;

import com.example.myapplication2.R;
import com.example.myapplication2.fragment.BaseFragment;


public class DetailProductFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_details;
    }

    @Override
    protected void initView() {

    }
    // trùng tên chưa , n thêm binding đàng sau // ok/// n sẽ trỏ tới xml đó
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
////        ProductCategory data = (ProductCategory) getArguments().getSerializable("ID");
//        DetailViewModel detailViewModel = new DetailViewModel("1000","9000");
////        binding = FragmentDetailsBinding.inflate(inflater, container, false);
////        binding.setDetailViewHodel(detailViewModel);
////        return binding.getRoot();
//    }


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
////        DetailViewModel detailViewModel = new DetailViewModel("1000", "9000");
////        databinding = com.example.myapplication2.databinding.FragmentDetailsBinding.inflate(inflater, container, false);
////        databinding.setDetailViewHodel(detailViewModel);
//        return databinding.getRoot();
//    }
}
