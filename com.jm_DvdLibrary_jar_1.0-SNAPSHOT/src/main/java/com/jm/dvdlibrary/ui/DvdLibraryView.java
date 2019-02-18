/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jm.dvdlibrary.ui;

import com.jm.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Jess
 */
public class DvdLibraryView {

    private UserIO io;
    
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("****Main Menu****");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List all DVDs");
        io.print("5. View a DVD");
        io.print("6. Search for a DVD by Title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter the DVD Title.");
        String releaseDate = io.readString("Please enter the DVD Release Date.");
        String rating = io.readString("Please enter the DVD MPAA Rating.");
        String director = io.readString("Please enter the DVD Director.");
        String studio = io.readString("Please enter the DVD Studio.");
        String note = io.readString("Please enter a note or user rating.");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setDirector(director);
        currentDvd.setStudio(studio);
        currentDvd.setNote(note);
        return currentDvd;
    }
    
    public void displayCreateDvdBanner() {
        io.print("**** Add DVD ****");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully added to the library! Please hit enter to continue.");
    }
    
    public void displayDvdList(List<Dvd> DvdList) {
        for (Dvd currentDvd: DvdList) {
            io.print("***********************************************");
            io.print("Title: " + currentDvd.getTitle());
            io.print("Release Date: " + currentDvd.getReleaseDate());
            io.print("MPAA Rating: " + currentDvd.getRating());
            io.print("Director: " + currentDvd.getDirector());
            io.print("Studio: " + currentDvd.getStudio());
            io.print("Note/User Rating: " + currentDvd.getNote());
            io.print("***********************************************");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("**** Display All DVDs ****");
    }
    
    public void displayDisplayDvdBanner() {
        io.print("**** Display DVD ****");
    }
    
    public String getTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }
    
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("***********************************************");
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getRating());
            io.print("Director: " + dvd.getDirector());
            io.print("Studio: " + dvd.getStudio());
            io.print("Note/User Rating: " + dvd.getNote());
            io.print("***********************************************");
        } else {
            io.print("No DVD with matching title found!");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDvdBanner() {
        io.print("**** Remove DVD ****");
    }
    
    public void displayRemoveResultBanner(Dvd dvd) {
        if (dvd != null) {
            io.readString("DVD removed successfully! Please hit enter to continue.");
        } else {
            io.readString("No DVD found with matching title. Could not remove DVD! Please hit enter to continue.");
        }
        
    }
    
    public void displaySearchDvdBanner() {
        io.print("**** Search for DVD by Title ****");
    }
    
    public void searchDvd(boolean dvdFound, String title) {
        if (dvdFound == true) {
            io.print("DVD with title '" + title + "' exists in the DVD Library.");
        } else {
            io.print("DVD with title '" + title + "' could not be found in the DVD Library.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEditDvdBanner() {
        io.print("**** Edit DVD ****");
    }
    
    public Dvd getUpdatedDvdInfo(String title) {
        String releaseDate = io.readString("Please enter the new DVD Release Date.");
        String rating = io.readString("Please enter the new DVD MPAA Rating.");
        String director = io.readString("Please enter the new DVD Director.");
        String studio = io.readString("Please enter the new DVD Studio.");
        String note = io.readString("Please enter a new note or user rating.");
        Dvd editedDvd = new Dvd(title);
        editedDvd.setReleaseDate(releaseDate);
        editedDvd.setRating(rating);
        editedDvd.setDirector(director);
        editedDvd.setStudio(studio);
        editedDvd.setNote(note);
        return editedDvd;
    }
    
    public void displayEditDvdSuccessBanner() {
        io.readString("DVD successfully edited! Please hit enter to continue.");
    }
    
    public void displayEditDvdFailureBanner() {
        io.print("DVD with title provided does not exist in the DVD Library.");
        io.print("DVD could not be edited!");
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!");
    }
    
    public void displayErrorMessage(String errMsg) {
        io.print("**** ERROR ****");
        io.print(errMsg);
    }

}
