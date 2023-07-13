package com.example.pushapp;



import android.icu.text.SimpleDateFormat;

import java.util.Date;

// 데이터 모델 클래스
public class NewsItem {
    private String title;
    private String content;
    private String link;

    private String created_date;

    public NewsItem(String title, String content, String link, String created_date) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.created_date = created_date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLink(){
        return link;
    }

    public String getCreatedDate() {
        Date date = new Date(created_date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
        return String.valueOf(simpleDateFormat.format(date));
    }
}

