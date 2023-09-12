package gr.test;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("/hello")
public class HelloResource {

    @Inject
    Validator validator;

    @Inject
    HttpHeaders httpHeaders;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println("httpHeaders.getCookies() = " + httpHeaders.getCookies());
        Clazz clazz = new Clazz();
        Set<ConstraintViolation<Clazz>> validate = validator.validate(clazz);
        for (ConstraintViolation<Clazz> clazzConstraintViolation : validate) {
            System.out.println("clazzConstraintViolation = " + clazzConstraintViolation.getMessage());
        }
        return "Hello from RESTEasy Reactive";
    }
}
