/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jm.dvdlibrary.dao;

import com.jm.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Jess
 */
public interface DvdLibraryDao {

    Dvd addDvd(String title, Dvd Dvd)
            throws DvdLibraryDaoException;

    Dvd removeDvd(String title)
            throws DvdLibraryDaoException;

    Dvd editDvd(String title, Dvd Dvd)
            throws DvdLibraryDaoException;

    List<Dvd> getAllDvds()
            throws DvdLibraryDaoException;

    Dvd getDvd(String title)
            throws DvdLibraryDaoException;

    boolean searchDvd(String title)
            throws DvdLibraryDaoException;

    void writeDvd()
            throws DvdLibraryDaoException;

    void loadDvd()
            throws DvdLibraryDaoException;

}
