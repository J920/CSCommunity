package com.android.team920.cscommunity.Home.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.team920.cscommunity.R;

import java.util.ArrayList;
import java.util.List;
// this adapter for PublicFragment in the Home page
public class HomePublicAdapter extends RecyclerView.Adapter<HomePublicAdapter.MyViewHolder>  {
    private Context mContext;
    private List<String> itemList = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public CardView cardView;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt);

            cardView=(CardView) view.findViewById(R.id.card_view);
        }
    }
    public HomePublicAdapter(Context mContext, List<String> itemsList) {
        this.mContext = mContext;
        this.itemList = itemsList;
    }

    @Override
    public HomePublicAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_card, parent, false);

        return new HomePublicAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HomePublicAdapter.MyViewHolder holder, int position) {
        String item = itemList.get(position);
        holder.title.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
