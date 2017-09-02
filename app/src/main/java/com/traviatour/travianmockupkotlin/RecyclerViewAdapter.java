package com.traviatour.travianmockupkotlin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {

    private List<String> list;
    private Context myContext;
    private String myStringRes;

    public class MyView extends RecyclerView.ViewHolder {
        public ImageView myImage;

        public MyView(View view) {
            super(view);

            //myImage = (ImageView) view.findViewById(R.id.round_image_view);
            myImage = (ImageView) view.findViewById(getStringResourceByName(myStringRes));
        }
    }


    public RecyclerViewAdapter(List<String> horizontalList, Context current, String strResource) {
        this.list = horizontalList;
        this.myContext = current;
        this.myStringRes = strResource;

    }

    private int getStringResourceByName(String aString) {
        String packageName = myContext.getPackageName();
        int resId = myContext.getResources().getIdentifier(aString, "id", packageName);
        return resId;

        /*
        GIMANA CARA BIAR GAK DEKLARASI BERULANG UNTUK MAIN ACTIVITY RECYCLER VIEW NYA ????
        */
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_tour, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {

        int imageResource = myContext.getResources().getIdentifier(list.get(position), null, myContext.getPackageName());
        holder.myImage.setImageResource(imageResource);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
