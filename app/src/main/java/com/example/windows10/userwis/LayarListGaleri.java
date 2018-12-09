package com.example.windows10.userwis;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.windows10.userwis.Adapter.GaleriAdapter;
import com.example.windows10.userwis.Model.Galeri;
import com.example.windows10.userwis.Model.GetGaleri;
import com.example.windows10.userwis.Rest.ApiClient;
import com.example.windows10.userwis.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarListGaleri extends AppCompatActivity {
    RecyclerView mRecyclerView ;
    RecyclerView.Adapter mAdapter ;
    RecyclerView.LayoutManager mLayoutManager ;
    Context mContext ;
    ApiInterface mApiInterface ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_galeri);

        mContext = getApplicationContext ();
        mRecyclerView = ( RecyclerView ) findViewById ( R . id . recyclerView );
        mLayoutManager = new LinearLayoutManager( mContext );
        mRecyclerView . setLayoutManager ( mLayoutManager );
        mApiInterface = ApiClient.getClient().create (ApiInterface.class );
        Call<GetGaleri> mGaleriCall = mApiInterface.getGaleri();
        mGaleriCall.enqueue ( new Callback<GetGaleri>() {
            @Override
            public void onResponse(Call<GetGaleri > call , Response<GetGaleri> response ) {
                Log.d("Get Galeri" , response . body (). getStatus ());
                List<Galeri> listGaleri = response . body (). getResult ();
                mAdapter = new GaleriAdapter( listGaleri );
                mRecyclerView . setAdapter ( mAdapter );
            }
            @Override
            public void onFailure ( Call < GetGaleri > call , Throwable t ) {
                Log.d ( "Get Galeri" , t . getMessage ());
            }
        });
    }
}
