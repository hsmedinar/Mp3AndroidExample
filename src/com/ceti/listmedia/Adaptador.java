package com.ceti.listmedia;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {
	
	Context context;
	ArrayList<Cancion> canciones;	
	
	public Adaptador(Context context,ArrayList<Cancion> canciones) {
		this.context=context;
		this.canciones=canciones;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return canciones.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return canciones.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub		
		return  position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			LayoutInflater layout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layout.inflate(R.layout.fila, parent, false);
		}
		
		TextView nombre = (TextView) convertView.findViewById(R.id.nombre_cancion);
		TextView artista = (TextView) convertView.findViewById(R.id.nombre_artista);
		
		Cancion c = (Cancion) canciones.get(position);
		
		nombre.setText(c.getTitle());
		
		artista.setText(c.getArtist());
		
		return convertView;
		
	}

}
