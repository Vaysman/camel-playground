package playground.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BackCamel extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("netty4-http")
                .port(8082)
                .host("0.0.0.0")
                .dataFormatProperty("prettyPrint", "true")
        ;

        from("netty4-http:http://0.0.0.0:8082/backend")
                .transform().simple("<h1>hello!</h1>")
//                .get("/backend")
//                .responseMessage().code(200).message("<h1>hello!</h1>")
        ;
    }
}
