package es.ventura24.demo.web.user;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by jsanc on 28/08/15.
 */
@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Usuario.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Usuario usuario = (Usuario)target;

        if (StringUtils.isEmpty(usuario.getId())) {
            errors.rejectValue("id","id.empty");
        }
        if (StringUtils.isEmpty(usuario.getName())) {
            errors.reject("name","name.empty");
        }

        if (usuario.getName().equalsIgnoreCase("test")) {
            errors.reject("invalid.name");
        }

        return;

    }
}
