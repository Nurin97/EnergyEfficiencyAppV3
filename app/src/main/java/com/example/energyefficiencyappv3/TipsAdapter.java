package com.example.energyefficiencyappv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.TipsViewHolder> {
    private Context context;
    private List<Tips> tipsList;

    public TipsAdapter(Context context, List<Tips> tipsList) {
        this.context = context;
        this.tipsList = tipsList;
    }

    public void setTipsList(List<Tips> tipsList) {
        this.tipsList = tipsList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tips, parent, false);
        return new TipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TipsViewHolder holder, int position) {
        Tips tip = tipsList.get(position);
        holder.tipTitleTextView.setText(tip.getTitle());
        holder.tipDescriptionTextView.setText(tip.getContent());
    }

    @Override
    public int getItemCount() {
        return tipsList.size();
    }

    public class TipsViewHolder extends RecyclerView.ViewHolder {
        public TextView tipTitleTextView;
        public TextView tipDescriptionTextView;

        public TipsViewHolder(@NonNull View itemView) {
            super(itemView);
            tipTitleTextView = itemView.findViewById(R.id.tipTitleTextView);
            tipDescriptionTextView = itemView.findViewById(R.id.tipDescriptionTextView);
        }
    }
}
