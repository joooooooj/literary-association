package com.la.security.auth;

import com.la.security.TokenUtils;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtils tokenUtils;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenUtils, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        if (!httpServletRequest.getRequestURI().contains("/transaction/update")){
            String username;
            String authenticationToken = tokenUtils.getToken(httpServletRequest);

            System.err.println(httpServletRequest.getRequestURI());

            if (authenticationToken != null) {
                // uzmi username iz tokena
                username = tokenUtils.getUsernameFromToken(authenticationToken);

                if (username != null) {
                    // uzmi username iz tokena
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                    // uzmi username iz tokena
                    if (tokenUtils.validateToken(authenticationToken, userDetails)) {
                        // uzmi username iz tokena
                        TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                        authentication.setToken(authenticationToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }

        }
        else {
            SecurityContextHolder.getContext().setAuthentication(new AbstractAuthenticationToken(null) {
                @Override
                public boolean isAuthenticated() {
                    return true;
                }

                @Override
                public Object getCredentials() {
                    return "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsdSIsInN1YiI6Imlnb3IiLCJhdWQiOiJ3ZWIiLCJpYXQiOjE2MDg1ODA5NDMsImV4cCI6MTYwODY2NzM0MywiVVNFUl9ST0xFUyI6W3siaWQiOjEsIm5hbWUiOiJST0xFX0FETUlOIiwicGVybWlzc2lvbnMiOlt7ImlkIjo1LCJuYW1lIjoiREVMRVRFX1BBWU1FTlRfTUVUSE9EIiwiYXV0aG9yaXR5IjoiREVMRVRFX1BBWU1FTlRfTUVUSE9EIn0seyJpZCI6MiwibmFtZSI6IkRFQ0xJTkVfUkVRVUVTVCIsImF1dGhvcml0eSI6IkRFQ0xJTkVfUkVRVUVTVCJ9LHsiaWQiOjEsIm5hbWUiOiJBUFBST1ZFX1JFUVVFU1QiLCJhdXRob3JpdHkiOiJBUFBST1ZFX1JFUVVFU1QifSx7ImlkIjozLCJuYW1lIjoiUkVBRF9SRVFVRVNUUyIsImF1dGhvcml0eSI6IlJFQURfUkVRVUVTVFMifSx7ImlkIjo0LCJuYW1lIjoiQ1JFQVRFX1BBWU1FTlRfTUVUSE9EIiwiYXV0aG9yaXR5IjoiQ1JFQVRFX1BBWU1FTlRfTUVUSE9EIn1dfV19.haVdsgIHKjEXnMrw2_LwM-5N_O0TbIRZq7itpTH8LyTgaZ2XC-ffKNn9WbEwo2GFro5pxMMqInIwO7Ru2y8MTw";
                }

                @Override
                public Object getPrincipal() {
                    return new UserDetails() {
                        @Override
                        public Collection<? extends GrantedAuthority> getAuthorities() {
                            return null;
                        }

                        @Override
                        public String getPassword() {
                            return "123123";
                        }

                        @Override
                        public String getUsername() {
                            return "igor";
                        }

                        @Override
                        public boolean isAccountNonExpired() {
                            return true;
                        }

                        @Override
                        public boolean isAccountNonLocked() {
                            return true;
                        }

                        @Override
                        public boolean isCredentialsNonExpired() {
                            return true;
                        }

                        @Override
                        public boolean isEnabled() {
                            return true;
                        }
                    };
                }
            });
        }

        // prosledi request dalje u sledeci filter
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
