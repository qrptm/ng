package com.inetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.inetBankingV1.testData.Credential;

public class FileUtility {

	public static Credential getData() {
		Credential credential = new Credential();
		try {
			FileInputStream file = new FileInputStream(new File(
					"D:\\eclipse\\test\\inetBankingV1\\src\\test\\java\\com\\inetBankingV1\\testData\\data.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					credential.setUrl(cellIterator.next().getStringCellValue());
					credential.setUsername(cellIterator.next().getStringCellValue());
					credential.setPassword(cellIterator.next().getStringCellValue());

					// Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
//					switch (cell.getCellType()) {
//					case Cell:
//						System.out.print(cell.getNumericCellValue() + "t");
//						break;
//					case Cell.CELL_TYPE_STRING:
					// System.out.print(cell.getStringCellValue() + " ");
//						break;
//					}
				}
				System.out.println("");
			}
			workbook.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credential;
	}

	public static void main(String args[]) {
		System.out.println(getData());
	}
}
