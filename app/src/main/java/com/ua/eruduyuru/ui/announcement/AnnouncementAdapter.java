package com.ua.eruduyuru.ui.announcement;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ua.eruduyuru.R;
import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnnouncementAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    private List<Article> articleList;

    public AnnouncementAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_article_view, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {

        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public List<Article> getArticles() {
        return articleList;
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.text)
        protected TextView text;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            final Article article = articleList.get(position);
            text.setText(article.toString());

            itemView.setOnClickListener(v -> {

            });
        }

        @Override
        protected void clear() {

        }
    }

}
