package com.helpdesk.HelpDesk.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Category {

    @Id
    @Size(max = 255)
    private String name;

    public Category() {}

    public Category(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
