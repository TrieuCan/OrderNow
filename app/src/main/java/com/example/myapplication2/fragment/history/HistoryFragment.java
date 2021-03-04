package com.example.myapplication2.fragment.history;

import com.example.myapplication2.R;
import com.example.myapplication2.fragment.BaseFragment;

public class HistoryFragment extends BaseFragment {
    public static final String TAG = HistoryFragment.class.getName();

    private HistoryViewModel historyViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    protected void initView() {

    }

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        galleryViewModel =
//                new ViewModelProvider(this).get(GalleryViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//            }
//        });
//        return root;
//    }
}