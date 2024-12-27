package org.example.labainfinity;

public class Book {
    private String name;
    private int age;  // Возраст книги
    private String author;
    private String genre;


    public Book(String name, int age, String author, String genre) {
        this.name = name;
        this.age = age;
        this.author = author;
        this.genre = genre;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be positive.");
        }
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
