package com.eu.social.twitter.definitions;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

public abstract class ATwitterController implements ITwitterController {
  private Twitter twitter;

  private ConnectionRepository connectionRepository;

  public ATwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
    this.twitter = twitter;
    this.connectionRepository = connectionRepository;
  }

  public Twitter getTwitter() {
    return twitter;
  }

  public ConnectionRepository getConnectionRepository() {
    return connectionRepository;
  }

  public String checkConnection() {
    if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
      return "redirect:/connect/twitter";
    }

    return null;
  }

}
