package ch.ffhs.uservalidation.registration;

import ch.ffhs.uservalidation.appuser.AppUser;
import ch.ffhs.uservalidation.appuser.AppUserRole;
import ch.ffhs.uservalidation.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ObjectStreamException;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;



    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("Email ist nicht gültig") ;
        }

        return appUserService.signUpUser(new AppUser(request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                request.getPassword(), AppUserRole.USER));
    }


}
