package ch.ffhs.uservalidation.view;

import ch.ffhs.uservalidation.appuser.AppUser;
import ch.ffhs.uservalidation.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(path="/api/v1/register")
public class RegistrationViewController {

    private final RegistrationService userRegistrationService;

    @Autowired
    public RegistrationViewController(RegistrationService registrationService) {
        this.userRegistrationService  = registrationService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public String getSignup(Model model)
    {
        return "signup";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("userreg")
    public String getReg(Model model)
    {
        AppUser user = new AppUser();
        model.addAttribute("user", user);
        return "registration";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("userreg1")
    public String getReg1(Model model)
    {
        AppUser user = new AppUser();
        model.addAttribute("user", user);
        return "signup";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("login")
    public String login(Model model)
    {
        return "login";
    }


    @PostMapping("test")
    public String addNewUser(@ModelAttribute("user") AppUser user){
        userRegistrationService.addUser(user);
        return "confirm-token";
    }


}
