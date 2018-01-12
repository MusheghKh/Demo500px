package com.demo.demo500px.image;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.demo500px.R;
import com.demo.demo500px.data.model.Comment;

import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private List<Comment> mData;

    public CommentsAdapter(List<Comment> comments) {
        mData = comments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((TextView)holder.itemView).setText(mData.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
