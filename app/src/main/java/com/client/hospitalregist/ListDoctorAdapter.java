package com.client.hospitalregist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListDoctorAdapter extends RecyclerView.Adapter<ListDoctorAdapter.ViewHolder> {

    private ArrayList<Doctors> localDataSet = ListDoctorsActivity.docs;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_doctors, parent, false);

        return new ListDoctorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String nama  = "Dokter " + localDataSet.get(position).getNama();
        final String spesialis = localDataSet.get(position).getSpesialis();
        final String phone  = localDataSet.get(position).getPhone();
        holder.getTxtNamaDoc().setText(nama);
        holder.getTxtSpesialisasi().setText(spesialis);
        holder.getTxtPhone().setText(phone);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtNamaDoc;
        private final TextView txtSpesialisasi;
        private  final TextView txtPhone;

        public TextView getTxtNamaDoc() {
            return txtNamaDoc;
        }

        public TextView getTxtSpesialisasi() {
            return txtSpesialisasi;
        }

        public TextView getTxtPhone() {
            return txtPhone;
        }

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            txtNamaDoc = (TextView) view.findViewById(R.id.txtname);
            txtSpesialisasi = (TextView) view.findViewById(R.id.txtQualifi);
            txtPhone = (TextView)  view.findViewById(R.id.txtPhone);


        }

    }

}
