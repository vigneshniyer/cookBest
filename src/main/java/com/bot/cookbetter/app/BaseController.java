package com.bot.cookbetter.app;

import com.bot.cookbetter.utils.RequestHandlerUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BaseController {

    final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Welcome to CookBetter!");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/slack", consumes = "application/x-www-form-urlencoded")
    public void slack(HttpServletRequest request) {
        RequestHandlerUtil.getInstance().handleSlackRequest(request);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/slack-interactive")
    public void slackInteractive(HttpServletRequest request) {
        logger.info("Inside interactive method");
        RequestHandlerUtil.getInstance().handleInteractiveSlackRequest(request);
    }



}