package org.eclipse.emf.common.util;

import org.junit.*;

public class URITest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    /*
     * Test de la méthode validScheme
     */
    @Test
    public void testValidScheme1() {
        Assert.assertTrue(URI.validScheme("test"));
    }

    @Test
    public void testValidScheme2() {
        Assert.assertTrue(URI.validScheme(null));
    }

    @Test
    public void testValidScheme3() {
        Assert.assertFalse(URI.validScheme("?"));
    }

    @Test
    public void testValidScheme4() {
        Assert.assertFalse(URI.validScheme("/"));
    }

    @Test
    public void testValidScheme5() {
        Assert.assertFalse(URI.validScheme("#"));
    }
    
    /*
     *
     */
        /*
     * Test de la méthode validSegment
     */
    @Test
    public void testValidSegment1() {
        Assert.assertTrue(URI.validSegment("test"));
    }

    @Test
    public void testValidSegment2() {
        Assert.assertFalse(URI.validSegment(null));
    }

    @Test
    public void testValidSegment3() {
        Assert.assertFalse(URI.validSegment("?"));
    }

    @Test
    public void testValidSegment4() {
        Assert.assertFalse(URI.validSegment("/"));
    }

    @Test
    public void testValidSegment5() {
        Assert.assertFalse(URI.validSegment("#"));
    }

    /*
     * Test de validSegment
     */
    @Test
    public void testValidSegments1() {
        String[] list = {"","?"};
        Assert.assertFalse(URI.validSegments(list));
    }

    @Test
    public void testValidSegments2() {
        String[] list = {"","ok"};
        Assert.assertTrue(URI.validSegments(list));
    }

    @Test
    public void testValidSegments3() {
        String[] list = {};
        Assert.assertTrue(URI.validSegments(list));
    }
}