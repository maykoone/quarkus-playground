package org.acme;

public class SecretCustomValue {
    
    private final String value;

	public SecretCustomValue(String value) {
		this.value = value;
	}

    public String getValue() {
        return value;
    }
}