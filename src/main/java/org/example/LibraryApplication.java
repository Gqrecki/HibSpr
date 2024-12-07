package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication { // Zmiana nazwy klasy z LibraryApplication na Application

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args); // Zmiana nazwy klasy także w metodzie main
    }
}