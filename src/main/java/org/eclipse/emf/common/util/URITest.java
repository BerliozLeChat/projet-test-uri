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

    @Test
    public void testValidOpaquePart1(){
        Assert.assertFalse(URI.validOpaquePart(null));
    }

    @Test
    public void testValidOpaquePart2(){
        Assert.assertFalse(URI.validOpaquePart(""));
    }

    @Test
    public void testValidOpaquePart3(){
        Assert.assertFalse(URI.validOpaquePart("#"));
    }

    @Test
    public void testValidOpaquePart4(){
        Assert.assertFalse(URI.validOpaquePart("/"));
    }

    @Test
    public void testValidOpaquePart5(){
        Assert.assertTrue(URI.validOpaquePart(" /"));
    }

    @Test
    public void testValidAuthority1(){
        Assert.assertTrue(URI.validAuthority(null));
    }

    @Test
    public void testValidAuthority2(){
        Assert.assertTrue(URI.validAuthority(""));
    }

    @Test
    public void testValidAuthority3(){
        Assert.assertFalse(URI.validAuthority("?"));
    }

    @Test
    public void testValidAuthority4(){
        Assert.assertFalse(URI.validAuthority("#"));
    }

    @Test
    public void testValidAuthority5(){
        Assert.assertFalse(URI.validAuthority("/"));
    }

    @Test
    public void testValidArchiveAuthority1(){
        Assert.assertFalse(URI.validArchiveAuthority(""));
    }

    @Test
    public void testValidArchiveAuthority2(){
        Assert.assertFalse(URI.validArchiveAuthority(null));
    }

    @Test
    public void testValidArchiveAuthority3(){
        Assert.assertFalse(URI.validArchiveAuthority("test"));
    }

    @Test
    public void testValidArchiveAuthority4(){
        Assert.assertTrue(URI.validArchiveAuthority("test!"));
    }

    @Test
    public void testValidDevice1() {
        Assert.assertFalse(URI.validDevice("test"));
    }

    @Test
    public void testValidDevice2() {
        Assert.assertTrue(URI.validDevice(null));
    }

    @Test
    public void testValidDevice3() {
        Assert.assertFalse(URI.validDevice("?"));
    }

    @Test
    public void testValidDevice4() {
        Assert.assertFalse(URI.validDevice("/"));
    }

    @Test
    public void testValidDevice5() {
        Assert.assertFalse(URI.validDevice("#"));
    }

    @Test
    public void testValidDevice6() {
        Assert.assertFalse(URI.validDevice(""));
    }

    @Test
    public void testValidDevice7() {
        Assert.assertTrue(URI.validDevice("test:"));
    }

    @Test
    public void testValidQuery1() {
        Assert.assertFalse(URI.validQuery("#"));
    }
    @Test
    public void testValidQuery2() {
        Assert.assertTrue(URI.validQuery("test"));
    }
    @Test
    public void testValidQuery3() {
        Assert.assertTrue(URI.validQuery(null));
    }
    @Test
    public void testValidFragment() {
        Assert.assertTrue(URI.validFragment("test"));
    }
    @Test
    public void testIsRelative() {
        //TODO: to do
        Assert.assertFalse(URI.createURI("sdkfsklfds").isRelative());
    }

    @Test
    public void testIsHierarchical1() {
        Assert.assertTrue(URI.createHierarchicalURI("sdkfsklfds", "", "", "", "").isHierarchical());
    }
    @Test
    public void testIsHierarchical2() {
        Assert.assertFalse(URI.createURI("sdkfsklfds").isHierarchical());
    }

    @Test
    public void testHasAuthority1() {
        Assert.assertFalse(URI.createHierarchicalURI(new String[]{}, "", "").hasAuthority());
    }
    @Test
    public void testHasAuthority2() {
        Assert.assertTrue(URI.createHierarchicalURI("", "", "", "", "").hasAuthority());
    }
    @Test
    public void testHasAuthority3() {
        Assert.assertTrue(URI.createHierarchicalURI("", "", "", new String[]{}, "", "").hasAuthority());
    }

    @Test
    public void testHasOpaquePart1() {
        //TODO: to do
    }
    @Test
    public void testHasDevice1() {
        Assert.assertFalse(URI.createHierarchicalURI(new String[]{}, "", "").hasDevice());
    }
    @Test
    public void testHasDevice2() {
        Assert.assertTrue(URI.createHierarchicalURI("", "", "", "", "").hasDevice());
    }
    @Test
    public void testHasPath1() {
        //TODO: to do
    }
}