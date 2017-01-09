/*
 * @Author	:	Nana O. Baah
 * @Project	:	Rent and Energy Reminder
 * @Date	:	9-Nov-2016
 */

package com.epages.bills;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;

public class MainController {

	private BillsReminder rent;
	private BillsReminder energy;
	private CSVFileWriter csvFile;
	private JFileChooser fileChooser;

	public MainController() {
		int monthValue = 0;
		rent = new BillsReminder();
		energy = new BillsReminder();
		fileChooser = new JFileChooser();

		rent.billsPaymentDates(-1, -2);
		energy.billsPaymentDates(10, 2);

		Iterator<Integer> itRent = rent.getPaymentList().iterator();
		Iterator<Integer> itEnergy = energy.getPaymentList().iterator();

		List<String[]> records = getHeaders();
		while (itRent.hasNext()) {
			records.add(new String[] { LocalDate.now().plusMonths(monthValue++).getMonth().toString(),
					itRent.next().toString(), itEnergy.next().toString() });
		}

		writeToExistingFile(records);
	}

	public List<String[]> getHeaders() {
		List<String[]> header = new ArrayList<String[]>();
		header.add(new String[] { "Month", "Pay Rent", "Pay Energy" });
		return header;
	}

	public void writeToExistingFile(List<String[]> records) {
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fileChooser);

		if (result == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getPath();

			try {
				csvFile = new CSVFileWriter(new FileWriter(filePath, false));
				csvFile.writeToFile(records);
				csvFile.closeWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
