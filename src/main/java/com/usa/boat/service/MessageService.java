/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.service;

import com.usa.boat.entity.Message;
import com.usa.boat.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruby Dayana
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository metodosCrud;

    public List<Message> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return metodosCrud.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Message> evtMessage = metodosCrud.getMessage(message.getIdMessage());
            if (evtMessage.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> evtMessage = metodosCrud.getMessage(message.getIdMessage());
            if (!evtMessage.isEmpty()) {

                if (message.getMessageText() != null) {
                    evtMessage.get().setMessageText(message.getMessageText());
                }

                metodosCrud.save(evtMessage.get());
                return evtMessage.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean booleanDelete = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return booleanDelete;
    }
}
