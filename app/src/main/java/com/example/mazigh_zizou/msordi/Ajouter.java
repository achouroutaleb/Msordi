package com.example.mazigh_zizou.msordi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Ajouter extends AppCompatActivity {
    Context context;
    EditText editText;
    Button Ajouter;
    Button Ajouter1;
    float amel=0;
    float affichesomme=0;

    EditText madatedajout;
    public static final String Name = "nameKey";
    public static final String Datee= "madate";
    public static final String Afichesommeajouter="affichesommeajouterr";

    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences sharedPref = Ajouter.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedDate=Ajouter.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedAjoutsomme =Ajouter.this.getPreferences(Context.MODE_PRIVATE);

        SharedPreferences prefs = this.getSharedPreferences("tek", MODE_PRIVATE);
        final Float name = prefs.getFloat("idName", 0);
        SharedPreferences shareDate =this.getSharedPreferences("maz",MODE_PRIVATE);
        final String dateajout= shareDate.getString("madatee"," ");
        SharedPreferences sommeajouter=this.getSharedPreferences("ajt",MODE_PRIVATE);
        final Float sommeaj= sommeajouter.getFloat("idSomme",MODE_PRIVATE);





        editText = (EditText) findViewById(R.id.lentrer);
        Ajouter = (Button) findViewById(R.id.ajouterentre);

        madatedajout=(EditText)findViewById(R.id.iddateajouter) ;
         editText.setText("0");

        Ajouter.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {



                    Float mazigh = Float.valueOf(editText.getText().toString())+name;
                affichesomme=Float.valueOf(editText.getText().toString());
                if (affichesomme==0){
                    Toast.makeText(Ajouter.this,"Veuillez entrer une Somme",Toast.LENGTH_LONG).show();

                    editText.setText("0");}
                else {
                    amel = amel + mazigh;
                    SharedPreferences.Editor editraj=getSharedPreferences("ajt",MODE_PRIVATE).edit();
                    editraj.putFloat("idSomme",(float)affichesomme);
                    editraj.commit();
                    Toast.makeText(Ajouter.this,+affichesomme+" € : enregistrés et ajoutés",Toast.LENGTH_SHORT).show();




                    //  getPreferences(MODE_PRIVATE).edit().putDouble("Name of variable",amel).commit();
                    //   getPreferences(MODE_PRIVATE).edit().putFloat("Name of variable",amel).commit();

//               Toast.makeText(Ajouter.this,""+amel, Toast.LENGTH_SHORT).show();
                    String ladatedajout = madatedajout.getText().toString();

                        SharedPreferences.Editor editorR = getSharedPreferences("maz", MODE_PRIVATE).edit();
                        editorR.putString("madatee", (String) ladatedajout);
                        editorR.commit();
                        Toast.makeText(Ajouter.this, "Date ajoutée", Toast.LENGTH_SHORT).show();
                        madatedajout.setText(" ");
                        SharedPreferences.Editor editor = getSharedPreferences("tek", MODE_PRIVATE).edit();
                        editor.putFloat("idName", (float) amel);
                        editor.commit();


                        editText.setText("0");


                    }



            }

        });








            }


    }







