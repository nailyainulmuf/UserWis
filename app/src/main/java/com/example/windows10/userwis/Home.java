package com.example.windows10.userwis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private Button btn_wisata, btn_homestay, btn_gal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent mIntent = getIntent();

        TextView username = (TextView) findViewById(R.id.username);
        username.setText(mIntent.getStringExtra("username"));

        btn_wisata = (Button) findViewById(R.id.btn_wisata);
        btn_homestay = (Button) findViewById(R.id.btn_homestay);
        btn_gal = (Button) findViewById(R.id.btn_gal);

        btn_wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, LayarListWisata.class);
                startActivity(intent);
            }
        });
        btn_homestay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, LayarListHomestay.class);
                startActivity(intent);
            }
        });
        btn_gal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, LayarListGaleri.class);
                startActivity(intent);
            }
        });
    }
    public void button_onClick(View view){
        SharedPreferences set = this.getSharedPreferences("key", Context.MODE_PRIVATE );
        SharedPreferences . Editor editor = set.edit();
        editor.clear();
        editor.commit();
        finish();

        Intent i = new Intent(this.getApplicationContext(), MainActivity.class);
    }
}
