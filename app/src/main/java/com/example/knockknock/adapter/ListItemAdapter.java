package com.example.knockknock.adapter;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knockknock.MainActivity;
import com.example.knockknock.R;
import com.example.knockknock.TodolistActivity;
import com.example.knockknock.model.ToDo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {

    ItemClickListener itemClickListener;
    TextView item_title, item_description;

    public ListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

        item_title = (TextView) itemView.findViewById(R.id.item_title);
        item_description = (TextView) itemView.findViewById(R.id.item_description);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;


    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select the action");
        menu.add(0, 0, getAbsoluteAdapterPosition(), "DELETE");
        menu.add(0, 1, getAbsoluteAdapterPosition(), "MARK AS DONE");

    }
}

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    TodolistActivity mainActivity;
    List<ToDo> toDoList;

    public ListItemAdapter(TodolistActivity mainActivity, List<ToDo> toDoList) {
        this.mainActivity = mainActivity;
        this.toDoList = toDoList;
    }


    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        if (toDoList.get(position).isMark() == true) {
            holder.item_title.setTextColor(Color.parseColor("#000000"));
            holder.item_title.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.item_title.setText(toDoList.get(position).getTitle());
            holder.item_description.setVisibility(View.INVISIBLE);
        } else {
            holder.item_title.setText(toDoList.get(position).getTitle());
            holder.item_description.setText(toDoList.get(position).getDescription());
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                mainActivity.title.setText(toDoList.get(position).getTitle());
                mainActivity.description.setText(toDoList.get(position).getDescription());

                mainActivity.isUpdate = true;
                mainActivity.idUpdate = toDoList.get(position).getNoteid();

            }
        });

    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
