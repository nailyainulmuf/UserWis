package com.example.windows10.userwis;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.windows10.userwis.Adapter.HomestayAdapter;

import com.example.windows10.userwis.Model.GetHomestay;

import com.example.windows10.userwis.Model.Homestay;

import com.example.windows10.userwis.Rest.ApiClient;
import com.example.windows10.userwis.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarListHomestay extends AppCompatActivity {
    RecyclerView mRecyclerView ;
    RecyclerView.Adapter mAdapter ;
    RecyclerView.LayoutManager mLayoutManager ;
    Context mContext ;
    ApiInterface mApiInterface ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_homestay);

        mContext = getApplicationContext ();
        mRecyclerView = ( RecyclerView ) findViewById ( R . id . recyclerView );
        mLayoutManager = new LinearLayoutManager( mContext );
        mRecyclerView . setLayoutManager ( mLayoutManager );
        mApiInterface = ApiClient.getClient().create (ApiInterface.class );
        Call<GetHomestay> mHomestayCall = mApiInterface.getHomestay();
        mHomestayCall.enqueue ( new Callback<GetHomestay>() {
            @Override
            public void onResponse(Call<GetHomestay > call , Response<GetHomestay> response ) {
                Log.d("Get Homestay" , response . body (). getStatus ());
                List<Homestay> listHomestay = response . body (). getResult ();
                mAdapter = new HomestayAdapter( listHomestay );
                mRecyclerView . setAdapter ( mAdapter );
            }
            @Override
            public void onFailure ( Call < GetHomestay > call , Throwable t ) {
                Log.d ( "Get Homestay" , t . getMessage ());
            }
        });
    }
}
