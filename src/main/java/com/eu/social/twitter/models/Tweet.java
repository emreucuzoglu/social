package com.eu.social.twitter.models;

public class Tweet {

  private String status;

  public Tweet() {
    super();
  }

  public Tweet(String status) {
    super();
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
