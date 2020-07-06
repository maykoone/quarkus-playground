package org.acme.app;

import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

import org.jboss.logging.Logger;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Logger.getLogger(Main.class).info("Its running!!");
        Quarkus.run(App.class, args);
    }
}