package com.eu.social.base.definitions;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IContextController {

  @RequestMapping(path = { "", "/" })
  public String contextRoot();

}
