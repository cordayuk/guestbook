package com.practice.guestbook.dao;

import com.practice.guestbook.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageDao extends CrudRepository<Message, Long> {
}
