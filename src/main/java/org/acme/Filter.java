package org.acme;

import jakarta.ws.rs.container.ContainerResponseContext;
import org.jboss.resteasy.reactive.server.ServerResponseFilter;

import static org.acme.support.Translator.translate;

public class Filter {
    @ServerResponseFilter
    public void getFilter(ContainerResponseContext responseContext) {
        Object entity = responseContext.getEntity();
        if (entity instanceof String s) {
            responseContext.setEntity(translate(s));
        }
    }
}