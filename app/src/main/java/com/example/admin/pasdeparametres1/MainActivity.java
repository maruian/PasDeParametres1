/*
 * Maties Ruiz
 * 2DAM
 */

package com.example.admin.pasdeparametres1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button botoEnviar;
    private EditText editNom;
    private TextView textResultat;
    private RadioButton radioFemella, radioMascle;
    private final int SUBACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botoEnviar=(Button)findViewById(R.id.botoEnviar);
        editNom=(EditText)findViewById(R.id.editNom);
        radioFemella=(RadioButton) findViewById(R.id.radioFemella);
        radioMascle=(RadioButton)findViewById(R.id.radioMascle);
        botoEnviar.setOnClickListener(this);
    }

    public void onSaveInstanceState(Bundle b){
        b.putCharSequence("nom",editNom.getText());
        b.putBoolean("radioFemella",radioFemella.isChecked());
        b.putBoolean("radioMascle",radioMascle.isChecked());
    }

    public void onRestoreInstanceState(Bundle b){
        editNom.setText(b.getCharSequence("nom"));
        radioFemella.setChecked(b.getBoolean("radioFemella"));
        radioMascle.setChecked(b.getBoolean("radioMascle"));
    }

    public void onClick(View v){
        Intent explicit_intent;
        explicit_intent = new Intent(this,Finestra2.class);
        String auxEditNom=editNom.getText().toString();
        if (radioFemella.isChecked()){
            explicit_intent.putExtra("sexe","femella");
        } else if (radioMascle.isChecked()){
            explicit_intent.putExtra("sexe","mascle");
        } else {
            explicit_intent.putExtra("sexe","sense definir");
        }
        explicit_intent.putExtra("nom",auxEditNom);
        startActivityForResult(explicit_intent, SUBACTIVITY);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == SUBACTIVITY){
            if(resultCode == RESULT_OK){
                editNom.setEnabled(false);
                botoEnviar.setEnabled(false);
                radioFemella.setEnabled(false);
                radioMascle.setEnabled(false);
                editNom.setEnabled(false);
                escriuResultat(data.getIntExtra("edat",0));
            }
        }
    }


    public void escriuResultat(int edat){
        textResultat=(TextView)findViewById(R.id.textResultat);
        if ((edat>=18)&&(edat<25)) {
            textResultat.setText("Ja eres major d'edat");
        } else if ((edat>=25)&&(edat<35)){
            textResultat.setText("Estas en la flor de la vida!");
        } else {
            textResultat.setText("Ui, ui, ui...");
        }
    }


}


