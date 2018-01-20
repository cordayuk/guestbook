package com.practice.guestbook.dao;

import com.practice.guestbook.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends CrudRepository<Message, Long> {
}
