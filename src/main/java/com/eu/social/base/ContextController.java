package com.eu.social.base;

import org.springframework.stereotype.Controller;

import com.eu.social.base.definitions.IContextController;

@Controller
public class ContextController implements IContextController {

  public String contextRoot() {
    return "index";
  }

}
