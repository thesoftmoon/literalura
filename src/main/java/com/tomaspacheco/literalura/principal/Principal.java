package com.tomaspacheco.literalura.principal;

import com.tomaspacheco.literalura.model.*;
import com.tomaspacheco.literalura.repository.BookRepository;
import com.tomaspacheco.literalura.service.ApiConsumption;
import com.tomaspacheco.literalura.service.DataConvertion;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    ApiConsumption apiConsumption = new ApiConsumption();
    DataConvertion dataConvertion = new DataConvertion();
    private final String BASE_URL = "https://gutendex.com/books/";
    private final String SEARCH_PARAMETER = "?search=";


    Scanner keyboard = new Scanner(System.in);
    Boolean exit = false;
    String options = """
            1- Buscar libro por titulo
            2- Listar libros registrados
            3- Listar autores registrados
            4- Listar autores vivos en determinado año
            5- Listar libros por idioma

            0- Salir
            """;

    private BookRepository bookRepository;

    public Principal(BookRepository repository) {
        this.bookRepository = repository;
    }

    public void showMenu() {

        while (!exit) {
            System.out.println("Selecciona una opción");
            System.out.println(options);
            var userSelection = keyboard.nextInt();
            keyboard.nextLine();
            switch (userSelection) {
                case 1:
                    System.out.println("Buscar libro por titulo");
                    searchAndSaveABook();
                    break;
                case 2:
                    System.out.println("Listar libros registrados");
                    showAllBooks();
                    break;
                case 3:
                    System.out.println("Listar autores registrados");
                    showAllAuthors();
                    break;
                case 4:
                    System.out.println("Listar autores vivos en determinado año");
                    showAllAuthorsAliveInCertainYear();
                    break;

                case 5:
                    System.out.println("Listar libros por idioma");
                    break;

                case 0:
                    System.out.println("Saliendo de la app...");
                    exit = true;
            }
        }
    }

    private BookData getBookData() {
        System.out.println("Escribe el nombre del libro que quieres buscar");
        String bookName = keyboard.nextLine();
        var json = apiConsumption.getData(BASE_URL + SEARCH_PARAMETER + bookName.replace(" ", "%20"));
        System.out.println(json);

        // Deserialize the JSON in a BooksData
        var booksData = dataConvertion.getData(json, BooksData.class);

        //Search in the result list
        Optional<BookData> searchedBook = booksData.getResults().stream()
                .filter(b -> b.title().toUpperCase().contains(bookName.toUpperCase()))
                .findFirst();

        if (searchedBook.isPresent()) {
            System.out.println(searchedBook.get());
            return searchedBook.get();
        } else {
            System.out.println("Libro no encontrado :(");
            return null;
        }
    }

    private void searchAndSaveABook() {
        BookData newBookData = getBookData();
        Book book = new Book(newBookData);
        //Here we create the data in the DB
        bookRepository.save(book);
        System.out.println("Libro encontrado: " + book.getTitle().toUpperCase());
    }

    private void showAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        System.out.println("Libros registrados");
        books.stream().map(Book::toString).forEach(System.out::println);
    }

    private void showAllAuthors() {
        List<Author> authors = bookRepository.getAllAuthors();
        System.out.println("Autores registrados:");
        authors.stream().map(Author::toString).forEach(System.out::println);
    }

    private void showAllAuthorsAliveInCertainYear() {
        System.out.println("Ingresa el año: ");
        Integer year = keyboard.nextInt();
        List<Author> authors = bookRepository.getAllAuthorsAliveInDeterminedYear(year);
        if (authors.isEmpty()) {
            System.out.println("No hay autores vivos en este año");
        } else {
            System.out.println("Autores Vivos:");
            authors.stream().map(Author::toString).forEach(System.out::println);
        }
    }


}
