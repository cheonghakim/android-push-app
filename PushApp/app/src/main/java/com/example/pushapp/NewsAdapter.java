package com.example.pushapp;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.messaging.FirebaseMessaging;

import org.w3c.dom.Text;

import java.util.List;

// 어댑터 클래스
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsItem> itemList;

    private static final String TAG = "NewsAdapter";
    public NewsAdapter(List<NewsItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // RecyclerView의 각 아이템에 사용될 레이아웃을 인플레이션하여 ViewHolder 생성
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_newsletters, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // ViewHolder에 데이터 바인딩
        NewsItem item = itemList.get(position);
        holder.titleTextView.setText(item.getTitle() + "...");
        holder.contentTextView.setText(item.getContent() + "...");
        holder.dateTextView.setText(item.getCreatedDate());

        holder.titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = item.getLink();
                if (!link.isEmpty()) {
                    // 링크 주소를 사용자에게 보여주지 않고 웹 브라우저를 실행하여 링크로 연결
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link.trim()));
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView contentTextView;

        public TextView dateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}
