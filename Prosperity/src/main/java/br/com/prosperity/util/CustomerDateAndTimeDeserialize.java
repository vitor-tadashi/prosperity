package br.com.prosperity.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

// Classe customizada para parsear as datas:
public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
			throws IOException, JsonProcessingException {
		String str = paramJsonParser.getText().trim();

		// o Json vem com essas chaves em volta das datas:
		// Removo-as:
		str = str.replace("{", "");
		str = str.replace("}", "");

		if (str.equals("")) {
			return null;
		}

		try {
			return dateFormat.parse(str);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return paramDeserializationContext.parseDate(str);
	}
}
