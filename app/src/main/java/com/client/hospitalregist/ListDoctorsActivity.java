package com.client.hospitalregist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ListDoctorsActivity extends AppCompatActivity {

    public static ArrayList<Doctors> docs = new ArrayList<>();
    private RecyclerView recViewDoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doctors);
        Add();

    }

    private void UpdateList(){
        Log.d("deb c doc", docs.size()+"");
        recViewDoc = findViewById(R.id.recViewDoctors);
        LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recViewDoc.setLayoutManager(lm);
        ListDoctorAdapter adp = new ListDoctorAdapter();
        recViewDoc.setAdapter(adp);
    }

    private void Add() {
        String url="http://10.0.2.2/joki/getDoctors.php";
        Log.e("URL",url);
        docs.clear();
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray data = new JSONObject(response).getJSONArray("data");
                    for (int i=0; i<data.length(); i++){
                        JSONObject jObj = data.getJSONObject(i);
                        docs.add(new Doctors(jObj.getInt("doc_no"), jObj.getString("d_name"),
                                jObj.getString("qualification"), jObj.getString("ph_no")));
                        Log.d("debug doc", jObj.getInt("doc_no")+ "");
                    }
                    UpdateList();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ListDoctorsActivity.this,"err"+error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(ListDoctorsActivity.this);
        requestQueue.add(stringRequest);
        Log.d("deb c doc0 ", docs.size()+"");
    }
}