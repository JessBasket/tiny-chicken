/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jm.dvdlibrary;

import com.jm.dvdlibrary.controller.DvdLibraryController;
import com.jm.dvdlibrary.dao.DvdLibraryDao;
import com.jm.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.jm.dvdlibrary.ui.DvdLibraryView;
import com.jm.dvdlibrary.ui.UserIO;
import com.jm.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author Jess
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();

    }

}
