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

	public Double testa(String caminho) {
		Double b = null;
		try {
			FileInputStream file = new FileInputStream(
					new File(caminho));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);
			CellReference cellReference = new CellReference("B3");
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B4");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B5");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B6");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B7");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B8");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B9");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B10");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B11");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B12");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B13");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);

			cellReference = new CellReference("B14");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B15");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("B16");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E3");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E4");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E5");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E6");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E7");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E8");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E9");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E10");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E11");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E12");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E13");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);

			cellReference = new CellReference("E14");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E15");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			b = cell.getNumericCellValue();

			System.out.println(b);
			
			cellReference = new CellReference("E16");
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
					new File(caminho));
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
}
