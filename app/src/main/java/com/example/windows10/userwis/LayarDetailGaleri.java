package com.example.windows10.userwis;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.windows10.userwis.Rest.ApiClient;

public class LayarDetailGaleri extends AppCompatActivity {
    ImageView mPhotoUrl ;
    TextView tvJudul, tvTgl;
    Context mContext ;
    String pathImage = "" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_detail_galeri);

        mContext = getApplicationContext ();
        mPhotoUrl = (ImageView) findViewById(R.id.imgWis);
        tvJudul = (TextView) findViewById(R.id.judul);
        tvTgl = (TextView) findViewById(R.id.tgl);



        Intent mIntent = getIntent ();
        tvJudul . setText ( mIntent . getStringExtra ( "judul" ));
        tvTgl . setText ( mIntent . getStringExtra ( "tgl" ));

// if (mIntent.getStringExtra("photo_url").length()>0) Picasso.with(mContext).load
// (ApiClient.BASE_URL + mIntent.getStringExtra("photo_url")).into(mPhotoUrl);
// else Picasso.with(mContext).load(R.drawable.photoid).into(mPhotoUrl);
        if ( mIntent . getStringExtra ( "photo_url" ) != null )
            Glide. with ( mContext ). load ( ApiClient.BASE_URL + mIntent . getStringExtra ( "photo_url" )). into ( mPhotoUrl );
        else
            Glide . with ( mContext ). load ( R . drawable . backwis ). into ( mPhotoUrl );
        pathImage = mIntent . getStringExtra ( "photo_url" );
    }
}
