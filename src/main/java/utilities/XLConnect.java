package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XLConnect {
	// Function to fetch values as an 2 dimensional array only from XLS file

	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {
				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

//	This function
//	fetches values
//	as two
//	dimensional array
//	from XLSX files

//	public static String[][] getXLSXData1(String fileName, String sheetName) {
//		String[][] arrayExcelData = null;
//		String cellValue = null;
//
//		try {
//			FileInputStream file = new FileInputStream(new File(fileName));
//			XSSFWorkbook wrkbk = new XSSFWorkbook(file);
//			XSSFSheet sheet = wrkbk.getSheet(sheetName);
//
//			int totalNoOfRows = sheet.getPhysicalNumberOfRows();
//			int totalNoOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
//
//			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
//			for (int i = 1; i < totalNoOfRows; i++) {
//				Row rw = sheet.getRow(i);
//				// System.out.println("Row Data Value"+rw);
//				for (int j = 0; j < totalNoOfCols; j++) {
//					Cell cl = rw.getCell(j);
//					// System.out.println("cell data value"+cl);
//
//					if (cl != null) {
//
//						switch (cl.getCellType()) {
//						case Cell.CELL_TYPE_NUMERIC:
//							cellValue = Integer.toString((int) cl.getNumericCellValue());
//							break;
//						case Cell.CELL_TYPE_STRING:
//							cellValue = cl.getStringCellValue();
//							break;
//						}
//					}
//
//					arrayExcelData[i - 1][j] = cellValue.toString();
//				}
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("Unable to Work with specified XL File");
//			cellValue = null;
//			e.printStackTrace();
//		} catch (IOException e) {
//			cellValue = null;
//			e.printStackTrace();
//			e.printStackTrace();
//		}
//		return arrayExcelData;
//	}

	// This function fetches values as two dimensional array from XLSX files
	public static String[][] getXLSXData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		String cellValue = null;
		String value = "sand";
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			XSSFWorkbook wrkbk = new XSSFWorkbook(file);
			XSSFSheet sheet = wrkbk.getSheet(sheetName);

			int totalNoOfRows = sheet.getPhysicalNumberOfRows();
			int totalNoOfCols = sheet.getRow(0).getPhysicalNumberOfCells();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
			for (int i = 1; i < totalNoOfRows; i++) {
				Row rw = sheet.getRow(i);
				// System.out.println(rw);
				// Code for check the value
				Cell cl = rw.getCell(0);

				String cvalue = cl.getStringCellValue();
				// System.out.println(cvalue);

				if (!value.equalsIgnoreCase(cvalue)) {

					continue;
				} else {
					// Ends Here

					for (int j = 0; j < totalNoOfCols; j++) {
						cl = rw.getCell(j);
						// System.out.println("Cl value: " + cl);
						if (cl != null) {
							switch (cl.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								cellValue = Integer.toString((int) cl.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_STRING:
								cellValue = cl.getStringCellValue();
								break;
							}

						}

						arrayExcelData[i - 1][j] = cellValue.toString();

						// if u want remove a[0][0]
						// arrayExcelData[i-1][j-1]

					}

					// ENd of Else Condtion
				}
				// Ends here

			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to Work with specified XL File");
			cellValue = null;
			e.printStackTrace();
		} catch (IOException e) {
			cellValue = null;
			e.printStackTrace();

			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public static String[][] getPatientDetailsForSearch(String filePath, String sheetName) throws IOException {
		String[][] data = null;

		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook wrkbk = new XSSFWorkbook(file);
		XSSFSheet sheet = wrkbk.getSheet(sheetName);

		int totalNoOfRows = sheet.getPhysicalNumberOfRows();
		data = new String[totalNoOfRows - 1][2];

		for (int i = 1; i < totalNoOfRows; i++) {
			for (int j = 2; j < 4; j++) {
				data[i - 1][j - 2] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		wrkbk.close();
		return data;
	}

	public static String[][] getData(String filePath, String sheetName) {
		String[][] data = null;

		FileInputStream file;
		XSSFWorkbook wrkbk = null;
		XSSFSheet sheet = null;
		try {
			file = new FileInputStream(new File(filePath));
			wrkbk = new XSSFWorkbook(file);
			sheet = wrkbk.getSheet(sheetName);
			int totalNoOfRows = sheet.getPhysicalNumberOfRows();
			int totalNoOfCols = sheet.getRow(0).getPhysicalNumberOfCells();

			data = new String[totalNoOfRows - 1][totalNoOfCols];
			for (int i = 1; i < totalNoOfRows; i++) {
				Row rw = sheet.getRow(i);
				for (int j = 0; j < totalNoOfCols; j++) {
					Cell cell = rw.getCell(j);
					if (cell != null)
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							data[i - 1][j] = cell.getStringCellValue();
						} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
							data[i - 1][j] = Boolean.toString(cell.getBooleanCellValue());
						} else {
							data[i - 1][j] = Double.toString(cell.getNumericCellValue());
						}
					else
						data[i - 1][j] = null;
				}
			}
			wrkbk.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (wrkbk != null) {
				try {
					wrkbk.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return data;
	}

	/**
	 *
	 * @param filePath
	 * @param sheetName
	 * @param from      starting index of the file (included)
	 * @param to        upper bound of the file (excluded)
	 * @return two dimensional array of data
	 */
	public static Object[][] getXLSXData(String filePath, String sheetName, int from, int to) {
		String[][] data = null;

		FileInputStream file;
		XSSFWorkbook wrkbk = null;
		XSSFSheet sheet = null;
		try {
			file = new FileInputStream(new File(filePath));
			wrkbk = new XSSFWorkbook(file);
			sheet = wrkbk.getSheet(sheetName);
			int totalNoOfRows = sheet.getPhysicalNumberOfRows();

			data = new String[totalNoOfRows - 1][to];
			for (int i = 1; i < totalNoOfRows; i++) {
				Row rw = sheet.getRow(i);
				for (int j = 0; j < to; j++) {
					Cell cell = rw.getCell(j);
					if (cell != null)
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							data[i - 1][j] = cell.getStringCellValue();
						} else {
							data[i - 1][j] = Double.toString(cell.getNumericCellValue());
						}
					else
						data[i - 1][j] = null;
				}
			}
			wrkbk.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (wrkbk != null) {
				try {
					wrkbk.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return data;
	}
}