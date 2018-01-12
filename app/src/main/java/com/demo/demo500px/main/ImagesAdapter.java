package com.demo.demo500px.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.demo.demo500px.R;
import com.demo.demo500px.data.model.Image;

import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder>{

    private List<Image> mData;
    private MainPresenter mPresenter;

    public ImagesAdapter(List<Image> data, MainPresenter presenter) {
        mData = data;
        mPresenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Image img = mData.get(position);
        Glide.with(holder.itemView).load(img.getUrl()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.showImage(img.getId(), img.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }

}
