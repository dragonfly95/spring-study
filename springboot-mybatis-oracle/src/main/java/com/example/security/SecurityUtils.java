package com.example.security;

import com.example.domain.User;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@CommonsLog
public final class SecurityUtils {
  public SecurityUtils() {
  }

  public static User getCurrentUser() {
    SecurityContext ctx = SecurityContextHolder.getContext();
    if(ctx.getAuthentication() == null)
      throw new AccessDeniedException("User not found in security session.");
    Authentication auth = ctx.getAuthentication();
    AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
    User currentUser = null;
    boolean signupUser = resolver.isAnonymous(auth);
    if(auth != null && !signupUser) {
      currentUser = getCurrentUser(auth);
    }
    return currentUser;
  }

  private static User getCurrentUser(Authentication auth) {
    LoginUserDetails loginUserDetails = null;
    if (auth.getPrincipal() instanceof UserDetails) {
      loginUserDetails = (LoginUserDetails) auth.getPrincipal();
    } else if (auth.getDetails() instanceof UserDetails) {
      loginUserDetails = (LoginUserDetails) auth.getDetails();
    } else {
      throw new AccessDeniedException("User not properly authenticated.");
    }
    return loginUserDetails.getUser();
  }
}
