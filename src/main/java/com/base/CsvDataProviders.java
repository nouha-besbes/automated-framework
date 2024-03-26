package com.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class CsvDataProviders {

	@DataProvider(name = "csvReader")
	public Iterator<Object[]> csvReader(Method method) {

		String pathname = csvFilePathName(method);
		File file = new File(pathname);
		List<Object[]> resultList = new ArrayList<Object[]>();
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					resultList.add(new Object[] { testData });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
		}

		return resultList.iterator();
	}

	private String csvFilePathName(Method method) {
		String pathname = "src".concat(File.separator).concat("test").concat(File.separator).concat("resources")
				.concat(File.separator).concat("dataproviders").concat(File.separator)
				.concat(method.getDeclaringClass().getSimpleName()).concat(File.separator).concat(method.getName())
				.concat(".csv");
		return pathname;
	}
}
