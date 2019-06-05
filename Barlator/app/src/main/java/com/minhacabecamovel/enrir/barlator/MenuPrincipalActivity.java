package com.minhacabecamovel.enrir.barlator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Button btn_start;
    private Button btn_places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btn_start = findViewById(R.id.btn_start);
        btn_places = findViewById(R.id.btn_places);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStart();
            }
        });

    }

    public void openStart(){
        Intent intent = new Intent(this, CompraActivity.class);
        startActivity(intent);
    }

}
