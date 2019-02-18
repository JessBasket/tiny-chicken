/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jm.dvdlibrary.dao;

import com.jm.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jess
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    private Map<String, Dvd> dvds = new HashMap<>();

    public static final String DVD_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd(String title, Dvd Dvd) 
    throws DvdLibraryDaoException {
        Dvd newDvd = dvds.put(title, Dvd);
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) 
    throws DvdLibraryDaoException {
        Dvd removedDvd = dvds.remove(title);
        return removedDvd;
    }

    @Override
    public Dvd editDvd(String title, Dvd editedDvd) 
    throws DvdLibraryDaoException {
        return dvds.replace(title, editedDvd);
    }

    @Override
    public List<Dvd> getAllDvds() 
    throws DvdLibraryDaoException {
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) 
    throws DvdLibraryDaoException {
        return dvds.get(title);
    }

    @Override
    public boolean searchDvd(String title) 
    throws DvdLibraryDaoException {
        return dvds.containsKey(title);
    }

    /**
     *
     * @throws DvdLibraryDaoException
     */
    @Override
    public void loadDvd() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Cold not load dvd data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Dvd currentDvd = new Dvd(currentTokens[0]);
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setRating(currentTokens[2]);
            currentDvd.setDirector(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setNote(currentTokens[5]);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    /**
     *
     * @throws DvdLibraryDaoException
     */
    @Override
    public void writeDvd() throws DvdLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getRating() + DELIMITER
                    + currentDvd.getDirector() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getNote());
            out.flush();
        }
        out.close();
    }

}
