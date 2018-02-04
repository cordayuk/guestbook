package com.practice.guestbook.service;

import com.practice.guestbook.dao.MessageDao;
import com.practice.guestbook.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> findAll() {
        Iterable<Message> messages = messageDao.findAll();
        List<Message> allMessages = new ArrayList<>();

        for(Message m : messages){
            allMessages.add(m);
        }
        Collections.sort(allMessages);

        return allMessages;
    }

    @Override
    public Message save(Message message) {
        return messageDao.save(message);
    }
}
