package org.eclipse.emf.common.util;

import org.junit.*;

import static org.junit.Assert.assertFalse;

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
        assertFalse(URI.validScheme("?"));
    }

    @Test
    public void testValidScheme4() {
        assertFalse(URI.validScheme("/"));
    }

    @Test
    public void testValidScheme5() {
        assertFalse(URI.validScheme("#"));
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
        assertFalse(URI.validSegment(null));
    }

    @Test
    public void testValidSegment3() {
        assertFalse(URI.validSegment("?"));
    }

    @Test
    public void testValidSegment4() {
        assertFalse(URI.validSegment("/"));
    }

    @Test
    public void testValidSegment5() {
        assertFalse(URI.validSegment("#"));
    }

    /*
     * Test de validSegments
     */
    @Test
    public void testValidSegments1() {
        String[] list = {"","?"};
        assertFalse(URI.validSegments(list));
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
        assertFalse(URI.validOpaquePart(null));
    }

    @Test
    public void testValidOpaquePart2(){
        assertFalse(URI.validOpaquePart(""));
    }

    @Test
    public void testValidOpaquePart3(){
        assertFalse(URI.validOpaquePart("#"));
    }

    @Test
    public void testValidOpaquePart4(){
        assertFalse(URI.validOpaquePart("/"));
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
        assertFalse(URI.validAuthority("?"));
    }

    @Test
    public void testValidAuthority4(){
        assertFalse(URI.validAuthority("#"));
    }

    @Test
    public void testValidAuthority5(){
        assertFalse(URI.validAuthority("/"));
    }

    @Test
    public void testValidArchiveAuthority1(){
        assertFalse(URI.validArchiveAuthority(""));
    }

    @Test
    public void testValidArchiveAuthority2(){
        assertFalse(URI.validArchiveAuthority(null));
    }

    @Test
    public void testValidArchiveAuthority3(){
        assertFalse(URI.validArchiveAuthority("test"));
    }

    @Test
    public void testValidArchiveAuthority4(){
        Assert.assertTrue(URI.validArchiveAuthority("test!"));
    }

    @Test
    public void testValidDevice1() {
        assertFalse(URI.validDevice("test"));
    }

    @Test
    public void testValidDevice2() {
        Assert.assertTrue(URI.validDevice(null));
    }

    @Test
    public void testValidDevice3() {
        assertFalse(URI.validDevice("?"));
    }

    @Test
    public void testValidDevice4() {
        assertFalse(URI.validDevice("/"));
    }

    @Test
    public void testValidDevice5() {
        assertFalse(URI.validDevice("#"));
    }

    @Test
    public void testValidDevice6() {
        assertFalse(URI.validDevice(""));
    }

    @Test
    public void testValidDevice7() {
        Assert.assertTrue(URI.validDevice("test:"));
    }

    @Test
    public void testValidQuery1() {
        assertFalse(URI.validQuery("#"));
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
    public void testIsHierarchical1() {
        Assert.assertTrue(URI.createURI("test").isHierarchical());
    }

    @Test
    public void testisHierarchical2() throws Exception {
        Assert.assertFalse(URI.createGenericURI("test", "test","test").isHierarchical());
    }

    @Test
    public void testHasAuthority1() {
        Assert.assertTrue(URI.createHierarchicalURI("test", "test", null, "test", "test").hasAuthority());
    }
    @Test
    public void testHasAuthority2() {
        Assert.assertFalse(URI.createGenericURI("test", "test","test").hasAuthority());
    }

    @Test
    public void testHasOpaquePart1() {
        Assert.assertFalse(URI.createURI("test").hasOpaquePart());
    }

    @Test
    public void testHasOpaquePart2() {
        Assert.assertTrue(URI.createGenericURI("test", "test","test").hasOpaquePart());
    }

    @Test
    public void testHasDevice1() {
        Assert.assertFalse(URI.createURI("test").hasDevice());
    }

    @Test
    public void testHasDevice2() {
        Assert.assertTrue(URI.createHierarchicalURI("test", "test", ":", "test", "test").hasDevice());
    }

    @Test
    public void testhasPath1() throws Exception {
        Assert.assertTrue(URI.createPlatformPluginURI("pathName",true).hasPath());
    }

    @Test
    public void testHasPath2() {
        Assert.assertFalse(URI.createHierarchicalURI("test", "test", ":", "test", "test").hasPath());
    }
}