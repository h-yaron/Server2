package com.nice.demo.service;

import com.nice.demo.data.Message;
import com.nice.demo.data.MessageType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PrintService {

    private double total = 0;
    private ArrayList<Printer> printers = new ArrayList<>();

    public void accept(Message message, MessageType type) {
        total += type.getDoubleValue(message.getData());

        print(message, total);
    }

    private void print(Message message, double total) {
        printers.forEach(printer -> printer.print(message, total));
    }

    public void register(Printer printer) {
        printers.add(printer);
    }
}
