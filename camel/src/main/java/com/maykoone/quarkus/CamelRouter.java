package com.maykoone.quarkus;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

@ApplicationScoped
public class CamelRouter extends EndpointRouteBuilder {

	@Override
	public void configure() throws Exception {
        from(platformHttp("/hello/camel").httpMethodRestrict("GET"))
            .setBody(simple("Hello Camel"))
            .throttle(1).timePeriodMillis(100)
            .to(log("Hello Camel"));
		
	}
    
}