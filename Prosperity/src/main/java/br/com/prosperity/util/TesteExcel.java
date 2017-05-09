package br.com.prosperity.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TesteExcel {

	public void testa(Workbook caminho) {
		Double b;
		try {
			FileInputStream file = new FileInputStream(
					new File("C:\\Users\\guilherme.oliveira\\Documents\\teste.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook((OPCPackage) caminho);

			XSSFSheet sheet = workbook.getSheetAt(0);
			CellReference cellReference = new CellReference("A1");
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);

			cellReference = new CellReference("C1");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);

			/*
			 * Iterator<Row> rowIterator = sheet.iterator();
			 * 
			 * while (rowIterator.hasNext()) { Row row = rowIterator.next();
			 * 
			 * // For each row, iterate through each columns Iterator<Cell>
			 * cellIterator = row.cellIterator(); while (cellIterator.hasNext())
			 * {
			 * 
			 * Cell cell = cellIterator.next();
			 * 
			 * switch (cell.getCellType()) { case Cell.CELL_TYPE_BOOLEAN:
			 * System.out.print(cell.getBooleanCellValue() + "\t\t"); break;
			 * case Cell.CELL_TYPE_NUMERIC:
			 * System.out.print(cell.getNumericCellValue() + "\t\t"); break;
			 * case Cell.CELL_TYPE_STRING:
			 * System.out.print(cell.getStringCellValue() + "\t\t"); break; } }
			 * System.out.println(""); }
			 */
			file.close();
			FileOutputStream out = new FileOutputStream(
					new File("C:\\Users\\guilherme.oliveira\\Documents\\teste.xlsx"));
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
