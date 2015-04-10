package cs213.photoAlbum.GUIViewStates;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class MenuBarPanel extends JPanel{

	JButton logoutButton = new JButton("Logout");
	JButton backButton = new JButton("Back");
	
	public MenuBarPanel(){
	}
	
	public JPanel CreateMenuBarPanel(String location) {

		JPanel MenuBar = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		MenuBar.setLayout(gbl);

		//Add back button
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		MenuBar.add(backButton);
		
		//Add white space
		JPanel whiteSpacePanel = new JPanel();
		//whiteSpacePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		whiteSpacePanel.setPreferredSize(new Dimension(275, 2));
		whiteSpacePanel.setVisible(true);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = .3;
		MenuBar.add(whiteSpacePanel, gbc);

		JLabel locationLabel = new JLabel();
		locationLabel.setText(location);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 0;

		MenuBar.add(locationLabel, gbc);

		String[] searchType = { "Search:", "By Date", "By Tag" };
		JComboBox<String> searchBox = new JComboBox<String>(searchType);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 3;
		gbc.gridy = 0;

		MenuBar.add(searchBox, gbc);
		MenuBar.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 4;
		gbc.gridy = 0;

		MenuBar.add(logoutButton, gbc);

		//Do not want a back button for the first album screen
		if(location.equals("Albums")){
			backButton.setVisible(false);
		}
		
		// Event listeners for buttons
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				PhotoAlbumStore.login1State.enter();
				//processEvent();
				
			}
		});

		return MenuBar;

	}

	public PhotoAlbumState processEvent() {

		if (logoutButton.getText().equals("logout")) {

			PhotoAlbumStore.login1State.enter();
			return PhotoAlbumStore.login1State;
		}

		return null;
	}

}
