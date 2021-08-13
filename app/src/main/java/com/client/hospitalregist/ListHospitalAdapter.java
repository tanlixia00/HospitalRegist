package com.client.hospitalregist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ListHospitalAdapter extends RecyclerView.Adapter<ListHospitalAdapter.ViewHolder> {

    private ArrayList<RumahSakit> localDataSet = MainActivity.hospitals;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_show_hospital_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String nama = localDataSet.get(position).getNama();
        final String lok  = localDataSet.get(position).getLokasi_text();
        final String lati = localDataSet.get(position).getLati();
        final String longi  = localDataSet.get(position).getLongi();
        holder.getTxtnNamaRS().setText(nama);
        holder.getTxtLokasi().setText(lok);

        holder.getBtnDetail().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                intent.putExtra("latitude", lati);
                intent.putExtra("longitude", longi);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtnNamaRS;
        private final TextView txtLokasi;
        private  final Button btnDetail;



        public ViewHolder(View view) {
            super(view);
            txtnNamaRS = (TextView) view.findViewById(R.id.txtNamaRS);
            txtLokasi = (TextView) view.findViewById(R.id.txtLokasi);
            btnDetail = (Button)  view.findViewById(R.id.btnMaps);
        }

        public TextView getTxtnNamaRS() {
            return txtnNamaRS;
        }

        public TextView getTxtLokasi() {
            return txtLokasi;
        }
        public Button getBtnDetail() {
            return btnDetail;
        }

    }
}