/*
 * @Author	:	Nana O. Baah
 * @Project	:	Rent and Energy Reminder
 * @Date	:	9-Nov-2016
 */

package com.epages.bills;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CSVFileWriter {

	private CSVWriter csvWriter;

	public CSVFileWriter(FileWriter fileName) {
		this.csvWriter = new CSVWriter(fileName, ',');
	}

	public void writeToFile(Iterable<String[]> data) {
		csvWriter.writeAll(data);
	}

	public void closeWriter() throws IOException {
		csvWriter.close();
	}

}
