package com.coffeeshop.api.controller;

import com.coffeeshop.api.domain.Person;
import com.coffeeshop.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 985552 on 5/17/2017.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person add(@RequestBody Person player) {
        System.out.println("Post player:"+player);
        player = personService.savePerson(player);
        System.out.println("Posted player:"+player);
        return player;
    }

    @PutMapping("/{id}")
    public Person update(@RequestBody Person player) {
        System.out.println("Post player id:"+player.getId());
        player = personService.savePerson(player);
        System.out.println("Posted player:"+player);
        return player;
    }

    @GetMapping(value="/{id}")
    public Person getById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping("/login")
    public Person login(@RequestBody Person person) {
        List<Person> persons = personService.findByEmailAndPassword(person.getEmail(), person.getPassword());
        person=null;
        if (!persons.isEmpty()){
            person = persons.get(0);
            person.setPassword(null);
        }
        return person;
    }

    @GetMapping("/email")
    public List<Person> getByEmail(@RequestParam("email") String email) {
        return personService.findByEmail(email);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.findAll();
    }

    /*@PutMapping(value="/player/{id}")
    public Person update(@PathVariable("id") int id, @RequestBody Person player) {
        return personService.update(id, player);
    }*/

    @DeleteMapping(value="/{id}")
    public void delete(@RequestBody Person person) {
        personService.removePerson(person);
    }
}
