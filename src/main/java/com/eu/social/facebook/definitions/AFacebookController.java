package com.eu.social.facebook.definitions;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;

public abstract class AFacebookController implements IFacebookController {
  private Facebook facebook;
  private ConnectionRepository connectionRepository;

  public AFacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
    this.facebook = facebook;
    this.connectionRepository = connectionRepository;
  }

  public Facebook getFacebook() {
    return facebook;
  }

  public void setFacebook(Facebook facebook) {
    this.facebook = facebook;
  }

  public ConnectionRepository getConnectionRepository() {
    return connectionRepository;
  }

  public void setConnectionRepository(ConnectionRepository connectionRepository) {
    this.connectionRepository = connectionRepository;
  }

  public String checkConnection() {
    if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
      return "redirect:/connect/facebook";
    }

    return null;
  }

}
