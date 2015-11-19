package com.ceti.listmedia;

public class Cancion {
	
	String ID;
	String ARTIST;
	String TITLE;
	String DATA;
	String DISPLAY_NAME;
	String DURATION;
	float ALBUM_ID;
	
	Cancion(){
		ID="";
		ARTIST="";
		TITLE="";
		DATA="";
		DISPLAY_NAME="";
		DURATION="";
		ALBUM_ID=0;
	}
		
    public String getId() {
        return ID;
    }

    public String getArtist() {
        return ARTIST;
    }

    public String getTitle() {
        return TITLE;
    }

    public String getData() {
        return DATA;
    }

    public String getDisplay() {
        return DISPLAY_NAME;
    }

    public String getDuration() {
        return DURATION;
    }

    public float getAlbum() {
        return ALBUM_ID;
    }

    public void setId(String id) {
        this.ID = id;
    }
    
    public void setArtist(String artist) {
    	this.ARTIST = artist;
    }

    public void setTitle(String title) {
        this.TITLE = title;
    }

    public void setData(String data) {
        this.DATA = data;
    }

    public void setDisplayName(String display) {
        this.DISPLAY_NAME = display;
    }

    public void setDuration(String duration) {
        this.DURATION = duration;
    }

    public void setAlbumId(float albumid) {
        this.ALBUM_ID = albumid;
    }
	
}
