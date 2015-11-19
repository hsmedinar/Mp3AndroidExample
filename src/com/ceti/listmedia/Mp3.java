package com.ceti.listmedia;



import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Mp3 extends Activity implements OnClickListener {
	
	private static MediaPlayer media=null;	
	
	Button btn_play;
	Button btn_stop;
	Button btn_pause;
	Button btn_ade;
	Button btn_ret;		
	String data;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mp3);
		
		btn_play = (Button) findViewById(R.id.playm);
		btn_stop = (Button) findViewById(R.id.stopm);
		btn_pause = (Button) findViewById(R.id.pausem);
		btn_ade = (Button) findViewById(R.id.adelante);
		btn_ret = (Button) findViewById(R.id.retro);	
		
		btn_play.setOnClickListener(this);
		btn_stop.setOnClickListener(this);
		btn_pause.setOnClickListener(this);
		btn_ade.setOnClickListener(this);
		btn_ret.setOnClickListener(this);	
		
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.playm:
				play(data);
				break;
			case R.id.stopm:
				stop();
				break;
			case R.id.pausem:
				 pause();
				break;
			case R.id.adelante:
				adelantar();
				break;
			case R.id.retro:
				retroceder();
				break;		
		}		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Bundle v = getIntent().getExtras();

	    if(v!=null){
	    	data = v.getString("cancion");	    		    	
	    	//Toast.makeText(this, data, Toast.LENGTH_LONG).show();	 	    	
	    	if(media==null){
	    		Toast.makeText(this, "is null", Toast.LENGTH_SHORT).show();
	    		play(data);
	    	}else{
	    		stop();
	    		play(data);
	    	}	    
	    }	
	    
	    
	}
	

	
	private void play(String path){
		try {
			
			if(media==null){		      
				media = new MediaPlayer();
				media.setAudioStreamType(AudioManager.STREAM_MUSIC);
				media.setDataSource(path);
				media.prepare();				
			}	
			
			media.start();			

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	private void pause(){
		if(media!=null)
			media.pause();
		
	}
	
	private void stop(){
		if(media!=null){
			media.stop();
			media.release();
			media = null;				
		}
	}	
	
	private void adelantar(){
		int valor = media.getCurrentPosition() + 3000;
		
		if (valor<=media.getDuration())
			media.seekTo(valor);
		
	}

	private void retroceder(){
		int valor = media.getCurrentPosition() - 3000;
		if (valor>=0){
			media.seekTo(valor);
		}
	}
}
