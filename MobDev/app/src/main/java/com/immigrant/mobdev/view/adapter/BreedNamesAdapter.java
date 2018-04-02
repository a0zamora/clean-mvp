package com.immigrant.mobdev.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.immigrant.mobdev.R;
import com.immigrant.mobdev.domain.model.BreedViewModel;
import com.immigrant.mobdev.view.adapter.viewholder.BreedNameViewHolder;

import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedNamesAdapter extends RecyclerView.Adapter<BreedNameViewHolder>{
    MobDevListAdapter listener;
    List<BreedViewModel> mBreedList;
    @Override
    public BreedNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            listener = ((MobDevListAdapter) parent.getContext());
        }catch (Exception e){
            listener = null;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breed_name_item, parent, false);
        return new BreedNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BreedNameViewHolder holder, final int position) {
        holder.breedName.setText(mBreedList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onNameClicked(mBreedList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBreedList == null ? 0 : mBreedList.size();
    }

    public void updateData(List<BreedViewModel> breedList){
        mBreedList =  breedList;
        notifyDataSetChanged();
    }

}
