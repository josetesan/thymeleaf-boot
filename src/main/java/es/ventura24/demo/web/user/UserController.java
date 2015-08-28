package es.ventura24.demo.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String create() {
        return "users/new";
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public String create(@Valid Usuario usuario,final Model model, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // do something special
        }
        model.addAttribute("created",true);
        return "users/all";
    }
}
