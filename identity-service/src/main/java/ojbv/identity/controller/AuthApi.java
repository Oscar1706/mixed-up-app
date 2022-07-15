package ojbv.identity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.ApplicationScope;

@Api(tags = "Authentication")
@RestController
@RequestMapping(path = "api/public") 
public class AuthApi {
    
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserViewMapper userViewMapper;

    public AuthApi(AuthenticationManager authenticationManager,
                    JwtTokenUtil jwtTokenUtil,
                    UserViewMapper userViewMapper){
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userViewMapper = userViewMapper;
    }

    public ResponseEntity<UserView> login(
        @RequestBody @Valid AuthRequest request
    ){
        try {
            // Authenticate the user through AuthenticationManager
            Authentication authenticate = authenticationManager
                .authenticate( 
                    new UsernamePasswordAuthenticationToken(
                        request.getUsername(), 
                        request.getPassword()
                    )
                 );
            
            // Get authenticated user object
            User user = (User) authenticate.getPrincipal();

            // Return user information and jwt token as header
            return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToklen(user))
                .body(
                    userViewMapper.toUserView(user)
                );
        } catch (BadCredentialsException be) {
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();
        }

    }

}
