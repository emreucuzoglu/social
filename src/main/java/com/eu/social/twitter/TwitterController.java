package com.eu.social.twitter;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eu.social.twitter.definitions.ATwitterController;
import com.eu.social.twitter.models.Tweet;

@Controller
@RequestMapping("/twitter")
public class TwitterController extends ATwitterController {

  @Inject
  public TwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
    super(twitter, connectionRepository);
  }

  @Override
  public String contextRoot() {
    String result = checkConnection();
    if (result != null) {
      return result;
    }
    return "/connect/twitterConnected";
  }

  @Override
  public String listFriends(Model model) {
    String result = checkConnection();
    if (result != null) {
      return result;
    }

    result = "/twitter/listFriends";

    Twitter twitter = getTwitter();

    model.addAttribute(twitter.userOperations().getUserProfile());
    CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
    model.addAttribute("friends", friends);
    return result;
  }

  @Override
  public String updateStatus(Model model) {
    model.addAttribute("tweet", new Tweet());
    return null;
  }

  @Override
  public String updateStatus(@ModelAttribute(value = "tweet") Tweet tweet) {
    String result = checkConnection();
    if (result != null) {
      return result;
    }

    Twitter twitter = getTwitter();
    twitter.timelineOperations().updateStatus(tweet.getStatus());

    return null;
  }

}
