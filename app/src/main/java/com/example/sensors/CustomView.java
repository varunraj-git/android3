package com.example.sensors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import static androidx.core.content.ContextCompat.startActivity;
//private Button btn_url;


public class CustomView extends View {

        public CustomView(Context context) {
            super(context);

        }

        public CustomView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }


}
