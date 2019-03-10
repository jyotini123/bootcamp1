package com.dsc.android.bootcamp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<RecyclerViewData> recyclerViewDataList = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setRecyclerViewDataList(List<RecyclerViewData> recyclerViewDataList) {
        this.recyclerViewDataList = recyclerViewDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.recycler_view_item,viewGroup,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        RecyclerViewData data = recyclerViewDataList.get(i);
        myViewHolder.txtName.setText(data.getName());
        myViewHolder.txtNumber.setText(data.getNumber());

        Glide.with(context).load(data.getImage()).apply(RequestOptions.circleCropTransform()).into(myViewHolder.img);




    }

    @Override
    public int getItemCount() {

        return recyclerViewDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtName,txtNumber;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtNumber = itemView.findViewById(R.id.txt_number);
            img = itemView.findViewById(R.id.img);
        }

    }
}

