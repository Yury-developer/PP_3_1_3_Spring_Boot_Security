package academy.kata.controller;

import academy.kata.model.User;
import academy.kata.service.UserService;
import academy.kata.utils.UserGenerator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


@Controller
@RequestMapping(value = "/users/user")
public class UserController {

    private final UserService userService;

    private static Logger LOGGER;

    static {
        try {
            Resource resource = new ClassPathResource("userController_loggerConfig.properties");
            InputStream ins = resource.getInputStream();
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(UserController.class.getName());
            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER = null;
        }
    }



    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    public String userPage(Model model, Principal principal) {
        LOGGER.fine("UserController: userPage");

        System.out.println(principal.getName());
        User user = UserGenerator.getDefaultUser();
        user.setFullName(principal.getName());

        model.addAttribute("infoUser", user);
        return "user";
    }
}
