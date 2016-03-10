package com.eu.social.facebook;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eu.social.facebook.definitions.AFacebookController;

@Controller
@RequestMapping("/facebook")
public class FacebookController extends AFacebookController {

  @Inject
  public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
    super(facebook, connectionRepository);
  }

  @Override
  public String contextRoot() {
    String result = checkConnection();
    if (result != null) {
      return result;
    }
    return "/connect/facebookConnected";
  }

  @Override
  public String feed(Model model) {
    String result = checkConnection();
    if (result != null) {
      return result;
    }

    result = "/facebook/feed";

    Facebook facebook = getFacebook();

    model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
    PagedList<Post> feed = facebook.feedOperations().getFeed();
    model.addAttribute("feed", feed);
    return result;
  }

}
