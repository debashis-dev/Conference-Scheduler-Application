package com.conference.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Talk {
    private String title;
    private int duration;
    
    @Override
    public String toString() {
        return title + " " + (duration == 5 ? "lightning" : duration + "min");
    }
}
