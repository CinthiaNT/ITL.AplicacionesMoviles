package com.example.automoviles;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private final String BASEURL = "http://192.168.137.1:8000/api/automovils/";
    private EditText txtId, txtMarca,txtModelo,txtColor,txtCarroceria;
    private Button btnSearch, btnCreate, btnUpdate, btnDelete;
    private Context ctx;
    private StringRequest strq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;
        requestQueue = Volley.newRequestQueue(ctx);

        txtId= (EditText) findViewById(R.id.txtId);
        txtModelo = (EditText) findViewById(R.id.txtModelo);
        txtMarca = (EditText) findViewById(R.id.txtMarca);
        txtColor = (EditText) findViewById(R.id.txtColor);
        txtCarroceria = (EditText) findViewById(R.id.txtCarroceria);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });
       /*btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });*/
    }
    private void create(){
        strq = new StringRequest(Request.Method.POST, BASEURL+"insertar",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Alumno agregado exitosamente", Toast.LENGTH_LONG).show();
                        leerDatos(response);
                    }
                },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Insert failed", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("modelo", txtModelo.getText().toString());
                parametros.put("marca", txtMarca.getText().toString());
                parametros.put("color", txtColor.getText().toString());
                parametros.put("carroceria", txtCarroceria.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);
    }
    public void leerDatos(String res){
        try {
            JSONArray jsonArray = new JSONArray(res);
            //JSONObject jsonObject = new JSONObject(res);

            /*String success = jsonObject.get("success").toString();
            String result = jsonObject.get("result").toString();
            String errors = jsonObject.get("errors").toString();*/

            for(int i = 0, e = jsonArray.length(); i < e; i++){
                JSONObject automovil = (JSONObject) jsonArray.get(i);
                String modelo = automovil.get("modelo").toString();
                String marca = automovil.get("marca").toString();
                String color = automovil.get("color").toString();
                String carroceria = automovil.get("carroceria").toString();

                Automovil cat = new Automovil(
                        Integer.parseInt(automovil.get("id").toString()),
                        (String) automovil.get("modelo"),
                        (String) automovil.get("marca"),
                        (String) automovil.get("color"),
                        (String) automovil.get("carroceria")
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
