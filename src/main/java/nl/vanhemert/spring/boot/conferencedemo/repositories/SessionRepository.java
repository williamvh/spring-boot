package nl.vanhemert.spring.boot.conferencedemo.repositories;

import nl.vanhemert.spring.boot.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
