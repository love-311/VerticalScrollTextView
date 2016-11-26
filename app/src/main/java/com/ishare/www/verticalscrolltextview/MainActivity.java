package com.ishare.www.verticalscrolltextview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.widget.Toast;

import com.ishare.www.verticalscrolltext.VerticalTextView;
import com.ishare.www.verticalscrolltext.utils.SpanUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VerticalTextView TextView;
    private ArrayList<SpannableString> titleList = new ArrayList<>();
    private List<String> mKeyWordString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        TextView = (VerticalTextView) findViewById(R.id.text);
        String string = new String("恭喜 流浪狗 获得 iPhone 7plus 一台");
        mKeyWordString.add("恭喜");
        mKeyWordString.add("获得");
        mKeyWordString.add("一台");
        SpannableString spannableString = null;
        try {
            spannableString = SpanUtils.getKeyWordSpan(Color.BLUE, string, mKeyWordString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        titleList.add(spannableString);
        titleList.add(spannableString);
        titleList.add(spannableString);
        titleList.add(spannableString);
        TextView.setTextList(titleList);
        TextView.setTextStillTime(3000);//设置停留时长间隔
        TextView.setAnimTime(300);//设置进入和退出的时间间隔
        TextView.setOnItemClickListener(new VerticalTextView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "点击了 : " + titleList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView.stopAutoScroll();
    }
}
