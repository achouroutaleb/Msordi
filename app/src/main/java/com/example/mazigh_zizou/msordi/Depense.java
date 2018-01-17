package com.example.mazigh_zizou.msordi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static com.example.mazigh_zizou.msordi.Ajouter.MyPREFERENCES;

public class Depense extends AppCompatActivity {

    Context context1;
    EditText editText2;
    Button Ajouter2;
    Button Ajouter3;
    float amel1 = 0;
    float ronaldo = 0;
    char ronaldo2 = ' ';
    EditText date;
    Context Acontext;
    public static final String Namee = "nameKeyy";

    public static final String MyPREFERENCES = "MyPrefss";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depense);

        editText2 = (EditText) findViewById(R.id.entrerdepense);
        Ajouter2 = (Button) findViewById(R.id.button_depense);
        // Ajouter3 = (Button) findViewById(R.id.button_verification);
        date = (EditText) findViewById(R.id.ladate);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences datedepense = Depense.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences datededepenses = this.getSharedPreferences("dep", MODE_PRIVATE);
        final String namee = datededepenses.getString("iddepense", " ");
        SharedPreferences sommedepense=Depense.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sommedepenses=this.getSharedPreferences("somedep",MODE_PRIVATE);
        final Float somme=sommedepenses.getFloat("idsommedepense",MODE_PRIVATE);


        SharedPreferences prefs = this.getSharedPreferences("tek", MODE_PRIVATE);
        amel1 = prefs.getFloat("idName", 0);
        editText2.setText("0");

        Ajouter2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ghiles = editText2.getText().toString() + ronaldo2;

                if (ghiles == " ") {
                    editText2.setText("0");
                } else {


                    Float mazigh = Float.valueOf(editText2.getText().toString()) + ronaldo;

                    if (mazigh > amel1) {
                        Toast.makeText(Depense.this, "votre Solde est inférieure a"+mazigh+"€", Toast.LENGTH_SHORT).show();
                        editText2.setText("0");

                    }else if (mazigh==0){
                        Toast.makeText(Depense.this, "veuillez saisir une Somme", Toast.LENGTH_SHORT).show();
                        editText2.setText("0");
                    }
                    else {
                        Float sommedepenser = Float.valueOf(editText2.getText().toString());;
                        SharedPreferences.Editor editdim = getSharedPreferences("dim", MODE_PRIVATE).edit();
                        editdim.putFloat("idsommedepense",(float)sommedepenser);
                        editdim.commit();
                        Toast.makeText(Depense.this, +mazigh+" € : Débités et enregistrés ", Toast.LENGTH_SHORT).show();

                        // creation de sauvgarde pour datte
                        String ladatedajoute = date.getText().toString();
                        SharedPreferences.Editor editdep = getSharedPreferences("dep", MODE_PRIVATE).edit();
                        editdep.putString("iddepense", (String) ladatedajoute);
                        editdep.commit();
                        Toast.makeText(Depense.this, "Date Enregistrée", Toast.LENGTH_SHORT).show();

                        mazigh = Float.valueOf(editText2.getText().toString()) + ronaldo;

                        amel1 = amel1 - mazigh;
                        editText2.setText("0");

                        SharedPreferences.Editor editor = getSharedPreferences("tek", MODE_PRIVATE).edit();
                        editor.putFloat("idName", (float) amel1);
                        editor.commit();
                        date.setText("");





                    }

                }
            }});


        /*Ajouter3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Ajouter.this);






            }

        });
    }*/







}}








