package com.chseidler.emailevent.repositories;

import com.chseidler.emailevent.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
