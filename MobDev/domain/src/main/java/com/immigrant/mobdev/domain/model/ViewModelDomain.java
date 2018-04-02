package com.immigrant.mobdev.domain.model;

/**
 * Created by Andres on 01/04/2018.
 */

public class ViewModelDomain {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ViewModelDomain(String name) {

        this.name = name;
    }
}
