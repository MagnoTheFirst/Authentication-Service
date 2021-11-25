package ch.ffhs.uservalidation.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/account")
    public String viewUserAccountForm(@AuthenticationPrincipal AppUser appUser, Model model){
        String userEmail = appUser.getEmail();
        AppUser user = appUserService.getByEmail(userEmail).get();

        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Account Details");

        return "user-lobby";
    }

}
