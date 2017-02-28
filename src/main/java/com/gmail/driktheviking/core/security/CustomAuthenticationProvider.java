package com.gmail.driktheviking.core.security;

        import com.gmail.driktheviking.modules.user.service.UserService;
        import org.springframework.security.authentication.AbstractAuthenticationToken;
        import org.springframework.security.authentication.AuthenticationProvider;
        import org.springframework.security.authentication.InternalAuthenticationServiceException;
        import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.AuthenticationException;

        import javax.inject.Inject;
        import javax.inject.Named;
        import java.util.ArrayList;

@Named
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Inject
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // get username and password
        String username = (authentication.getPrincipal() == null) ? "" : authentication.getName();
        String password = (authentication.getCredentials() == null) ? "" : authentication.getCredentials().toString();

        // check credentials
        if (userService.checkCredentials(username, password)) {
            // init return value
            AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());

            // set user object
            authenticationToken.setDetails(userService.getUserByUsername(username));

            // return user details
            return authenticationToken;
        }

        // indicate invalid credentials
        throw new InternalAuthenticationServiceException("Unable to authenticate");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}