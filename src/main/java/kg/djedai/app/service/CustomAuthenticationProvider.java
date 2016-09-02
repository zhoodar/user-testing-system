package kg.djedai.app.service;

import kg.djedai.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhoodar
 * @since 20.08.2016.
 */
@Service("provider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private DAOFactory factory;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        final User user = factory.userDAO.findByToSearch(login,password );

        if(user != null){
            int userId = user.getId();
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority(user.getRole().getName()));
            UserPrincipal appUser = new UserPrincipal(login,password,true,true,true,true,grantedAuths,userId);
            UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(appUser,password,grantedAuths);
            auth.setDetails(userId);
            return auth ;
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
