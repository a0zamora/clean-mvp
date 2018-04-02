package com.immigrant.mobdev.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.immigrant.mobdev.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedNameViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.breed_name)
    public TextView breedName;

    public BreedNameViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
