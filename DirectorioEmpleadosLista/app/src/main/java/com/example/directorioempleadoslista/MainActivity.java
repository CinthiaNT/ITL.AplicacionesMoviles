package com.example.directorioempleadoslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        txtLista = (TextView) findViewById(R.id.txtApellidoP);
        listaEmpleado = new ArrayList<>();

        if(getIntent().hasExtra("listaEmpleado")){
            listaEmpleado = (ArrayList<Empleado>)
                            getIntent().getExtras().getSerializable("listaEmpleado");
        }
        this.muestraPersonas();
    }
    public void agregarEmpleado(View view){
        Intent intent = new Intent(this, FormularioEmpleado.class);
        intent.putExtra("listaEmpleado",this.listaEmpleado);
        startActivity(intent);
    }

    private void muestraPersonas(){
        //TODO1: Validar si hay personas registradas
        if(this.listaEmpleado.isEmpty())
            txtLista.setText("No hay personas registradas");
        String _listaEmpleado = "";
        for(Empleado _empleado : this.listaEmpleado){
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
        String _coincidencias = "";
        return _coincidencias;
    }
}
