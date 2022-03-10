package com.chseidler.emailevent.services;

import com.chseidler.emailevent.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;
}
