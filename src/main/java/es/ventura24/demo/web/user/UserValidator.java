package es.ventura24.demo.web.user;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by jsanc on 28/08/15.
 */
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Usuario.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Usuario usuario = (Usuario)target;

        if (usuario.getName().equalsIgnoreCase("test")) {
            errors.reject("invalid.name");
        }



    }
}
