package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user";
    }

    @GetMapping("/adduser")
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adduser";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam("id") Long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return "redirect:/";
    }

    @GetMapping("updateeser")
    public String getEditUserFrom(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "updateuser";
    }

    @GetMapping("/updateuser")
    public String updateUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateuser";
        }
        userService.updateUser(user);
        return "redirect:/";
    }
}
