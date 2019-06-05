package com.minhacabecamovel.enrir.barlator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    DatabaseHelper mDatabasehelper;

    private ArrayList<String> mDesc = new ArrayList<>();
    private Context mContext;


    public RecyclerViewAdapter(ArrayList<String> desc, Context context){
        mDesc = desc;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int position) {

        viewHolder.produto_desc_view.setText(mDesc.get(position));
    }

    @Override
    public int getItemCount() {
        return mDesc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Integer temp;
        TextView container_item;
        TextView produto_desc_view;
        TextView contagem_view;
        Button btn_rmv;
        Button btn_add;
        RelativeLayout id_relative_layout;

        public ViewHolder(View itemView) {
            super(itemView);

            produto_desc_view = itemView.findViewById(R.id.produto_desc_view);
            contagem_view = itemView.findViewById(R.id.contagem_view);
            btn_rmv = itemView.findViewById(R.id.btn_rmv);
            btn_add = itemView.findViewById(R.id.btn_add);
            id_relative_layout = itemView.findViewById(R.id.id_relative_layout);
            temp = 0;
            btn_rmv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (temp > 0) {
                        temp--;
                    }
                    contagem_view.setText(""+temp);
                }
            });

            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        temp++;
                    contagem_view.setText(""+temp);
                }
            });


        }
    }
}
