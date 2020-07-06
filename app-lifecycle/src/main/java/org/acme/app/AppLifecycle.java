package org.acme.app;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class AppLifecycle {
    
    void onStart(@Observes StartupEvent ev) {
        Logger.getLogger(AppLifecycle.class).info("Capturing startup event.");
    }

    void onStop(@Observes ShutdownEvent ev) {
        Logger.getLogger(AppLifecycle.class).info("Capturing shutdown event.");
    }
}