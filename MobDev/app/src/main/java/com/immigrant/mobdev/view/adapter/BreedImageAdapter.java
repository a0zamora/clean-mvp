package com.immigrant.mobdev.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.immigrant.mobdev.R;
import com.immigrant.mobdev.common.ImageManager;
import com.immigrant.mobdev.domain.model.BreedImageViewModel;
import com.immigrant.mobdev.view.adapter.viewholder.BreedImageViewHolder;

import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedImageAdapter extends RecyclerView.Adapter<BreedImageViewHolder> {

    List<BreedImageViewModel> list;

    @Override
    public BreedImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breed_image_item, parent, false);
        return new BreedImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BreedImageViewHolder holder, int position) {
        ImageManager.renderImage(holder.imageView, list.get(position).getName());
    }

    public void updateData(List<BreedImageViewModel> breedViewModelList) {
        list = breedViewModelList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list == null ? 0: list.size();
    }
}
