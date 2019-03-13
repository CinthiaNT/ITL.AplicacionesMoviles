package com.example.directorioempleadoslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FormularioEmpleado extends AppCompatActivity {
    private EditText txtNombre,txtApellidoP,txtApellidoM,txtNomina,txtTelefono;
    public Empleado empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_empleado);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoP = (EditText) findViewById(R.id.txtApellidoP);
        txtApellidoM = (EditText) findViewById(R.id.txtApellidoM);
        txtNomina = (EditText) findViewById(R.id.txtNomina);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
    }

    public void enviarEmpleado(View view){
        empleado = new Empleado(txtNombre.getText().toString(),txtApellidoP.getText().toString(),
                txtApellidoM.getText().toString(),Integer.parseInt(txtNomina.getText().toString()),
                txtTelefono.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("empleadoKey", empleado);
        startActivity(intent);
    }
}
