package com.example.windows10.userwis;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.windows10.userwis.Rest.ApiClient;

public class LayarDetailHomestay extends AppCompatActivity {
    ImageView mPhotoUrl ;
    TextView tvNama, tvFasilitas, tvHarga, tvAlamat, tvContact ;
    Context mContext ;
    String pathImage = "" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_detail_homestay);

        mContext = getApplicationContext ();
        mPhotoUrl = (ImageView) findViewById(R.id.imgHome);
        tvNama = (TextView) findViewById(R.id.namaHome);
        tvHarga = (TextView) findViewById(R.id.harga);
        tvContact = (TextView) findViewById(R.id.contact);
        tvFasilitas = (TextView) findViewById(R.id.fasilitas);
        tvAlamat = (TextView) findViewById(R.id.alamat);


        Intent mIntent = getIntent ();
        tvNama . setText ( mIntent . getStringExtra ( "nama" ));
        tvHarga . setText ( mIntent . getStringExtra ( "harga" ));
        tvContact . setText ( mIntent . getStringExtra ( "contact" ));
        tvFasilitas . setText ( mIntent . getStringExtra ( "fasilitas" ));
        tvAlamat . setText ( mIntent . getStringExtra ( "alamat" ));

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
