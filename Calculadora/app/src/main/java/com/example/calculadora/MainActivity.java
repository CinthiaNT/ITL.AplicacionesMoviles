package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_pantalla;
    private TextView txt_resultado;
    private Button btn_0, btn_1, btn_2,btn_3,btn_4,btn_5,btn_6,btn_7, btn_8, btn_9,
            btn_punto, btn_eliminar, btn_igual, btn_clear, btn_mas, btn_menos, btn_multiplica,
            btn_division, btn_masDecimales, btn_menosDecimales, btn_save,btn_negativo,btn_potencia,btn_factorial,
            btn_raizCuadrada,btn_porcentaje;
    private int operacion;
    private float numero1,numero2,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--------------------Valores para pruebas------------------------------//
        txt_pantalla = (EditText) findViewById(R.id.txt_pantalla);
        txt_resultado = (TextView) findViewById(R.id.txt_resultado);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_punto = (Button) findViewById(R.id.btn_punto);
        btn_eliminar = (Button) findViewById(R.id.btn_eliminar);
        btn_porcentaje = (Button) findViewById(R.id.btn_porcentaje);
        btn_igual = (Button) findViewById(R.id.btn_igual);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_mas = (Button) findViewById(R.id.btn_mas);
        btn_menos = (Button) findViewById(R.id.btn_menos);
        btn_multiplica = (Button) findViewById(R.id.btn_multiplica);
        btn_division = (Button) findViewById(R.id.btn_division);
        btn_negativo = (Button) findViewById(R.id.btn_negativo);
        btn_raizCuadrada = (Button) findViewById(R.id.btn_raizCuadrada);
        btn_factorial = (Button) findViewById(R.id.btn_factorial);
        btn_raizCuadrada = (Button) findViewById(R.id.btn_raizCuadrada);
        btn_masDecimales = (Button) findViewById(R.id.btn_masDecimales);
        btn_menosDecimales = (Button) findViewById(R.id.btn_menosDecimales);
        btn_save = (Button) findViewById(R.id.btn_save);

    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_0:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"0");
                break;
            case R.id.btn_1:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"1");
                break;
            case R.id.btn_2:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"2");
                break;
            case R.id.btn_3:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"3");
                break;
            case R.id.btn_4:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"4");
                break;
            case R.id.btn_5:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"5");
                break;
            case R.id.btn_6:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"6");
                break;
            case R.id.btn_7:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"7");
                break;
            case R.id.btn_8:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"8");
                break;
            case R.id.btn_9:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"9");
                break;
            case R.id.btn_punto:
                txt_pantalla.setText(txt_pantalla.getText().toString()+".");
                break;
            case R.id.btn_igual:
                if(operacion >= 7){
                    resultado=operaciones_complejas(operacion,numero1);
                }else{
                    numero2 = Float.parseFloat(txt_pantalla.getText().toString());
                    resultado = operaciones_basicas(operacion,numero1,numero2);
                }
                txt_pantalla.setText("");
                txt_pantalla.setText(txt_pantalla.getText().toString() + resultado);
                txt_resultado.setText("");
                break;
            case R.id.btn_clear:
                txt_pantalla.setText("");
                break;
            case R.id.btn_mas:
                operacion = 1;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText()+"+");
                txt_pantalla.setText("");
                break;
            case R.id.btn_menos:
                operacion = 2;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText()+"-");
                txt_pantalla.setText("");
                break;
            case R.id.btn_multiplica:
                operacion = 3;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText()+"x");
                txt_pantalla.setText("");
                break;
            case R.id.btn_division:
                operacion = 4;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText()+"/");
                txt_pantalla.setText("");
                break;
            case R.id.btn_negativo:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"-");
                break;
            case R.id.btn_raizCuadrada:
                operacion = 8;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText().toString()+"√("+numero1+")");
                txt_pantalla.setText("");
                break;
            case R.id.btn_potencia:
                operacion = 5;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText()+"^");
                txt_pantalla.setText("");
                break;
            case R.id.btn_porcentaje:
                operacion = 6;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText()+"%");
                txt_pantalla.setText("");
                break;
            case R.id.btn_factorial:
                operacion = 7;
                numero1 = Float.parseFloat(txt_pantalla.getText().toString());
                txt_resultado.setText(txt_pantalla.getText().toString()+"fact("+numero1+")");
                txt_pantalla.setText("");
                break;
            case R.id.btn_eliminar:
                txt_pantalla.setText(eliminar(txt_pantalla.getText().toString()));
                break;
            case R.id.btn_masDecimales:
                alerta("Se agregaron decimales");
                break;
            case R.id.btn_menosDecimales:
                alerta("Se eliminaron decimales");
                break;
            case R.id.btn_save:
                txt_pantalla.setText(txt_pantalla.getText().toString() + resultado);
                break;
        }

    }
    public void alerta(String texto){
        Toast toast = Toast.makeText(
                getApplicationContext(),
                texto,
                Toast.LENGTH_LONG);
        toast.show();
    }

    //--------------------METODOS PRIVADOS---------------------------------------//
    private float operaciones_basicas(int operacion,float numero1, float numero2){
        Float resul = 0f;
        switch (operacion) {
            case 1:
                resul = numero1 + numero2;
                break;
            case 2:
                resul = numero1 - numero2;
                break;
            case 3:
                resul = numero1 * numero2;
                break;
            case 4:
                resul = numero1/numero2;
                break;
            case 5:
                resul = (float)Math.pow((double)numero1,(double)numero2);
                break;
            case 6:
                resul = (numero1 * numero2)/100;
        }
        return resul;
    }
    private float operaciones_complejas(int operacion,float numero1){
        Float res = 0f;
        switch (operacion){
            case 7:
                res = factorial(numero1);
                break;
            case 8:
                res = (float)Math.sqrt((double)numero1);
                break;
        }
        return res;
    }
    private float factorial(float numero1){
        if (numero1==0)
            return 1;
        else
            return numero1 * factorial(numero1-1);
    }
    private String eliminar(String cadena){
        return cadena.substring(0, cadena.length() - 1);
    }


}
