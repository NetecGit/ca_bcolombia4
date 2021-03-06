package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(
            GET("/api/customer/{name}"), handler::listenGETUseCase)
            .andRoute(POST("/api/customer-add"), handler::listenPOSTUseCase)
            .andRoute(GET("/api/customers"), handler::listenGETAll)
            .and(route(GET("/api/customer/{name}/{surname}"), handler::listenGETOtherUseCase));

    }
}
