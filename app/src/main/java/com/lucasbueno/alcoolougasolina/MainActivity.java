package com.lucasbueno.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById((R.id.editPrecoAlcool));
        editPrecoGasolina = findViewById((R.id.editPrecoGasolina));
        textResultado = findViewById((R.id.textResultado));


    }

    public void calcularPreço(View view){

        //recupera valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);
        if ( camposValidados ){
            this.calcularMelhorPreço(precoAlcool, precoGasolina);
        }else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public void calcularMelhorPreço (String pAlcool, String pGasolina){

        //converter valores string para numbers
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        /* Faz cáculo ( precoAlcool / precoGasolina )
            * Se resultado >= 0.7 melhor utilizar gasolina
            * senão melhor utilizar Álcool
         * */

        Double reultado = precoAlcool / precoGasolina;
        if(reultado >= 0.7){
            textResultado.setText("Melhor utilizar Gasolina!");
        }else{
            textResultado.setText("Melhor utilizar Álcool!");
        }

    }



    public boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidos = true;

        //validar campos
        if (pAlcool==null || pAlcool.equals("")){
            camposValidos = false;
        }else if (pGasolina==null || pGasolina.equals("") ){
            camposValidos = false;
        }

        return camposValidos;
    }
}
