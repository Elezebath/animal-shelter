# Animal Shelter Console Application

A Java console application for managing animals in an animal shelter. This project was completed as part of the **M3A Practical Task** and demonstrates object-oriented programming principles, Java generics, and modern Java features.

## Features

The application supports the following operations:

- Add a new animal to the shelter
- List all animals
- Search animals by species
- Display only animals available for adoption
- Mark an animal as adopted
- Validate user input and display informative console messages

## OOP Concepts Demonstrated

This project showcases the following Java concepts:

- Classes, objects, fields, constructors, and methods
- Constructor overloading
- Encapsulation
- Immutable value object (`AnimalId`)
- Sealed class hierarchy
- Inheritance and polymorphism
- Enums (`AdoptionStatus`)
- Generics (`Shelter<T>`)
- Lombok annotations to reduce boilerplate code
- Collections (`List`)

## Project Structure

```text
src
├── Main.java
├── menu/
│   ├── ConsoleMenu.java
│   └── MenuOption.java
├── model/
│   ├── Animal.java
│   ├── Dog.java
│   ├── Cat.java
│   ├── Bird.java
│   ├── AnimalId.java
│   └── AdoptionStatus.java
└── shelter/
    └── Shelter.java
```


## 📌 Assignment Reference

This project is a solution to the following assignment:
https://github.com/bonanzaa/acc-2026-java-m3a
