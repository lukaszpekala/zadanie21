package com.example.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController2 {
    private List<User> users;

    public MainController2() {
        users = new ArrayList<>();
        users.add(new User("Adam", "Buk", 1L));
        users.add(new User("Marcin", "Wrona",2L));
        users.add(new User("Basia", "Wicek", 3L));
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", users);

        return "home2";
    }

    @PostMapping("/dodaj")
    public String add(User user) {
        long maxId = 1;
        for (User user1 : users) {
            if (user1.getId() > maxId) {
                maxId = user1.getId();
            }
        }
        user.setId(maxId + 1);
        users.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam Long id, Model model) {
        for (User user : users) {
            if(user.getId().equals(id)) {
                model.addAttribute("user", user);
                return "edit";
            }
        }
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(User user) {
        for (User user1 : users) {
            if(user1.getId().equals(user.getId())) {
                user1.setFirstName(user.getFirstName());
                user1.setLastName(user.getLastName());
                break;
            }
        }
        return "redirect:/";
    }


}
