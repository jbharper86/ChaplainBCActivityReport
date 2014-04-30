package listener;

import ui.ActivityForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ActivityFormListener implements PropertyChangeListener, ActionListener {

	private ActivityForm activityForm;

	public ActivityFormListener(ActivityForm activityForm) {
		super();
		this.activityForm = activityForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		change();
	}

	private void change() {
		activityForm.setTotalFields();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		change();
	}
}
