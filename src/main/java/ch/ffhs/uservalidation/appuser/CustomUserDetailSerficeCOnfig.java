package ch.ffhs.uservalidation.appuser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class CustomUserDetailSerficeCOnfig {


    public UserDetailsService userDetailsService(final AppUserRepository appUserRepository){
      return null;
    }

}
