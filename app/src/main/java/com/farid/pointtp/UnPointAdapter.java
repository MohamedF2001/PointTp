package com.farid.pointtp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UnPointAdapter extends BaseAdapter {
    private Context context;
    private List<UnPoint> PointItemList;
    private LayoutInflater inflater;

    public UnPointAdapter(Context context, List<UnPoint> PointItemList) {
        this.context = context;
        this.PointItemList = PointItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return PointItemList.size();
    }

    @Override
    public UnPoint getItem(int position) {
        return PointItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_point, null);

        UnPoint itemCourant = getItem(i);
        String itemName = itemCourant.getNom();
        String itemAdress = itemCourant.getAdresse();
        /*String itemDesc = itemCourant.getDesc();
        String itemService = itemCourant.getService();
        String itemHour = itemCourant.getHoraire();*/
        String memonic = itemCourant.getMemonic();
        int itemNum = itemCourant.getNumero();

        ImageView itemIconView = view.findViewById(R.id.imageIcon);
        String ressourceName = "item_" +memonic+ "_icon";
        int resID = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resID);

        TextView textName = view.findViewById(R.id.nom_restau);
        textName.setText(itemName);

        TextView textAdress = view.findViewById(R.id.resto_adresse);
        textAdress.setText(itemAdress);

        TextView textNum = view.findViewById(R.id.num_resto);
        textNum.setText(itemNum+"");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context,LaListe.class);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
