package com.example.windows10.userwis;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.windows10.userwis.Adapter.WisataAdapter;
import com.example.windows10.userwis.Model.GetWisata;
import com.example.windows10.userwis.Model.Wisata;
import com.example.windows10.userwis.Rest.ApiClient;
import com.example.windows10.userwis.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarListWisata extends AppCompatActivity {
    RecyclerView mRecyclerView ;
    RecyclerView.Adapter mAdapter ;
    RecyclerView.LayoutManager mLayoutManager ;
    Context mContext ;
    ApiInterface mApiInterface ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_wisata);

        mContext = getApplicationContext ();
        mRecyclerView = ( RecyclerView ) findViewById ( R . id . recyclerView );
        mLayoutManager = new LinearLayoutManager( mContext );
        mRecyclerView . setLayoutManager ( mLayoutManager );
        mApiInterface = ApiClient.getClient().create (ApiInterface.class );
        Call<GetWisata> mWisataCall = mApiInterface.getWisata();
        mWisataCall.enqueue ( new Callback<GetWisata>() {
            @Override
            public void onResponse(Call<GetWisata > call , Response<GetWisata> response ) {
                Log.d("Get Wisata" , response . body (). getStatus ());
                List<Wisata> listWisata = response . body (). getResult ();
                mAdapter = new WisataAdapter( listWisata );
                mRecyclerView . setAdapter ( mAdapter );
            }
            @Override
            public void onFailure ( Call < GetWisata > call , Throwable t ) {
                Log.d ( "Get Wisata" , t . getMessage ());
            }
        });
    }
}
