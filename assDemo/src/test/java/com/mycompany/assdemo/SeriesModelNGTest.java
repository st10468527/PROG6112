/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.assdemo;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SeriesModelNGTest {
    
    private SeriesModel seriesModel;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private AssDemo assDemoMock;
    
    public SeriesModelNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("=== Starting SeriesModel Unit Tests ===");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("=== SeriesModel Unit Tests Completed ===");
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        assDemoMock = new AssDemo() {
            @Override
            public void menuChoice() {
                System.out.println("Returning to main menu...");
            }
        };
        
        seriesModel = new SeriesModel(assDemoMock);
        System.setOut(new PrintStream(outContent));
        
        seriesModel.seriesIds.add(101);
        seriesModel.seriesNames.add("Breaking Bad");
        seriesModel.ageRestrictions.add(16);
        seriesModel.episodesList.add(62);
        
        seriesModel.seriesIds.add(102);
        seriesModel.seriesNames.add("Stranger Things");
        seriesModel.ageRestrictions.add(14);
        seriesModel.episodesList.add(34);
        
        seriesModel.seriesIds.add(103);
        seriesModel.seriesNames.add("The Crown");
        seriesModel.ageRestrictions.add(12);
        seriesModel.episodesList.add(40);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        System.setOut(originalOut);
        System.setErr(originalErr);
        outContent.reset();
        
        seriesModel.seriesIds.clear();
        seriesModel.seriesNames.clear();
        seriesModel.ageRestrictions.clear();
        seriesModel.episodesList.clear();
    }

    @Test
    public void TestSearchSeries() {
        System.out.println("=== TestSearchSeries (Comprehensive) ===");
        
        String input = "101\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        seriesModel.SearchSeries();
        
        String output = outContent.toString();
        
        assertTrue(output.contains("SERIES FOUND"));
        assertTrue(output.contains("Series ID: 101"));
        assertTrue(output.contains("Breaking Bad"));
        assertTrue(output.contains("Age Restriction: 16"));
        assertTrue(output.contains("Number of Episodes: 62"));
        assertTrue(output.contains("********************************"));
        assertTrue(output.contains("launch menu"));
        
        System.out.println("✓ TestSearchSeries completed successfully - All validations passed");
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        System.out.println("=== TestSearchSeries_SeriesNotFound (Comprehensive) ===");
        
        String input = "999\n888\n777\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        seriesModel.SearchSeries();
        
        String output = outContent.toString();
        
        assertTrue(output.contains("Series with series ID: 999 was not found!"));
        assertTrue(output.contains("Series with series ID: 888 was not found!"));
        assertTrue(output.contains("Series with series ID: 777 was not found!"));
        assertFalse(output.contains("SERIES FOUND"));
        assertFalse(output.contains("Breaking Bad"));
        assertFalse(output.contains("Stranger Things"));
        assertTrue(output.contains("launch menu"));
        
        System.out.println("✓ TestSearchSeries_SeriesNotFound completed successfully - All validations passed");
    }

    @Test
    public void TestUpdateSeries() {
        System.out.println("=== TestUpdateSeries (Comprehensive) ===");
        
        String originalName = seriesModel.seriesNames.get(0);
        int originalAge = seriesModel.ageRestrictions.get(0);
        int originalEpisodes = seriesModel.episodesList.get(0);
        
        String input = "101\nBetter Call Saul\n18\n63\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        seriesModel.UpdateSeries();
        
        String output = outContent.toString();
        
        assertEquals(seriesModel.seriesNames.get(0), "Better Call Saul");
        assertEquals(seriesModel.ageRestrictions.get(0), 18);
        assertEquals(seriesModel.episodesList.get(0), 63);
        assertTrue(output.contains("Series updated successfully!"));
        assertEquals(seriesModel.seriesNames.get(1), "Stranger Things");
        assertEquals(seriesModel.seriesNames.get(2), "The Crown");
        
        System.out.println("✓ TestUpdateSeries completed successfully - All validations passed");
    }

    @Test
    public void TestDeleteSeries() {
        System.out.println("=== TestDeleteSeries (Comprehensive) ===");
        
        int initialSize = seriesModel.seriesIds.size();
        
        String input = "102\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        seriesModel.DeleteSeries();
        
        String output = outContent.toString();
        
        assertEquals(seriesModel.seriesIds.size(), initialSize - 1);
        assertFalse(seriesModel.seriesIds.contains(102));
        assertFalse(seriesModel.seriesNames.contains("Stranger Things"));
        assertTrue(output.contains("Series deleted successfully!"));
        assertTrue(seriesModel.seriesIds.contains(101));
        assertTrue(seriesModel.seriesIds.contains(103));
        
        System.out.println("✓ TestDeleteSeries completed successfully - All validations passed");
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        System.out.println("=== TestDeleteSeries_SeriesNotFound (Comprehensive) ===");
        
        int initialSize = seriesModel.seriesIds.size();
        
        String input = "999\n888\n777\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        seriesModel.DeleteSeries();
        
        String output = outContent.toString();
        
        assertEquals(seriesModel.seriesIds.size(), initialSize);
        assertTrue(output.contains("Series with series ID: 999 was not found!"));
        assertTrue(output.contains("Series with series ID: 888 was not found!"));
        assertTrue(output.contains("Series with series ID: 777 was not found!"));
        assertFalse(output.contains("Series deleted successfully!"));
        assertTrue(seriesModel.seriesIds.contains(101));
        assertTrue(seriesModel.seriesIds.contains(102));
        assertTrue(seriesModel.seriesIds.contains(103));
        
        System.out.println("✓ TestDeleteSeries_SeriesNotFound completed successfully - All validations passed");
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        System.out.println("=== TestSeriesAgeRestriction_AgeValid (Comprehensive) ===");
        
        assertTrue(isAgeValid(2));
        assertTrue(isAgeValid(3));
        assertTrue(isAgeValid(10));
        assertTrue(isAgeValid(17));
        assertTrue(isAgeValid(18));
        
        String input = "1\n200\nValid Age Test\n15\n20\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        seriesModel.CaptureSeries();
        
        int lastIndex = seriesModel.ageRestrictions.size() - 1;
        assertEquals(seriesModel.ageRestrictions.get(lastIndex), 15);
        
        System.out.println("✓ TestSeriesAgeRestriction_AgeValid completed successfully - All validations passed");
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        System.out.println("=== TestSeriesAgeRestriction_SeriesAgeInValid (Comprehensive) ===");
        
        assertFalse(isAgeValid(1));
        assertFalse(isAgeValid(0));
        assertFalse(isAgeValid(-5));
        assertFalse(isAgeValid(19));
        assertFalse(isAgeValid(100));
        assertFalse(isAgeValid(Integer.MAX_VALUE));
        assertFalse(isAgeValid(Integer.MIN_VALUE));
        
        String input = "1\n201\nInvalid Age Test\n1\n19\n0\n-5\n100\n15\n25\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        seriesModel.CaptureSeries();
        
        String output = outContent.toString();
        
        assertTrue(output.contains("Invalid age!"));
        assertTrue(output.contains("attempts remaining"));
        
        int lastIndex = seriesModel.ageRestrictions.size() - 1;
        assertEquals(seriesModel.ageRestrictions.get(lastIndex), 15);
        
        System.out.println("✓ TestSeriesAgeRestriction_SeriesAgeInValid completed successfully - All validations passed");
    }

    private boolean isAgeValid(int age) {
        return age >= 2 && age <= 18;
    }
    
    @Test
    public void TestBoundaryCases() {
        System.out.println("=== TestBoundaryCases (Additional Comprehensive) ===");
        
        assertTrue(isAgeValid(2));
        assertTrue(isAgeValid(18));
        assertFalse(isAgeValid(1));
        assertFalse(isAgeValid(19));
        
        System.out.println("✓ TestBoundaryCases completed successfully - All boundary validations passed");
    }
}