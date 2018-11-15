package com.bondex.ysl.mytest;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bondex.ysl.mytest.bean.AdapterBean;
import com.bondex.ysl.mytest.databinding.ListviewItemLayoutBinding;

import java.util.ArrayList;

/**
 * date: 2018/11/13
 * Author: ysl
 * description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private ArrayList<String> list;


    public MyAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_item_layout,viewGroup,false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        AdapterBean bean = new AdapterBean();
        bean.setStr("adapter " + i);

      viewHolder.setBean(bean);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private ListviewItemLayoutBinding binding;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }



        public void setBean(@NonNull AdapterBean bean) {

            binding.setAdapter(bean);
        }
    }

}
