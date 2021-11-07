package com.company;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.IsoFields;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
    }

    private static void zad5() {
        System.out.println("Podaj tytul pierwszego utworu");
        String titleOne = scanner.nextLine();
        System.out.println("Podaj tytul czas pierwszego utworu w formacie mm:ss");
        String timeOneInput = scanner.nextLine();
        Integer timeOneTotal = getTotalTimeFromInput(timeOneInput);

        System.out.println("Podaj tytul drugiego utworu");
        String titleTwo = scanner.nextLine();
        System.out.println("Podaj tytul czas drugiego utworu w formacie mm:ss");
        String timeTwoInput = scanner.nextLine();
        Integer timeTwoTotal = getTotalTimeFromInput(timeTwoInput);
        printResult(titleOne, timeOneInput, timeOneTotal, titleTwo, timeTwoInput, timeTwoTotal);
    }

    private static void printResult(String titleOne, String timeOneInput, Integer timeOneTotal, String titleTwo, String timeTwoInput, Integer timeTwoTotal) {
        if(timeOneTotal > timeTwoTotal){
            System.out.println(titleOne + " " + timeOneInput);
            System.out.println(titleTwo + " " + timeTwoInput);
        }else{
            System.out.println(titleTwo + " " + timeTwoInput);
            System.out.println(titleOne + " " + timeOneInput);
        }
        System.out.println("łączny czas "+ timeOneTotal + timeTwoTotal);
    }

    private static Integer getTotalTimeFromInput(String timeInput) {
        Integer timeTotal = Integer.parseInt(timeInput.split(":")[0]) * 60 + Integer.parseInt(timeInput.split(":")[1]);
        return timeTotal;
    }

    private static void zad4() {
        System.out.println("Ile sztuk towaru");
        String pieces = scanner.nextLine();
        double price = 10;
        boolean discount = false;
        calculateDiscount(pieces, price, discount);
    }

    private static void calculateDiscount(String pieces, double price, boolean discount) {
        if(discount){
            if(Integer.parseInt(pieces)>10){
                price = price /2;
            }
        }else{
            price = price * 1.1;
        }
        System.out.println(price);
    }

    private static void zad3() {
        System.out.println("Podaj rok");
        String year = scanner.nextLine();
        Year year1 = Year.of(Integer.parseInt(year));
        isLeapYear(year1);
    }

    private static void isLeapYear(Year year1) {
        if (year1.isLeap()) {
            System.out.println("Rok jest przestępny");
        } else {
            System.out.println("Rok nie jest przestępny");
        }
    }

    private static void zad2() {
        System.out.println("Podaj rok");
        String year = scanner.nextLine();
        System.out.println("Podaj miesiac");
        String month = scanner.nextLine();
        LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 8);
        Integer quarter = date.get(IsoFields.QUARTER_OF_YEAR);
        System.out.println("jest to" + quarter + " tego roku");
    }

    private static void zad1() {
        System.out.println("Podaj imie");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String surName = scanner.nextLine();
        System.out.println("Podaj plec true-kobieta/false-meżczyzna");
        Boolean gender = scanner.nextBoolean();
        printStudentInfo(name, surName, gender);
    }

    static void printStudentInfo(String name, String surName, Boolean gender) {
        if (gender) {
            System.out.println("Studentka: " + name + " " + surName);
        } else {
            System.out.println("Student: " + name + " " + surName);
        }
    }
}
