package com.nsh.getintoclub.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nsh.getintoclub.R;
import com.nsh.getintoclub.model.Quote;

import java.util.List;

/**
 * Created by ThisIsNSH on 9/1/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    List<Quote> quoteList;

    public MainAdapter(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.adapter_main, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MyViewHolder holder, int position) {
        Quote quote = quoteList.get(position);
        holder.detail.setText(quote.getDetail());
        holder.title.setText(quote.getTitle());
        holder.textView.setText(quote.getQuote());
        holder.relativeLayout.setBackground(quote.getDrawable());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView,title,detail;
        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            detail = itemView.findViewById(R.id.detail);
            title = itemView.findViewById(R.id.title);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
