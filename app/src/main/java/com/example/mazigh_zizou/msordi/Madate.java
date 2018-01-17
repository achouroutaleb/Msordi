package com.example.mazigh_zizou.msordi;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Madate extends AppCompatActivity {
TextView afficheurdate;
TextView afficheuredatedepense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madate);

        afficheurdate=(TextView)findViewById(R.id.afficheur_date);
        afficheuredatedepense=(TextView)findViewById(R.id.afficheurdatedepense);
        SharedPreferences shareDate = this.getSharedPreferences("maz", MODE_PRIVATE);
        String amekihi = shareDate.getString("madatee", " ");
        SharedPreferences sommeajouter = this.getSharedPreferences("ajt", MODE_PRIVATE);
        Float somme=sommeajouter.getFloat("idSomme",0);
        SharedPreferences datedepenses = this.getSharedPreferences("dep", MODE_PRIVATE);
        final String ladate = datedepenses.getString("iddepense", " ");
        SharedPreferences sommedepenses=this.getSharedPreferences("dim",MODE_PRIVATE);
        final  Float sommes=sommedepenses.getFloat("idsommedepense",0);


        afficheurdate.setText(""+somme+ "€\nLe "  +amekihi);
        afficheuredatedepense.setText(""+sommes+ "€\nLe "  +ladate);
    }
}
