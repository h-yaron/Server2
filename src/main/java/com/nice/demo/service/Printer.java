package com.nice.demo.service;

import com.nice.demo.data.Message;
import com.nice.demo.data.MessageType;


public abstract class Printer {

    public Printer(PrintService service) {
        service.register(this);
    }

    public void print(Message message, double total) {
        doPrint("Message of type: " + message.getType() + " , data: " + message.getData() +
                ", Total: " + total);
    }

    protected abstract void doPrint(String text);
}
