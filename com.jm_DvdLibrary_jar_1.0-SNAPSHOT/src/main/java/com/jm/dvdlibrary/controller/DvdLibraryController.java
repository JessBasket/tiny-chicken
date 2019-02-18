/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jm.dvdlibrary.controller;

import com.jm.dvdlibrary.dao.DvdLibraryDao;
import com.jm.dvdlibrary.dao.DvdLibraryDaoException;
import com.jm.dvdlibrary.dto.Dvd;
import com.jm.dvdlibrary.ui.DvdLibraryView;
import java.util.List;

/**
 *
 * @author Jess
 */
public class DvdLibraryController {

    DvdLibraryDao dao;
    DvdLibraryView view;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            loadFile();
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        findDvd();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            writeFile();
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> DvdList = dao.getAllDvds();
        view.displayDvdList(DvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        dao.removeDvd(title);
        view.displayRemoveResultBanner(dvd);
    }

    private void findDvd() throws DvdLibraryDaoException {
        view.displaySearchDvdBanner();
        String title = view.getTitleChoice();
        boolean dvdFound = dao.searchDvd(title);
        view.searchDvd(dvdFound, title);
    }

    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String title = view.getTitleChoice();
        boolean dvdFound = dao.searchDvd(title);
        if (dvdFound == true) {
            Dvd editedDvd = view.getUpdatedDvdInfo(title);
            dao.editDvd(title, editedDvd);
            view.displayEditDvdSuccessBanner();
        } else {
            view.displayEditDvdFailureBanner();
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void loadFile() throws DvdLibraryDaoException {
        dao.loadDvd();
    }

    private void writeFile() throws DvdLibraryDaoException {
        dao.writeDvd();
    }
}
