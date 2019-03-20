package com.example.directorioempleadoslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public EditText txtEmpleado;
    public TextView txtLista;
    private Button btnBuscar;
    public ArrayList<Empleado> listaEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLista = (TextView) findViewById(R.id.textLista);
        listaEmpleado = new ArrayList<>();

        if(getIntent().hasExtra("listaEmpleado")){
        Log.e("Archivo", "Aquiiiiiiii"+String.valueOf(listaEmpleado.size()));

          listaEmpleado = (ArrayList<Empleado>) getIntent().getExtras().getSerializable("listaEmpleado");
        }
        this.muestraPersonas();
    }
    public void agregarEmpleado(View view){
        Intent intent = new Intent(this, FormularioEmpleado.class);
        Log.e("Archivo", String.valueOf(listaEmpleado.size()));
        intent.putExtra("listaEmpleado",this.listaEmpleado);
        startActivity(intent);
   }

    private void muestraPersonas(){
        //TODO1: Validar si hay personas registradas
        String cadena = "NO HAY PERSONAS REGISTRADAS";
        if(this.listaEmpleado.isEmpty()) {
            txtLista.setText(cadena);
        }else {
            String _listaEmpleado = "";
            for (Empleado _empleado : this.listaEmpleado) {
                _listaEmpleado +=
                        _empleado.getNombre() + " " +
                                _empleado.getApellidoP() + " " +
                                _empleado.getApellidoM() + " " +
                                _empleado.getNumNomina() + " " +
                                _empleado.getTelefono() + " " +
                                "\n______________________________\n";
            }
            txtLista.setText(_listaEmpleado);
        }
    }
    private void buscar(View view){
        if(this.listaEmpleado.isEmpty()){
            Toast.makeText(this,"No hay elementos en las listas", Toast.LENGTH_LONG).show();
        }else {
            String _encontrados = this.filtrarEmpleados();
            if(_encontrados.length() > 0){
                txtLista.setText(_encontrados);
            }else{
                Toast.makeText(this,"No se encontraron coincidencias", Toast.LENGTH_LONG).show();
                this.muestraPersonas();
            }
        }
    }
    private String filtrarEmpleados(){
        String busqueda = txtEmpleado.getText().toString();
        String _coincidencias = "";
        String temporal = "";

        for(Empleado empleado : this.listaEmpleado){
            temporal = empleado.getNombre() + " " + empleado.getApellidoP() + " " + empleado.getApellidoM() + "\n" +
                    " - " + empleado.getNumNomina() + " - " + empleado.getTelefono() + "\n____________________\n";
            if(temporal.contains(busqueda)){
               _coincidencias += temporal;
            }
            temporal = "";
        }

        return _coincidencias;
    }

}
