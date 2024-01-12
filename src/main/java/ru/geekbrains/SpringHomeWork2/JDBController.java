package ru.geekbrains.SpringHomeWork2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBController {
    @Autowired
    BaseInitializr baseInitializr;
    @Autowired
    DBProcessor dbProcessor;

    @GetMapping("/")
    public String start() {
        baseInitializr.create();
        return dbProcessor.process("SELECT * FROM rashen_schema.books WHERE author = 'Лев Толстой'");
    }
}
