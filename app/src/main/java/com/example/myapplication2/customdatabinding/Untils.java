package com.example.myapplication2.customdatabinding;

import android.widget.TextView;


public class Untils {
    private static Untils instance;

    static {
        try {
            instance = new Untils();
        } catch (Exception e) {

        }
    }

    public static Untils getInstance() {
        return instance;
    }


    // k hiêu chõ nào k?
    //đoạn vừa bôi đen
//    @BindingAdapter("setText") // dòng này  tạo binding custom
    public static void setText(TextView tv, String content) {  // dòng này tạo settext custom cua databinding .. khi dùng nó sẽ hiện là:
        // app:setText() ; Sử dụng như setText ở xml
        // 2 tham số đó 2 là text view , 2 là nội dung của text view đó
        tv.setText(content); // dòng này set text cho text view nè !ok
    }
}
