package com.example.windows10.userwis.Rest;

import com.example.windows10.userwis.Model.GetGaleri;
import com.example.windows10.userwis.Model.GetHomestay;
import com.example.windows10.userwis.Model.GetWisata;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET( "wisata/all" )
    Call<GetWisata> getWisata ();

    @GET( "homestay/all" )
    Call<GetHomestay> getHomestay ();

    @GET( "galeri/all" )
    Call<GetGaleri> getGaleri ();
}
