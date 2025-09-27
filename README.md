A silly application demonstrating rest filters. 

# Demo flow 

Tidy up live-coded classes. 

```shell script
./prep-demo
```

Start Quarkus 

```shell script
./mvnw quarkus:dev
```

Visit http://localhost:8080

Follow the link to the `/hello` endpoint.

Add a `Filter` class:

```java
public class Filter {
    @ServerResponseFilter
    public void getFilter(ContainerResponseContext responseContext) {
        Object entity = responseContext.getEntity();
        if(entity instanceof String) {
            responseContext.setEntity(translate((String)entity));
        }
    }
}
```

The class could also be added by an extension. 

Experiment with various responses from `GreetingResource`, and also with re-running the tests using `r`.