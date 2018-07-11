package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class User {

  public User() {}


  public User(String name2, String password2, String username2, HashSet<Authority> authorities) {
    this.name = name2;
    this.password = password2;
    this.username = username2;
    this.authorities = authorities;
  }


  @Id
  @GeneratedValue
  private Long id;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "t_user_authority", joinColumns = {
      @JoinColumn(name = "user_id") }, inverseJoinColumns = @JoinColumn(name = "authority_id"))
  private Set<Authority> authorities = new HashSet<Authority>();

  @Column(length = 30)
  private String name;

  @Column(length = 50)
  private String username;

  @Column(length = 255)
  private String password;

  @Column(length = 100)
  private String email;

  @Column(length = 20)
  private String mobile;

  public Set<GrantedAuthority> getAuthorities() {
    Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
//    this.authorities.forEach(authority -> authorities.add(authority));
    return authorities;
  }

}
