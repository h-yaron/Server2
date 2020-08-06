package com.nice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintConsole extends Printer {

    @Autowired
    public PrintConsole(PrintService service) {
        super(service);
    }

    @Override
    protected void doPrint(String text) {
        System.out.println(text);
    }
}
