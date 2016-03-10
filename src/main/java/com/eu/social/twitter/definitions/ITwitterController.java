package com.eu.social.twitter.definitions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eu.social.base.definitions.IContextController;
import com.eu.social.twitter.models.Tweet;

public interface ITwitterController extends IContextController {

  @RequestMapping(method = RequestMethod.GET, path = "/listFriends")
  public String listFriends(Model model);

  @RequestMapping(method = { RequestMethod.GET }, path = "/updateStatus")
  public String updateStatus(Model model);

  @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, path = "/updateStatus")
  public String updateStatus(@ModelAttribute(value = "tweet") Tweet tweet);

}
