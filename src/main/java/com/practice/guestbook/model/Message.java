package com.practice.guestbook.model;

import org.springframework.format.datetime.DateFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
public class Message implements Comparable<Message>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 30)
    private String posterName;

    private LocalDateTime postDate = LocalDateTime.now();

    @Size(max = 180)
    private String posterMessage;

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPosterMessage() { return posterMessage;
    }

    public void setPosterMessage(String posterMessage) {
        this.posterMessage = posterMessage;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    @Override
    public int compareTo(Message o) {
        if(postDate.isAfter(o.getPostDate())){
            return -1;
        }
        else if(postDate.equals(o.getPostDate())){
            return 0;
        }
        else
            return 1;

    }
}
