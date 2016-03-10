package com.eu.social.facebook.definitions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eu.social.base.definitions.IContextController;

public interface IFacebookController extends IContextController {

  @RequestMapping(method = RequestMethod.GET, path = "/feed")
  public String feed(Model model);

}
