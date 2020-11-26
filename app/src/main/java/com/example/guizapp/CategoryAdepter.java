package com.example.guizapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CategoryAdepter extends RecyclerView.Adapter<CategoryAdepter.Viewholder> {
    public CategoryAdepter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    private List<CategoryModel> categoryModelList;

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
    return  new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(categoryModelList.get(position).getUrl(),categoryModelList.get(position).getName(),categoryModelList.get(position).getSets());

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder
    {
        private TextView title;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv);
        }
        private void setData(String url, final String title, final  int sets)
        {
            this.title.setText(title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent setintent=new Intent(itemView.getContext(), SetsActivity.class);
                    setintent.putExtra("title",title);
                    setintent.putExtra("sets",sets);
                    itemView.getContext().startActivity(setintent);
                }
            });
        }
    }
}
