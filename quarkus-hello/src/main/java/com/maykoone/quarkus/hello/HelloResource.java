package com.maykoone.quarkus.hello;

import java.text.DateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class HelloResource {

    @ConfigProperty(name = "grettings.message")
    String message;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message + ". Today is " + DateFormat.getDateTimeInstance().format(new Date()) + ". Node: " + System.getenv().getOrDefault("HOSTNAME", "unknown");
    }
}