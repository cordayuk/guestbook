package com.practice.guestbook.service;

import com.practice.guestbook.model.Message;


public interface MessageService {
    Iterable<Message> findAll();
    Message save(Message message);
}
