package com.example.windows10.userwis.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.windows10.userwis.LayarDetailHomestay;
import com.example.windows10.userwis.Model.Homestay;
import com.example.windows10.userwis.R;
import com.example.windows10.userwis.Rest.ApiClient;

import java.util.List;

public class HomestayAdapter extends RecyclerView. Adapter < HomestayAdapter.HomestayViewHolder> {
    List<Homestay> listHomestay ;
    public HomestayAdapter ( List < Homestay> listHomestay ) {
        this . listHomestay = listHomestay ;
    }
    @Override
    public HomestayAdapter . HomestayViewHolder onCreateViewHolder ( ViewGroup parent ,
                                                                     int viewType ) {
        View view =
                LayoutInflater. from ( parent . getContext ()). inflate ( R. layout . list_homestay , parent ,
                        false );
        HomestayAdapter.HomestayViewHolder mHolder = new HomestayAdapter.HomestayViewHolder( view );
        return mHolder ;
    }
    @Override
    public void onBindViewHolder ( HomestayAdapter . HomestayViewHolder holder , final
    int position ) {
        holder . tvNama . setText ( listHomestay . get ( position ). getNama ());

        holder . tvHarga . setText ( listHomestay . get ( position ). getHarga ());

        if ( listHomestay. get ( position ). getPhotoUrl () != null ){
//Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listPembeli.get(position).getPhotoId())
// .into(holder.mPhotoURL);
            Glide. with ( holder . itemView . getContext ()). load ( ApiClient.BASE_URL + listHomestay . get
                    ( position ). getPhotoUrl ())
                    . into ( holder . mPhotoURL );
        } else {
//Picasso.with(holder.itemView.getContext()).load(R.drawable.photoid).into(holder
// .mPhotoURL);
            Glide . with ( holder . itemView . getContext ()). load ( R . drawable . backwis ). into ( holder
                    . mPhotoURL );
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(), LayarDetailHomestay.class);
                in.putExtra("id_homestay",listHomestay.get(position).getIdHomestay());
                in.putExtra("nama",listHomestay.get(position).getNama());
                in.putExtra("fasilitas",listHomestay.get(position).getFasilitas());
                in.putExtra("harga",listHomestay.get(position).getHarga());
                in.putExtra("contact",listHomestay.get(position).getContact());
                in.putExtra("alamat",listHomestay.get(position).getAlamat());
                in.putExtra("photo_url",listHomestay.get(position).getPhotoUrl());
                view.getContext().startActivity(in);
            }
        });
    }
    @Override
    public int getItemCount () {
        return listHomestay . size ();
    }
    public class HomestayViewHolder extends RecyclerView. ViewHolder {
        ImageView mPhotoURL ;
        TextView tvNama , tvHarga ;
        public HomestayViewHolder ( View itemView ) {
            super ( itemView );
            mPhotoURL = ( ImageView ) itemView . findViewById ( R . id . imgHome );
            tvNama = ( TextView ) itemView . findViewById ( R . id . tvNama );
            tvHarga = ( TextView ) itemView . findViewById ( R . id . tvHarga );

        }
    }
}
