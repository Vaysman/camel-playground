package playground.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("netty4-http")
                .port(8081)
                .host("0.0.0.0")
                .dataFormatProperty("prettyPrint", "true")
                ;

        rest()
                .get("/test")
                .to("netty4-http:http://0.0.0.0:8082/backend")
        ;
    }
}
