package nl.vanhemert.spring.boot.conferencedemo.controllers;

import nl.vanhemert.spring.boot.conferencedemo.models.Speaker;
import nl.vanhemert.spring.boot.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return this.speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return this.speakerRepository.getById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return this.speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker) {
        Speaker existingSpeaker = this.speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return this.speakerRepository.saveAndFlush(existingSpeaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.speakerRepository.deleteById(id);
    }
}
