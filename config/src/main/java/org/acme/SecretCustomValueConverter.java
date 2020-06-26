package org.acme;

import java.util.Base64;

import org.eclipse.microprofile.config.spi.Converter;

public class SecretCustomValueConverter implements Converter<SecretCustomValue> {

	@Override
	public SecretCustomValue convert(String value) {
		return new SecretCustomValue(new String(Base64.getDecoder().decode(value)));
	}
    
}