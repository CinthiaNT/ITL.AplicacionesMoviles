package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_pantalla;
    private Button btn_0, btn_1, btn_2,btn_3,btn_4,btn_5,btn_6,btn_7, btn_8, btn_9,
            btn_punto, btn_eliminar, btn_igual, btn_clear, btn_mas, btn_menos, btn_multiplica,
            btn_division, btn_masDecimales, btn_menosDecimales, btn_save,btn_negativo,btn_potencia,btn_factorial,
            btn_raizCuadrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--------------------Valores para pruebas------------------------------//
        float numero1 = 5;
        float numero2 = 6;
        int operacion = 7;
        float resul = operaciones_complejas(operacion,numero2);

        txt_pantalla = (EditText) findViewById(R.id.txt_pantalla);
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
                txt_pantalla.setText(txt_pantalla.getText().toString());
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
                txt_pantalla.setText(txt_pantalla.getText().toString()+"=");
                break;
            case R.id.btn_clear:
                //txtPantalla.setText(txtPantalla.get);
                break;
            case R.id.btn_mas:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"+");
                break;
            case R.id.btn_menos:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"-");
                break;
            case R.id.btn_multiplica:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"x");
                break;
            case R.id.btn_division:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"/");
                break;
            case R.id.btn_negativo:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"-");
                break;
            case R.id.btn_raizCuadrada:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"√()");
                break;
            case R.id.btn_potencia:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"sqr()");
                break;
            case R.id.btn_factorial:
                txt_pantalla.setText(txt_pantalla.getText().toString()+"fact()");
                break;
            case R.id.btn_eliminar:
                alerta("Elimino el  ultimo caracter");
                break;
            case R.id.btn_masDecimales:
                alerta("Se agregaron decimales");
                break;
            case R.id.btn_menosDecimales:
                alerta("Se eliminaron decimales");
                break;
            case R.id.btn_save:
                alerta("Se guardo el ultimo calculo");
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
        switch (operacion) {
            case 1:
                return numero1 + numero2;
            case 2:
                return numero1 - numero2;
            case 3:
                return numero1 * numero2;
            case 4:
                return numero1/numero2;
        }
        return 0;
    }
    private float operaciones_complejas(int operacion,float numero1){
        switch (operacion){
            case (5):
                    return factorial(numero1);
            case(6):
                return (float)Math.sqrt((double)numero1);
            case(7):
                return (float)Math.pow((double)numero1,2);
        }
        return 0;
    }
    private float factorial(float numero1){
        if (numero1==0)
            return 1;
        else
            return numero1 * factorial(numero1-1);
    }



}
