package nl.vanhemert.spring.boot.conferencedemo.repositories;

import nl.vanhemert.spring.boot.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
