package listener;

import bad.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddActivityListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		EventHandler.addActivity();
	}
}
