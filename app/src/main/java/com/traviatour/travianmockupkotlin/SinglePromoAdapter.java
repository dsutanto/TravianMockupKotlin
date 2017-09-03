package com.traviatour.travianmockupkotlin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rog on 03-Sep-17.
 */

public class SinglePromoAdapter extends RecyclerView.Adapter<SinglePromoAdapter.ViewHolder>{

    private List<SinglePromoModel> mApps;

    public SinglePromoAdapter(List<SinglePromoModel> apps) {
        mApps = apps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_promo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SinglePromoModel app = mApps.get(position);
        holder.PromoImage.setImageResource(app.getPromoDrawable());
        holder.PromoName.setText(app.getPromoName());
        holder.PromoTag.setText(String.valueOf(app.getPromoTag()));
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView PromoImage;
        public TextView PromoName;
        public TextView PromoTag;

        public ViewHolder(View itemView) {
            super(itemView);
            PromoImage = (ImageView) itemView.findViewById(R.id.SingleItemImage);
            PromoName = (TextView) itemView.findViewById(R.id.SingleTvTitle);
            PromoTag = (TextView) itemView.findViewById(R.id.SingleTvTag);
        }

    }
}
