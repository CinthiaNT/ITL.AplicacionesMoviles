package com.example.directorioapp.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.directorioapp.Model.Empleado;

import com.example.directorioapp.R;
import java.util.List;

public class RVEmpleadoAdapter extends RecyclerView.Adapter<RVEmpleadoAdapter.RVEmpleadoAdapterViewHolder> {
    private Context context;
    private List<Empleado> empleados;

    //Constructor de adapter
    public RVEmpleadoAdapter(Context context, List<Empleado> empleados) {
        this.context = context;
        this.empleados = empleados;
    }

    //Creamos el item principal que se reciclara en cada uno de los elementos
    @NonNull
    @Override
    public RVEmpleadoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Inflamos nuestra vista de item
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_rv_empleado,
                viewGroup,
                false);
        //Retornamos una instancia del viewholder pasandole como parametro la vista anteriormente creada
        return new RVEmpleadoAdapterViewHolder(view);
    }
    //Se ejecutara por cada elemento de la lista
    @Override
    public void onBindViewHolder(@NonNull RVEmpleadoAdapterViewHolder rvEmpleadoAdapterViewHolder, int i) {
        //Creamos una instancia de tipo "Message" dependiendo del lugar de la lista en el que este
        final Empleado empleado = empleados.get(i);
        //Asignamos a las vistas del viewholder los textos del mensaje en esa posicion
        rvEmpleadoAdapterViewHolder.textViewName.setText(empleado.getNombre());
        rvEmpleadoAdapterViewHolder.textViewApellidoP.setText(empleado.getApellido_p());
        rvEmpleadoAdapterViewHolder.textViewApellidoM.setText(empleado.getApellido_m());
        rvEmpleadoAdapterViewHolder.textViewNomina.setText(empleado.getNo_nomnina());

        //Asignamos a ese item en particular un listener para cuando el usuario haga click en el
        rvEmpleadoAdapterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            //Aqui va codigo para ir a fragments
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle(empleado.getNombre());
                alertDialog.setMessage(empleado.getNo_nomnina());
                alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });
    }

    //Retornamos el tamaño de la lista
    @Override
    public int getItemCount() {
        return empleados.size();
    }

    public class RVEmpleadoAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName,textViewApellidoP,textViewApellidoM,textViewNomina;


        public RVEmpleadoAdapterViewHolder(View view) {
            super(view);
            //Instanciamos nuestros objetos que seran buscados segun si id en la vista pasada por el constructor
            textViewName = view.findViewById(R.id.lbl_empleado_nombre);
            textViewApellidoP = view.findViewById(R.id.lbl_empleado_apellidop);
            textViewApellidoM = view.findViewById(R.id.lbl_empleado_apellidom);
            textViewNomina = view.findViewById(R.id.lbl_empleado_nomina);
        }
    }
}
