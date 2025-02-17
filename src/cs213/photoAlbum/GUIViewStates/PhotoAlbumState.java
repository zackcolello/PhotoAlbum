package cs213.photoAlbum.GUIViewStates;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

/**
 * 
 * @author Anna Genke
 *
 */
public abstract class PhotoAlbumState {

	//Enter the state
	abstract void enter();
	
	//Store last event that occurred
	static ActionEvent lastEvent;
	
	//Process last event to determine next state
	abstract PhotoAlbumState processEvent();
	
}
