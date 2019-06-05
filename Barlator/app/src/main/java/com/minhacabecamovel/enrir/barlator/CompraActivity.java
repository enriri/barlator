package com.minhacabecamovel.enrir.barlator;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class CompraActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private ArrayList<String> mDesc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        initBasedesc();
        initArrayBase();
        initRecyclerView();
    }

    private void initArrayBase(){
        Cursor data = mDatabaseHelper.getData();
        while(data.moveToNext()){
            mDesc.add(data.getString(1));
        }
    }

    private void initBasedesc(){
        mDatabaseHelper = new DatabaseHelper(this);

        mDatabaseHelper.addData("Cerveja");
        mDatabaseHelper.addData("Gurjao");
        mDatabaseHelper.addData("Vodka");
        mDatabaseHelper.addData("Gin");


    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.Recycle_item_desc);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mDesc, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
