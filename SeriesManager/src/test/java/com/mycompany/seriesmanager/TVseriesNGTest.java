/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.seriesmanager;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author RC_Student_lab
 */
public class TVseriesNGTest {
    
    public TVseriesNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getTitle method, of class TVseries.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        TVseries instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenre method, of class TVseries.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        TVseries instance = null;
        String expResult = "";
        String result = instance.getGenre();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRating method, of class TVseries.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        TVseries instance = null;
        double expResult = 0.0;
        double result = instance.getRating();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeasons method, of class TVseries.
     */
    @Test
    public void testGetSeasons() {
        System.out.println("getSeasons");
        TVseries instance = null;
        int expResult = 0;
        int result = instance.getSeasons();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalEpisodes method, of class TVseries.
     */
    @Test
    public void testGetTotalEpisodes() {
        System.out.println("getTotalEpisodes");
        TVseries instance = null;
        int expResult = 0;
        int result = instance.getTotalEpisodes();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class TVseries.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        TVseries instance = null;
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenre method, of class TVseries.
     */
    @Test
    public void testSetGenre() {
        System.out.println("setGenre");
        String genre = "";
        TVseries instance = null;
        instance.setGenre(genre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRating method, of class TVseries.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        double rating = 0.0;
        TVseries instance = null;
        instance.setRating(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeasons method, of class TVseries.
     */
    @Test
    public void testSetSeasons() {
        System.out.println("setSeasons");
        int seasons = 0;
        TVseries instance = null;
        instance.setSeasons(seasons);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalEpisodes method, of class TVseries.
     */
    @Test
    public void testSetTotalEpisodes() {
        System.out.println("setTotalEpisodes");
        int totalEpisodes = 0;
        TVseries instance = null;
        instance.setTotalEpisodes(totalEpisodes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class TVseries.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        TVseries instance = null;
        String expResult = "";
        String result = instance.getInfo();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetailedInfo method, of class TVseries.
     */
    @Test
    public void testGetDetailedInfo() {
        System.out.println("getDetailedInfo");
        TVseries instance = null;
        String expResult = "";
        String result = instance.getDetailedInfo();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEpisodesPerSeason method, of class TVseries.
     */
    @Test
    public void testGetEpisodesPerSeason() {
        System.out.println("getEpisodesPerSeason");
        TVseries instance = null;
        double expResult = 0.0;
        double result = instance.getEpisodesPerSeason();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
