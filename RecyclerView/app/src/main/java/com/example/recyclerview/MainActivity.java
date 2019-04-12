package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Model.Message;
import adapters.RVMessageAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RVMessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Message> messages = new ArrayList<>();

        //Añadimos objetos de tipo "Message" a la lista
        messages.add(new Message("Juan Jose", "Examen", "Aqui esta mi examen profesor", "12:00 PM"));
        messages.add(new Message("Juda", "Checar errores", "Porfavor checa los errores del codigo", "14:00 PM"));
        messages.add(new Message("Juan Jose", "Examen", "Aqui esta mi examen profesor", "12:00 PM"));
        messages.add(new Message("Juda", "Checar errores", "Porfavor checa los errores del codigo", "14:00 PM"));
        messages.add(new Message("Juan Jose", "Examen", "Aqui esta mi examen profesor", "12:00 PM"));
        messages.add(new Message("Juda", "Checar errores", "Porfavor checa los errores del codigo", "14:00 PM"));

        //Instanciamos la vista del recycler view
        recyclerView = findViewById(R.id.rv_messages);

        //Instanciamos el adapter, poniendole como contexto esta activity y asignadole como lista los mensajes anteriores
        adapter = new RVMessageAdapter(this,messages);

        //Asignamos el adapter al recyclerview
        recyclerView.setAdapter(adapter);

        //Asignamos el tipo de layout que queramos a nuestro recyclerview, linear, o cuadricula
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));*/

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }
}