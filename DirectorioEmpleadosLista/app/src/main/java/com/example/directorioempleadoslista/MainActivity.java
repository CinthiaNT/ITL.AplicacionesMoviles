package com.example.directorioempleadoslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText txtEmpleado;
    public TextView txtLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLista = (TextView) findViewById(R.id.txtApellidoP);

    }
    public void agregarEmpleado(View view){
        Intent intent = new Intent(this, FormularioEmpleado.class);
        startActivity(intent);
        Empleado empl = (Empleado) getIntent().getExtras().getSerializable("empleadoKey");
        String lista = "Nombre(s): " + empl.nombre + empl.apellidoP + empl.apellidoM +
                "   Nomina" + empl.numNomina +
                "   Telefono" + empl.telefono;
        txtEmpleado.setText(lista);
    }
}
