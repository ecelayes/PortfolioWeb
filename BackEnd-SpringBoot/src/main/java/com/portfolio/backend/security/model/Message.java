package com.portfolio.backend.security.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Message {
    
    private String mensaje;

    //Constructor
    
    public Message() {
    }

    public Message(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
