package com.capgemini.cat.model.persistance;

import com.capgemini.cat.model.Cat;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CatRepository {

    private long lastID = 0;
    private Map<Long, Cat> cats = new HashMap<>();

    //fill the map when starting the application using the constructor
    @PostConstruct // will invoke automatically
    public void init(){
        for(int i = 0; i<5;i++){
            Cat cat = new Cat();
            cat.setName("Gerrit" + i);
            cat.setAge(2*i);

            this.save(cat);
        }
    }

    public void save(Cat newCat){
        lastID++;
        newCat.setId(lastID);
        this.cats.put(newCat.getId(), newCat);

    }

    public Collection findAll(){
        return this.cats.values();
    }

    public Cat findById(long id){
        return this.cats.get(id);

    }

    public void deleteById(long id){
        this.cats.remove(id);

    }

    public Cat update(long id, Cat update){
        Cat victim = this.findById(id);
        victim.setAge(update.getAge());
        victim.setName(update.getName());

        return victim;

    }


}
