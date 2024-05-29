package academy.kata.controller;

import academy.kata.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/admin/welcome")
public class AdminGreetingController {

    private final UserService userService;


    public AdminGreetingController(UserService userService) {
        this.userService = userService;
    }


    // отдает страницу для создания нового пользователя
    @GetMapping
    public String greetingPage(Model model) {
        Integer userCountDefault = 15;   // По умолчанию будет предложено создать такое количество пользователей.
        model.addAttribute("greeting", "Hello!");
        model.addAttribute("greetingMessage", "Практическая задача 3.1.3 Java pre-project. Задача 3.1.2. Spring Boot, Security.");
        model.addAttribute("author", "Выполнил: Лапицкий Юрий   //   Performed by: Yury Lapitski");
        model.addAttribute("user_count_default", userCountDefault);
        return "admin/greeting-page";
    }


    @PostMapping(value = "/generate")
    public String generateTestData(@RequestParam(name = "user_count") Integer userCount) {
        System.out.println("GreetingController: generateTestData");
        userService.generateTestData(userCount);
        return "redirect:/admin";
    }
}
