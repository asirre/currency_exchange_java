package com.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Displayer {

    public void mainWindow() throws IOException, SAXException, ParserConfigurationException {

        Scanner scan = new Scanner(System.in);
        Converter converter = new Converter();
        boolean running = true;
        System.out.println("Welcome to online money exchange");
        while(running) {
            System.out.println("to print actual rating choose  1 \nto exchange money choose  2 \nto exit choose choose 3");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    converter.hashMapPrint();
                    break;
                case 2:
                    System.out.println("Provide input currency, outcurrency code and amount");
                    String first_code = scan.next().toUpperCase();
                    String second_code = scan.next().toUpperCase();

                    converter.dataValidation(first_code,second_code, scan.nextInt());

                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Option not covered");
                    break;

            }
        }












    }
}
