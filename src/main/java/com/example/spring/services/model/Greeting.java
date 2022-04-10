package com.example.spring.services.model;

/**
 * @author nelson-yeh-fy (https://https://github.com/nelson-yeh-fy)
 * @version 1.0
 * @since 1.0
 */
public class Greeting {
    private long id;
    private String name;

    /**
     * Implements generic greeting object
     *
     * @param id the id
     * @param name the name string
     */
    public Greeting(long id, String name){
        this.id = id;
        this.name = name;
    }
    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}
