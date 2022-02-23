package com.farid.pointtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ListingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_details);


        TextView outputnom = findViewById(R.id.nom);
        TextView outputservices = findViewById(R.id.services);
        TextView outputadress = findViewById(R.id.adress);
        TextView outputhoraire = findViewById(R.id.horaire);
        TextView outputtel = findViewById(R.id.tel);
        TextView outputdesc = findViewById(R.id.des);
        ImageView image = findViewById(R.id.imageView);

        String json = null;
        InputStream jsonFile = null;

        Intent intent = getIntent();
        int position = (int) intent.getExtras().get("position");

        try {
            jsonFile = getAssets().open("les_restaurants.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            JSONObject object = new JSONObject(json);

            outputnom.setVisibility(View.VISIBLE);
            outputservices.setVisibility(View.VISIBLE);
            outputadress.setVisibility(View.VISIBLE);
            outputhoraire.setVisibility(View.VISIBLE);
            outputtel.setVisibility(View.VISIBLE);
            outputdesc.setVisibility(View.VISIBLE);

            JSONArray childArray = object.getJSONArray("resto");
            for (int i = 0; i < childArray.length(); i++) {
                if (position == i){
                    outputnom.setText(childArray.getJSONObject(i).getString("nom"));
                    outputservices.setText(childArray.getJSONObject(i).getString("services"));
                    outputadress.setText(childArray.getJSONObject(i).getString("adresse"));
                    outputhoraire.setText(childArray.getJSONObject(i).getString("horaires"));
                    outputtel.setText(childArray.getJSONObject(i).getString("tel"));
                    outputdesc.setText(childArray.getJSONObject(i).getString("description"));
                    //Picasso.get().load(childArray.getJSONObject(i).getString("img")).into(image);

                }

                //Toast.makeText(this, ""+childArray.getJSONObject(i).getString("nom"), Toast.LENGTH_SHORT).show();
            }



            //outputnom.setText(json);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}