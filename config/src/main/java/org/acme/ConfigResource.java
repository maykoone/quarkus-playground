package org.acme;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/config")
public class ConfigResource {

    @ConfigProperty(name = "message.greeting")
    String greeting;

    @ConfigProperty(name = "message.datetimeformat", defaultValue = "dd-MM-yyyy HH:mm")
    String dateTimeFormat;

    @ConfigProperty(name = "city.name")
    Optional<String> cityName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greeting + " Current Date and Time in " + cityName.orElse("unknown") + " is " + new SimpleDateFormat(dateTimeFormat).format(new Date());
    }
}