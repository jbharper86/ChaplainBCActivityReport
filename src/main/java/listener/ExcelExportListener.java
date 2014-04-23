package listener;

import bad.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcelExportListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		EventHandler.excelExport();
	}
}
