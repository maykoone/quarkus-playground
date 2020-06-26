package org.acme;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/config")
public class ConfigResource {

    @ConfigProperty(name = "message.greeting")
    String greeting;

    @ConfigProperty(name = "message.datetimeformat", defaultValue = "dd-MM-yyyy HH:mm")
    String dateTimeFormat;

    @ConfigProperty(name = "city.name")
    Optional<String> cityName;

    @Inject
    DatabaseConfiguration databaseConfiguration;

    @Inject
    FooConfiguration fooConfiguration;

    @ConfigProperty(name = "myapp.secret")
    SecretCustomValue secret;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greeting + " Current Date and Time in " + cityName.orElse("unknown") + " is " + new SimpleDateFormat(dateTimeFormat).format(new Date());
    }

    @GET
    @Path("title")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTitle() {
        return ConfigProvider.getConfig().getValue("title", String.class);
    }

    @GET
    @Path("database")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDatabaseConfig() {
        return String.format("dbname=%s,user=%s,password=%s", 
            databaseConfiguration.getName(), databaseConfiguration.getUser(), databaseConfiguration.getPassword());
    }

    @GET
    @Path("foo")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFoo() {
        return String.format("foo.some-text=%s,foo.some-value=%d", 
            fooConfiguration.someText(), fooConfiguration.getSomeValue());
    }

    @GET
    @Path("secret")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSecret() {
        return String.format("myapp.secret=%s", secret.getValue());
    }
}