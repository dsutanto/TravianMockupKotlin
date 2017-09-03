package com.traviatour.travianmockupkotlin;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class SectionPromoAdapter extends RecyclerView.Adapter<SectionPromoAdapter.ViewHolder> {

    private ArrayList<SectionPromoModel> PromoItemList;

    public SectionPromoAdapter() {
        PromoItemList = new ArrayList<>();
    }

    public void AddSection(SectionPromoModel PromoModel) {
        PromoItemList.add(PromoModel);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_promo_list, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SectionPromoModel PromoModel = PromoItemList.get(position);
        holder.SectionTextView.setText(PromoModel.GetSectionTitle());
        holder.SectionRecyclerView.setLayoutManager(new LinearLayoutManager(holder.SectionRecyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.SectionRecyclerView.setOnFlingListener(null);
        holder.SectionRecyclerView.setAdapter(new SinglePromoAdapter(PromoModel.getAllItemsInSection()));
    }

    @Override
    public int getItemCount() {
        return (null != PromoItemList ? PromoItemList.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView SectionTextView;
        public RecyclerView SectionRecyclerView;
        public Button SectionButton;

        public ViewHolder(View itemView) {
            super(itemView);
            SectionTextView = (TextView) itemView.findViewById(R.id.SectionItemTitle);
            SectionRecyclerView = (RecyclerView) itemView.findViewById(R.id.Section_rv_list);
            SectionButton = (Button) itemView.findViewById(R.id.SectionBtnMore);
        }

    }
}



//extends RecyclerView.Adapter<SectionPromoAdapter.ViewHolder> {

//    public static final int VERTICAL = 0;
//    public static final int HORIZONTAL = 1;
//
//
//    public SectionPromoAdapter() {
//        mSnaps = new ArrayList<>();
//    }
//
//    public void addSnap(SectionPromoDataModel snap) {
//        mSnaps.add(snap);
//    }
//
//    private ArrayList<SectionPromoDataModel> mSnaps;
//    // Disable touch detection for parent recyclerView if we use vertical nested recyclerViews
//    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            v.getParent().requestDisallowInterceptTouchEvent(true);
//            return false;
//        }
//    };
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.home_recycler_list_item, parent, false);
//
//        return new ViewHolder(view);
//
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        SectionPromoDataModel snap = mSnaps.get(position);
//        holder.snapTextView.setText(snap.getText());
//
//        holder.recyclerView.setAdapter(new PromoDataAdapter(snap.getApps()));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mSnaps.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView snapTextView;
//        public RecyclerView recyclerView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            snapTextView = (TextView) itemView.findViewById(R.id.itemTitle);
//            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_list);
//        }
//
//    }
//}
