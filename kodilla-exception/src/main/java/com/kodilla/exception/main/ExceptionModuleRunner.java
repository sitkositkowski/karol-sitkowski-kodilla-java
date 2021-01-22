package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";
        try {
            fileReader.readFile(fileName);
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file!");
        }

        FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();
        try {
            fileReaderWithoutHandling.readFile();
        } catch (IOException e) {
            System.out.println("Problem while reading a file!");
        }
    }
}