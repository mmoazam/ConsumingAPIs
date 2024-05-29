package org.northcoders;

import org.northcoders.dao.FakeBooksDAO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        try {
           var response = FakeBooksDAO.getBooks(4);
            System.out.println(response.status());
            System.out.println(response.code());

            for (var book : response.books()) {
                System.out.println(book.title());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}