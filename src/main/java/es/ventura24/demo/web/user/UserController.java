package es.ventura24.demo.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by jsanc on 28/08/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    private UserValidator userValidator;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Inject
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @Inject
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(final Model model) {
        model.addAttribute("usuarios", userService.findAllUsers());
        return "users/all";
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id,final Model model) {
        userService.findById(id)
                .ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "users/one";
    }


    @RequestMapping(value="/create",method = RequestMethod.GET)
    public String create(final Model model) {
        model.addAttribute("usuario", new Usuario());
        return "users/new";
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public String create(Model model,@Valid final Usuario usuario, BindingResult bindingResult) {
        String result = "redirect:/user";
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(error -> LOGGER.error(error.toString()));

            result = "users/new";
        } else {
            model.addAttribute("created", true);
        }
        return result;
    }
}
