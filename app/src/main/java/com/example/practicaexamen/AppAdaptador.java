package com.example.practicaexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppAdaptador extends RecyclerView.Adapter<AppAdaptador.ViewHolder>{


    private List<Usuario> mData;
    private LayoutInflater mInflater;

    AppAdaptador(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_app_adaptador, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dni.setText(String.valueOf("\n" + "Id: " + mData.get(position).dni));
        holder.nombre.setText(String.valueOf("Nombre: " + mData.get(position).nombre));
        holder.sexo.setText(String.valueOf("Hombre: " + mData.get(position).sexo));
        holder.direccion.setText(String.valueOf("Hombre: " + mData.get(position).direccion));
        holder.trabajo.setText(String.valueOf("Edad: " + mData.get(position).trabajo + "\n"));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(List<Usuario> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }

    Usuario getItem(int id) {
        return mData.get(id);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dni;
        TextView nombre;
        TextView sexo;
        TextView direccion;
        TextView trabajo;

        public ViewHolder(View itemView) {
            super(itemView);
            dni=itemView.findViewById(R.id.txtDni);
            nombre=itemView.findViewById(R.id.txtNombre);
            sexo=itemView.findViewById(R.id.txtSexo);
            direccion=itemView.findViewById(R.id.txtDireccion);
            trabajo=itemView.findViewById(R.id.txtTrabajo);
        }
    }
}
