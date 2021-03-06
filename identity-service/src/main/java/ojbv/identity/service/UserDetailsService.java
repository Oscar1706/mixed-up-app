package ojbv.identity.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

    UserDetails loaUserByName(String  name)
        throws UsernameNotFoundException;
    
}
