/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jm.dvdlibrary.ui;

import java.util.Scanner;

/**
 *
 * @author Jess
 */
public class UserIOConsoleImpl implements UserIO {

    @Override
    public void print(String message) {
        System.out.println(message);

    }

    @Override
    public double readDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        String readDoubleString;
        double readDouble;
        System.out.println(prompt);
        readDoubleString = sc.nextLine();
        readDouble = Double.parseDouble(readDoubleString);
        return readDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double readDouble = 0;
        String readDoubleString;
        do {
            System.out.println(prompt);
            readDoubleString = sc.nextLine();
            readDouble = Double.parseDouble(readDoubleString);
        } while (readDouble < min || readDouble > max);

        return readDouble;
    }

    @Override
    public float readFloat(String prompt) {
        Scanner sc = new Scanner(System.in);
        String readFloatString;
        Float readFloat;
        System.out.println(prompt);
        readFloatString = sc.nextLine();
        readFloat = Float.parseFloat(readFloatString);
        return readFloat;

    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        Scanner sc = new Scanner(System.in);
        Float readFloat;
        String readFloatString;
        do {
            System.out.println(prompt);
            readFloatString = sc.nextLine();
            readFloat = Float.parseFloat(readFloatString);
        } while (readFloat < min || readFloat > max);

        return readFloat;
    }

    @Override
    public int readInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        String readIntString;
        int readInt;
        System.out.println(prompt);
        readIntString = sc.nextLine();
        readInt = Integer.parseInt(readIntString);
        return readInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int readInt;
        String readIntString;
        do {
            System.out.println(prompt);
            readIntString = sc.nextLine();
            readInt = Integer.parseInt(readIntString);
        } while (readInt < min || readInt > max);

        return readInt;
    }

    @Override
    public long readLong(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        String readString;
        System.out.println(prompt);
        readString = sc.nextLine();
        return readString;
    }
}
