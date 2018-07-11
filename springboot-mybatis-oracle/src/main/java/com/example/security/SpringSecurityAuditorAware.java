package com.example.security;

import com.example.domain.User;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by onnuricis on 2016. 12. 30..
 */
public class SpringSecurityAuditorAware implements AuditorAware<Long> {

  @Override
  public Long getCurrentAuditor() {
    User user = getCurrentUser();
    Long id = user == null ? null: user.getId();
    return id;
  }

  private User getCurrentUser() {
    User user = null;
    try {
      user = SecurityUtils.getCurrentUser();
    } catch(RuntimeException ex) {

    }
    return user;
  }
}
