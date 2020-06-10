package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

/**
 * grouping properties using interface style
 */
@ConfigProperties
public interface FooConfiguration {
    @ConfigProperty(name = "some-text")
    String someText();

    Integer getSomeValue();

}