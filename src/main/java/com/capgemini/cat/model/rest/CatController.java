package com.capgemini.cat.model.rest;

import com.capgemini.cat.model.Cat;
import com.capgemini.cat.model.persistance.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/cats")
public class CatController {

    //private Map<Long,Cat> cats = new HashMap<>();

    @Autowired
    private CatRepository catRepository;


    /*@GetMapping("cat") //http://localhost:8080/hello/cat
    public List<Cat> getCat(){

        Cat cat1 = new Cat();
        cat1.setName("Amy");
        cat1.setAge(5);

        Cat cat2 = new Cat();
        cat2.setName("Mila");
        cat2.setAge(5);

        List<Cat> listOfCats = new ArrayList<>();
        listOfCats.add(cat1);
        listOfCats.add(cat2);

        return listOfCats;
    } */


    @PostMapping
    public Cat create(@RequestBody Cat newCat){

        //newCat.setId(++Cat.lastID);
        //this.cats.put(newCat.getId(), newCat);
        this.catRepository.save(newCat);

        return newCat;

    }


    @GetMapping
    public Collection<Cat> list(){
        return this.catRepository.findAll();
    }


    //search for a cat by id
    @GetMapping("{id}")
    public Cat findById(@PathVariable long id){
        //return cats.get(id);
        Cat result = this.catRepository.findById(id);
        return result;
    }




}

