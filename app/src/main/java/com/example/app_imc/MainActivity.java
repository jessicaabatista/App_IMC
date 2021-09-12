package com.example.app_imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText altura, peso;
    private EditText resultado;
    private Button bt_calcular, btlimpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altura = (EditText) findViewById(R.id.editText_altura);
        peso = (EditText) findViewById(R.id.editText_peso);

        resultado = (EditText) findViewById(R.id.editText_res);

        bt_calcular = findViewById(R.id.button_calcular);
        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double v_peso;
                Double v_altura;
                Double resp;

                if (!(peso.getText().toString().isEmpty()) && !(altura.getText().toString().isEmpty())) {
                    v_peso = Double.parseDouble(peso.getText().toString());
                    v_altura = Double.parseDouble(altura.getText().toString());

                    resp = Math.round(((v_peso / (v_altura * v_altura))) * 100.0) / 100.0;

                    if (resp < 18.5)
                        resultado.setText(resp.toString() + " - Abaixo do peso");
                    else if (resp >= 18.5 && resp <= 24.9)
                        resultado.setText(resp.toString() + " - Normal");
                    else if (resp > 24.9 && resp < 30)
                        resultado.setText(resp.toString() + " - Sobrepeso");
                    else if (resp >= 30)
                        resultado.setText(resp.toString() + " - Obesidade");
                }else
                    resultado.setText("");
            }
        });

        btlimpa = findViewById(R.id.button_limpar);
        btlimpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altura.setText("");
                peso.setText("");
                resultado.setText("");
            }
        });
    }
}
