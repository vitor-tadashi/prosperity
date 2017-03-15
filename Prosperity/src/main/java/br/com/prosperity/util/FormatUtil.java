package br.com.prosperity.util;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class FormatUtil {

	public static String formatCPF(String input) {

		String bloco1 = input.substring(0, 3);
		String bloco2 = input.substring(3, 6);
		String bloco3 = input.substring(6, 9);
		String bloco4 = input.substring(9, 11);

		return String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4);
	}

	public static String formatRG(String input) {

		String bloco1 = input.substring(0, 2);
		String bloco2 = input.substring(2, 5);
		String bloco3 = input.substring(5, 8);
		String bloco4 = input.substring(8, 9);

		return String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4);
	}

	public static String formatPhone(String input) {
		if (input != null) {
			MaskFormatter format = null;
			try {
				format = new MaskFormatter("#####-####");
				input = format.getPlaceholder();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return input;
		}
		return input;
	}
}
