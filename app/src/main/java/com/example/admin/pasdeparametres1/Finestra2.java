/*
* Maties Ruiz
* 2DAM
 */

package com.example.admin.pasdeparametres1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class Finestra2 extends AppCompatActivity implements View.OnClickListener{

    TextView editNom, editEdat;
    Button botoContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finestra2);
        escriuInfoRebuda();
        botoContinuar=(Button)findViewById(R.id.botoContinuar);
        botoContinuar.setOnClickListener(this);
    }

    public void escriuInfoRebuda(){
        editNom=(TextView)findViewById(R.id.textSenyor);
        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        if (extras != null){
            String datoNom=(String)extras.get("nom");
            String datoSexe=(String)extras.get("sexe");
            editNom.setText("Hola "+datoNom+ ", veig que eres un(a) "+datoSexe+ " molt atractiu, indicans les seguents dades:");
        }
    }

    public void onClick(View v){
        editEdat=(TextView)findViewById(R.id.editEdat);
        Intent resultat = new Intent();
        String auxEditEdat=editEdat.getText().toString();
        try {
            int edat = Integer.parseInt(auxEditEdat);
            resultat.putExtra("edat",edat);
            setResult(RESULT_OK, resultat);
            finish();
        } catch (NumberFormatException n){
            Toast.makeText(this,"Deus introduir un valor correcte",Toast.LENGTH_LONG).show();
        }
    }

}
