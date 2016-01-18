package com.example.sitetrackerprox;


public class Website {
 // fields
 private String user;
 private String password;
 private String url;
 private String email;

 public Website() {
 }

 public Website(String u, String rl, String em, String pw) {
  String user = u;
  String url = rl;
  String email = em;
  String password = pw;
 }

 public String getUser() {
  return user;
 }

 public void setUser(String user) {
  this.user = user;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getUrl() {
  return url;
 }

 public void setUrl(String url) {
  this.url = url;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

}
