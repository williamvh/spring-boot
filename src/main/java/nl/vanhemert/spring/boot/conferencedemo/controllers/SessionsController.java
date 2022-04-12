package nl.vanhemert.spring.boot.conferencedemo.controllers;

import nl.vanhemert.spring.boot.conferencedemo.models.Session;
import nl.vanhemert.spring.boot.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return this.sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return this.sessionRepository.getById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return this.sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody final Session session) {
        Session existingSession = this.sessionRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return this.sessionRepository.saveAndFlush(existingSession);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.sessionRepository.deleteById(id);
    }
}
