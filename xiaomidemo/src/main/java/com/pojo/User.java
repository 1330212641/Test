package com.pojo;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User  implements UserDetails {

  private long uid;
  private String name;
  private long sex;
  private String phone;
  private String area;
  private long manager;
  private String username;
  private String password;
  private String phoneNumber;
  private Boolean locked;
  private Boolean enabled;
  private List<Role> roles;   //用户所具有的角色  ==>超级管理员、商品管理员

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  private java.sql.Timestamp createTime;


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }


  public long getManager() {
    return manager;
  }

  public void setManager(long manager) {
    this.manager = manager;
  }


  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {  //账号未过期
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {   //账号未锁定
    return !this.locked;
  }

  @Override
  public boolean isCredentialsNonExpired() {  //密码未过期
    return true;
  }

  @Override
  public boolean isEnabled() {   //账号是否可用
    return this.enabled;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    if(roles!=null){
       for(Role r:roles){
         SimpleGrantedAuthority s = new SimpleGrantedAuthority(r.getRname());
         authorities.add(s);
       }
    }
    return authorities;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}
