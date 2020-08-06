package com.nice.demo.web;

import com.nice.demo.data.Message;
import com.nice.demo.data.MessageType;
import com.nice.demo.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Listener2 {

    PrintService printService;

    @Autowired
    public Listener2(PrintService printService) {
        this.printService = printService;
    }

    @PostMapping("/message")
    public void accept(@RequestBody Message message) {
        MessageType type = MessageType.get(message.getType());

        type.verify(message.getData());

        printService.accept(message, type);
    }
}
