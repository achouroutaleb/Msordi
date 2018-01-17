package com.example.mazigh_zizou.msordi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

TextView afficheur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        afficheur=(TextView) findViewById(R.id.afficheur);

        SharedPreferences prefs = this.getSharedPreferences("tek", MODE_PRIVATE);
        Float name = prefs.getFloat("idName", 0);

        afficheur.setText(""+name+"€");



        final Button Ajouter = (Button) findViewById(R.id.ajouter);
        Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent = new Intent(MainActivity.this, Ajouter.class);
                startActivity(MyIntent);
            }
        });
        final Button depenser = (Button)findViewById(R.id.depense);
        depenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Depense.class);
                startActivity(intent1);
            }
        });
         Button detail = (Button)findViewById(R.id.detail);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this, Madate.class);
                startActivity(intent3);
            }
        });

    }



    public void refresh(View v ){          //refresh is onClick name given to the button
        onRestart();
    }

    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        finish();

    };
}