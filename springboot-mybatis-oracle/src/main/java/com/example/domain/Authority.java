package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by onnuricis on 2016. 12. 30..
 */
@Getter
@Setter
@ToString
public class Authority implements GrantedAuthority {

  private Long id;

  private String authority;
}
