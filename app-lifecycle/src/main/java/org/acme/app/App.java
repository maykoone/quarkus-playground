package org.acme.app;

import org.jboss.logging.Logger;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

public class App implements QuarkusApplication {

    private static final Logger LOG = Logger.getLogger(App.class);

	@Override
	public int run(String... args) throws Exception {
        LOG.info("App running!");
        Quarkus.waitForExit();
		return 0;
	}
    
}