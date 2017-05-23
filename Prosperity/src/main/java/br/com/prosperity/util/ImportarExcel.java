package br.com.prosperity.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.prosperity.bean.ComparativoPropostaBean;
import br.com.prosperity.bean.PropostaBean;

public class ImportarExcel {

	public PropostaBean importarExcel(String caminho) {
		PropostaBean propostaBean = new PropostaBean();
		List<ComparativoPropostaBean> comparativosPropostaBean = new ArrayList<ComparativoPropostaBean>();
		try {
			FileInputStream file = new FileInputStream(new File(caminho));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);

			CellReference cellReference = new CellReference("B3");
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorEmpresa(cell.getStringCellValue());

			cellReference = new CellReference("B4");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorCargo(cell.getStringCellValue());

			cellReference = new CellReference("B5");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorSalarioFixoBruto(cell.getNumericCellValue());

			cellReference = new CellReference("B6");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorSalarioLiquidoMensal(cell.getNumericCellValue());

			cellReference = new CellReference("B7");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorVrMensal(cell.getNumericCellValue());

			cellReference = new CellReference("B8");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorVaMensal(cell.getNumericCellValue());

			cellReference = new CellReference("B9");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorSeguroSaudeMensal(cell.getNumericCellValue());

			cellReference = new CellReference("B10");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorValeAuto(cell.getNumericCellValue());

			cellReference = new CellReference("B11");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorEstacionamento(cell.getNumericCellValue());

			cellReference = new CellReference("B12");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorValeTransporte(cell.getNumericCellValue());

			cellReference = new CellReference("B13");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorLiquidoComBeneficios(cell.getNumericCellValue());

			cellReference = new CellReference("B14");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorAnualLiquido(cell.getNumericCellValue());

			cellReference = new CellReference("B15");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorParticipacaoLucrosOuBonus(cell.getNumericCellValue());

			cellReference = new CellReference("B16");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setAnteriorTotalAnualLiquidoComBeneficios(cell.getNumericCellValue());

			cellReference = new CellReference("E3");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovaEmpresa(cell.getStringCellValue());

			cellReference = new CellReference("E4");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoCargo(cell.getStringCellValue());

			cellReference = new CellReference("E5");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoSalarioFixoBruto(cell.getNumericCellValue());

			cellReference = new CellReference("E6");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoSalarioLiquidoMensal(cell.getNumericCellValue());

			cellReference = new CellReference("E7");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoVrMensal(cell.getNumericCellValue());

			cellReference = new CellReference("E8");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoVaMensal(cell.getNumericCellValue());

			cellReference = new CellReference("E9");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoSeguroSaudeMensal(cell.getNumericCellValue());

			cellReference = new CellReference("E10");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoValeAuto(cell.getNumericCellValue());

			cellReference = new CellReference("E11");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoEstacionamento(cell.getNumericCellValue());

			cellReference = new CellReference("E12");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoValeTransporte(cell.getNumericCellValue());

			cellReference = new CellReference("E13");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoLiquidoComBeneficios(cell.getNumericCellValue());

			cellReference = new CellReference("E14");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoAnualLiquido(cell.getNumericCellValue());

			cellReference = new CellReference("E15");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovaParticipacaoLucrosOuBonus(cell.getNumericCellValue());

			cellReference = new CellReference("E16");
			row = sheet.getRow(cellReference.getRow());
			cell = row.getCell(cellReference.getCol());
			propostaBean.setNovoTotalAnualLiquidoComBeneficios(cell.getNumericCellValue());

			int aux = 22;
			boolean continuar = false;

			while (!continuar) {
				cellReference = new CellReference("A" + aux);
				row = sheet.getRow(cellReference.getRow());
				// cell = row.getCell(cellReference.getCol());
				if (row != null) {
					ComparativoPropostaBean comparativoPropostaBean = new ComparativoPropostaBean();

					cellReference = new CellReference("A" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setNmFuncionario(cell.getStringCellValue());

					cellReference = new CellReference("B" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setNmCargo(cell.getStringCellValue());

					cellReference = new CellReference("C" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setNmSenioridade(cell.getStringCellValue());

					cellReference = new CellReference("D" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setDsConhecimento(cell.getStringCellValue());

					cellReference = new CellReference("E" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());

					// formatar data
					Date dataNaoFormatada = cell.getDateCellValue();
					DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
					String dataFormatada = formatar.format(dataNaoFormatada);

					comparativoPropostaBean.setDtAdmissao(formatar.parse(dataFormatada));
					System.out.println(comparativoPropostaBean.getDtAdmissao().toString());

					cellReference = new CellReference("F" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrSalario(cell.getNumericCellValue());

					cellReference = new CellReference("G" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrVr(cell.getNumericCellValue());

					cellReference = new CellReference("H" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrVa(cell.getNumericCellValue());

					cellReference = new CellReference("I" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrEstacionamento(cell.getNumericCellValue());

					cellReference = new CellReference("J" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrCombustivel(cell.getNumericCellValue());

					cellReference = new CellReference("K" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrAssistenciaMedica(cell.getNumericCellValue());

					cellReference = new CellReference("L" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrOutros(cell.getNumericCellValue());

					cellReference = new CellReference("M" + aux);
					row = sheet.getRow(cellReference.getRow());
					cell = row.getCell(cellReference.getCol());
					comparativoPropostaBean.setVlrTaxa(cell.getNumericCellValue());

					comparativosPropostaBean.add(comparativoPropostaBean);
					aux++;
				} else {
					continuar = true;
				}
			}
			propostaBean.setComparativoProposta(comparativosPropostaBean);

			file.close();
			FileOutputStream out = new FileOutputStream(new File(caminho));
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return propostaBean;
	}
}