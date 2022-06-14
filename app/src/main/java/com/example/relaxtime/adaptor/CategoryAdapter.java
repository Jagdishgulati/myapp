package com.example.relaxtime.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.relaxtime.MattressActivity;
import com.example.relaxtime.Domain.Category;
import com.example.relaxtime.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private  Context context;
    private  List<Category> mCategoryList;

    public CategoryAdapter(Context context, List<Category> mCategorylist) {
        this.context=context;
        this.mCategoryList= mCategorylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(context).load(mCategoryList.get(position).getImg_url()).into(holder.mTypeimg);
        holder.mTypeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MattressActivity.class);
                intent.putExtra("type",mCategoryList.get(holder.getAdapterPosition()).getType());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         private ImageView mTypeimg;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mTypeimg= itemView.findViewById(R.id.category_img);
        }
    }
}
