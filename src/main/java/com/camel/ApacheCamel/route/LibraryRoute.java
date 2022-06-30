package com.camel.ApacheCamel.route;

import com.camel.ApacheCamel.model.LibraryBookDetail;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

/**
 * This class is use to Route the Data to RabbitMQ
 * which is recieved from Rest call.
 */
@Component
public class LibraryRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(LibraryBookDetail.class);
        from("direct:restPointCall").id("idToRouteRest").marshal(jacksonDataFormat)
                .to("rabbitmq://localhost:5672/librayQueue.exchange?queue=librayQueue&autoDelete=false").end();
    }
}
