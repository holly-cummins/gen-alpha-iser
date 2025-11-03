package org.acme;

import jakarta.ws.rs.container.ContainerResponseContext;

import static org.acme.support.Translator.translate;

public class Filter {
    public void getFilter(ContainerResponseContext responseContext) {
        Object entity = responseContext.getEntity();
        if (entity instanceof String) {
            responseContext.setEntity(translate((String) entity));
        }
    }
}