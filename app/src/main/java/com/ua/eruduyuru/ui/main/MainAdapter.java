package com.ua.eruduyuru.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ua.eruduyuru.R;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;
import com.ua.eruduyuru.ui.announcement.AnnouncementViewImpl;
import com.ua.eruduyuru.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<Department> departmentList;

    public MainAdapter(ArrayList<Department> departments) {
        this.departmentList = departments;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    public List<Department> getDepartments() {
        return departmentList;
    }


    @Override
    public int getItemCount() {
        return departmentList.size();
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
            final Department department = departmentList.get(position);
            text.setText(department.getTitle());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), AnnouncementViewImpl.class);
                intent.putExtra("url", department.getUrl());
                itemView.getContext().startActivity(intent);
            });
        }

        @Override
        protected void clear() {

        }
    }

}
