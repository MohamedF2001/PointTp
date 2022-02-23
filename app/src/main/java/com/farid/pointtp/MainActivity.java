package com.farid.pointtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.farid.pointtp.UnPoint;
import com.farid.pointtp.UnPointAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UnPoint> PointList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PointList.add(new UnPoint("RESTAURANT LE RESTO COTONOU", "Piste Amalco, Cotonou",
                "leresto",97011111));
        PointList.add(new UnPoint("LA TERASSE", "Rue 2315, Cotonou" ,
                "laterasse",97184385));
        PointList.add(new UnPoint("LE FESTIVAL DES GLACES", "03 BP 3286, Cotonou" ,
                "festival",69696982));
        PointList.add(new UnPoint("MAD", "Piste Amalco, Cotonou",
                "mad",97673169));
        PointList.add(new UnPoint("L'OISEAU BLEU RESTAURANT", "103 BP 01631 COTONOU " +
                "Quartier JERICHO Carré 490 rue 511 de la pharmacie LE NOKOUE, Cotonou",
                "oiseau",61106060));
        PointList.add(new UnPoint("Mimi's Bénin", "Cotonou",
                "mimi",97571010));
        PointList.add(new UnPoint("Three One lounge bar restaurant", "Cotonou",
                "threeone",90929218));
        PointList.add(new UnPoint("Restaurant BABEL Lounge Bar", "01BP2893, Cotonou",
                "babel",97975555));

        ListView shopList = findViewById(R.id.maListePoints);
        shopList.setAdapter(new UnPointAdapter(this,PointList));


    }


}