package br.com.prosperity.util;

import org.apache.commons.codec.binary.Base64;

public class EncriptaDecriptaApacheCodec {
	/**
	 * Codifica string na base 64 (Encoder)
	 */
	public String codificaBase64Encoder(String msg) {
		return new Base64().encodeToString(msg.getBytes());
	}

	/**
	 * Decodifica string na base 64 (Decoder)
	 */
	public String decodificaBase64Decoder(String msg) {
		return new String(new Base64().decode(msg));
	}
}
