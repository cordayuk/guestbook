package com.practice.guestbook.web;

import com.practice.guestbook.model.Message;
import com.practice.guestbook.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class GuestbookController {
    @Autowired
    private MessageService messageService;

    // Index page, shows all messages and names in date order
    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("messages", messageService.findAll());

        return "index";
    }

    // Form for submitting a new message to the guestbook
    @RequestMapping("/post")
    public String createPost(Model model) {
        if(!model.containsAttribute("message")){
            model.addAttribute("message", new Message());
        }

        return "form";
    }

    // Receives HTTP post data to create and save new message, provided it is valid
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String receivePost(@Valid @ModelAttribute Message message, BindingResult result, RedirectAttributes redirect) {
        if(result.hasErrors()){
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.message" ,result);
            redirect.addFlashAttribute("message", message);
            return "redirect:/post";
        }

        messageService.save(message);

        return "redirect:/";
    }

}
