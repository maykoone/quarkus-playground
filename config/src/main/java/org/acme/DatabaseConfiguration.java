package org.acme;

import io.quarkus.arc.config.ConfigProperties;

/**
 * using configproperties to group properties.
 * Class following javabeans convention (getters and setters),
 * so no need to use ConfigProperty annotation
 */
@ConfigProperties(prefix = "database")
public class DatabaseConfiguration {
    private String name;
    private String user;
    private String password;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    
}