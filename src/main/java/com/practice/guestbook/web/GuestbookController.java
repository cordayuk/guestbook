package com.practice.guestbook.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestbookController {

    @RequestMapping("/")
    public String mainPage(){
        return null;
    }
}
