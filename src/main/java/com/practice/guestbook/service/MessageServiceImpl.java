package com.practice.guestbook.service;

import com.practice.guestbook.dao.MessageDao;
import com.practice.guestbook.model.Message;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public Iterable<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message save(Message message) {
        return messageDao.save(message);
    }
}
