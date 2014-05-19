package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bad.EventHandler;

public class ProfileListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {
		EventHandler.displayOpenProfileDialog();
	}

}
