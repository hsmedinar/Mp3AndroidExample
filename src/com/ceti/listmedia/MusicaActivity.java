package com.ceti.listmedia;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MusicaActivity extends Activity {

	Cursor cursor;	
	ArrayList<Cancion> listcanciones = new ArrayList<Cancion>();
	ListView lista;	
	Adaptador adaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.lista_canciones);				
		lista = (ListView) findViewById(R.id.lista);
		
	    String[] columnas = {
	            MediaStore.Audio.Media._ID,
	            MediaStore.Audio.Media.ARTIST,
	            MediaStore.Audio.Media.TITLE,
	            MediaStore.Audio.Media.DATA,
	            MediaStore.Audio.Media.DISPLAY_NAME,
	            MediaStore.Audio.Media.DURATION,
	            MediaStore.Audio.Media.ALBUM_ID	            
	   };
	    
	   cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,// donde buscar
	    				columnas, // las columnas a regresar
	    				null, // el condicional
	    				null, // valores del condicional 
	    				null); // ordernar por


	    while(cursor.moveToNext()){
	    	
	    	    Cancion c = new Cancion();
	    	    
	    	    c.setId(cursor.getString(0));
	    	    c.setArtist(cursor.getString(1));
	    	    c.setTitle(cursor.getString(2));
	    	    c.setData(cursor.getString(3));
	    	    c.setDisplayName(cursor.getString(4));
	    	    c.setDuration(cursor.getString(5));
	    	    c.setAlbumId(cursor.getFloat(6));	    	    
	    	    
	    	    listcanciones.add(c);
	    }
	    	    
	    adaptador = new Adaptador(this, listcanciones);
	    
	    lista.setAdapter(adaptador);
	    
	    lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int posicion,
					long arg3) {
				// TODO Auto-generated method stub				
				Cancion c = (Cancion) listcanciones.get(posicion);	
				
				Intent intent = new Intent(MusicaActivity.this, Mp3.class);				
				intent.putExtra("cancion", c.getData());				
				startActivity(intent);								

			}
		});
	               
	}
}
