package com.example.security;

import com.example.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@lombok.Getter
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {

  private static final long serialVersionUID = 8445897693054150483L;

  private User user;

  public LoginUserDetails(User user) {
    super(user.getUsername(), user.getPassword(), user.getAuthorities());
  }
}
