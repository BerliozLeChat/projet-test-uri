package org.eclipse.emf.common.util;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
        assertTrue(URI.validScheme("test"));
    }

    @Test
    public void testValidScheme2() {
        assertTrue(URI.validScheme(null));
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
        assertTrue(URI.validSegment("test"));
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
        String[] list = {"", "?"};
        assertFalse(URI.validSegments(list));
    }

    @Test
    public void testValidSegments2() {
        String[] list = {"", "ok"};
        assertTrue(URI.validSegments(list));
    }

    @Test
    public void testValidSegments3() {
        String[] list = {};
        assertTrue(URI.validSegments(list));
    }

    @Test
    public void testValidOpaquePart1() {
        assertFalse(URI.validOpaquePart(null));
    }

    @Test
    public void testValidOpaquePart2() {
        assertFalse(URI.validOpaquePart(""));
    }

    @Test
    public void testValidOpaquePart3() {
        assertFalse(URI.validOpaquePart("#"));
    }

    @Test
    public void testValidOpaquePart4() {
        assertFalse(URI.validOpaquePart("/"));
    }

    @Test
    public void testValidOpaquePart5() {
        assertTrue(URI.validOpaquePart(" /"));
    }

    @Test
    public void testValidAuthority1() {
        assertTrue(URI.validAuthority(null));
    }

    @Test
    public void testValidAuthority2() {
        assertTrue(URI.validAuthority(""));
    }

    @Test
    public void testValidAuthority3() {
        assertFalse(URI.validAuthority("?"));
    }

    @Test
    public void testValidAuthority4() {
        assertFalse(URI.validAuthority("#"));
    }

    @Test
    public void testValidAuthority5() {
        assertFalse(URI.validAuthority("/"));
    }

    @Test
    public void testValidArchiveAuthority1() {
        assertFalse(URI.validArchiveAuthority(""));
    }

    @Test
    public void testValidArchiveAuthority2() {
        assertFalse(URI.validArchiveAuthority(null));
    }

    @Test
    public void testValidArchiveAuthority3() {
        assertFalse(URI.validArchiveAuthority("test"));
    }

    @Test
    public void testValidArchiveAuthority4() {
        assertTrue(URI.validArchiveAuthority("test!"));
    }

    @Test
    public void testValidDevice1() {
        assertFalse(URI.validDevice("test"));
    }

    @Test
    public void testValidDevice2() {
        assertTrue(URI.validDevice(null));
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
        assertTrue(URI.validDevice("test:"));
    }

    @Test
    public void testValidQuery1() {
        assertFalse(URI.validQuery("#"));
    }

    @Test
    public void testValidQuery2() {
        assertTrue(URI.validQuery("test"));
    }

    @Test
    public void testValidQuery3() {
        assertTrue(URI.validQuery(null));
    }

    @Test
    public void testValidFragment() {
        assertTrue(URI.validFragment("test"));
    }


    @Test
    public void testIsHierarchical1() {
        assertTrue(URI.createURI("test").isHierarchical());
    }

    @Test
    public void testisHierarchical2() throws Exception {
        assertFalse(URI.createGenericURI("test", "test", "test").isHierarchical());
    }

    @Test
    public void testHasAuthority1() {
        assertTrue(URI.createHierarchicalURI("test", "test", null, "test", "test").hasAuthority());
    }

    @Test
    public void testHasAuthority2() {
        assertFalse(URI.createGenericURI("test", "test", "test").hasAuthority());
    }

    @Test
    public void testHasOpaquePart1() {
        assertFalse(URI.createURI("test").hasOpaquePart());
    }

    @Test
    public void testHasOpaquePart2() {
        assertTrue(URI.createGenericURI("test", "test", "test").hasOpaquePart());
    }

    @Test
    public void testHasDevice1() {
        assertFalse(URI.createURI("test").hasDevice());
    }

    @Test
    public void testHasDevice2() {
        assertTrue(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .hasDevice());
    }

    @Test
    public void testhasPath1() {
        assertTrue(URI.createPlatformPluginURI
                ("pathName", true).hasPath());
    }

    @Test
    public void testHasPath2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .hasPath());
    }

    @Test
    public void testhasAbsolutePath1() {
        assertTrue(URI.createHierarchicalURI("test", "test", ":", null,
                "test", "test") .hasAbsolutePath());
    }


    @Test
    public void testhasAbsolutePath2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .hasAbsolutePath());
    }

    @Test
    public void testhasRelativePath1() {
        assertTrue(URI.createFileURI("pathName").hasRelativePath());
    }

    @Test
    public void testhasRelativePath2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .hasRelativePath());
    }

    @Test
    public void testhasEmptyPath1() {
        assertTrue(URI.createHierarchicalURI(null, "test", "test").hasEmptyPath());
    }

    @Test
    public void testhasEmptyPath2() {
        assertTrue(URI.createFileURI("").hasEmptyPath());
    }

    @Test
    public void testhasEmptyPath3() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .hasEmptyPath());
    }

    @Test
    public void testhasQuery1() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", null,
                "test") .hasQuery());
    }

    @Test
    public void testhasQuery2() {
        assertTrue(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .hasQuery());
    }

    @Test
    public void testhasFragment1() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                null) .hasFragment());
    }

    @Test
    public void testhasFragment2() {
        assertTrue(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .hasFragment());
    }

    @Test
    public void testisCurrentDocumentReference1() {
        assertTrue(URI.createHierarchicalURI(null, null, null)
                .isCurrentDocumentReference());
    }

    @Test
    public void testisCurrentDocumentReference2() {
        assertFalse(URI.createURI
                ("test") .isCurrentDocumentReference());
    }

    @Test
    public void testisEmpty1() {
        assertTrue(URI.createHierarchicalURI(null,
                null, null) .isEmpty());
    }

    @Test
    public void testisEmpty2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .isEmpty());
    }

    @Test
    public void testisFile1() {
        assertTrue(URI.createFileURI("test").isFile());
    }

    @Test
    public void testisFile2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .isFile());
    }

    @Test
    public void testisPlateform1() {
        assertTrue(URI.createPlatformResourceURI
                ("test",true) .isPlatform());
    }

    @Test
    public void testisPlateform2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .isPlatform());
    }

    @Test
    public void testisPlateformResource1() {
        assertTrue(URI.createPlatformResourceURI("test",true).isPlatformResource());
    }

    @Test
    public void testisPlateformResource2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .isPlatformResource());
    }


    @Test
    public void testisPlateformPlugin1() {
        assertTrue(URI
                .createPlatformPluginURI("test",true) .isPlatformPlugin());
    }

    @Test
    public void testisPlateformPlugin2() {
        assertFalse(URI.createHierarchicalURI("test", "test", ":", "test",
                "test") .isPlatformPlugin());
    }

    @Test
    public void testisArchive1() {
        assertTrue(URI.createHierarchicalURI(URI.SCHEME_JAR, "test!", null,
                null, "test", null) .isArchive());
    }

    @Test
    public void testisArchive2() {
        assertTrue(URI.createHierarchicalURI(URI.SCHEME_ZIP, "test!", null,
                null, "test", null) .isArchive());
    }

    @Test
    public void testisArchive3() {
        assertTrue(URI.createHierarchicalURI(URI.SCHEME_ARCHIVE, "test!",
                null,null, "test", null). isArchive());
    }
    @Test
    public void testisArchive4() {
        assertFalse(URI.createHierarchicalURI("test", "test!", null,null,
                "test", null) .isArchive());
    }

    @Test
    public void testisArchiveScheme1() {
        assertTrue(URI.isArchiveScheme(URI.SCHEME_JAR));
    }

    @Test
    public void testisArchiveScheme2() {
        assertTrue(URI.isArchiveScheme(URI.SCHEME_ZIP));
    }

    @Test
    public void testisArchiveScheme3() {
        assertTrue(URI.isArchiveScheme(URI.SCHEME_ARCHIVE));
    }

    @Test
    public void testisArchiveScheme4() {
        assertFalse(URI.isArchiveScheme("nope"));
    }

    @Test
    public void testEquals1(){
        assertTrue(URI.createURI("test").equals(URI.createURI("test")));
    }
/*
    @Test
    public void testEquals2(){
        URI test=URI.createURI("not");
        assertFalse(URI.createURI("test").equals(test));
    }
*/
    //TODO SegmentEqual
    @Test
    public void testSegmentEqual1(){
        String[] test = {"test"};
        assertTrue(URI.createHierarchicalURI(test,"test","test")
                .segmentsEqual(URI.createHierarchicalURI(test,null,null)));
    }
/*
    @Test
    public void testSegmentEqual2(){
        String[] test = {"test"};
        String[] nope = {"nope"};
        assertFalse(URI.createHierarchicalURI(test,"test","test").segmentsEqual(URI.createHierarchicalURI(nope,null,null)));
    }

    @Test
    public void testSegmentEqual3(){
        String[] test = {"test"};
        assertFalse(URI.createHierarchicalURI(test,"test","test").segmentsEqual(URI.createURI("nope")));
    }

*/

    @Test
    public void testScheme1() {
        URI uri = URI.createURI("toto/test/tata");
        assertEquals(uri.scheme(), null);
    }

    @Test
    public void testScheme2() {
        URI uri = URI.createURI("scheme://toto/test/tata");
        assertEquals(uri.scheme(), "scheme");
    }

    @Test
    public void testOpaquePart1() {
        URI uri = URI.createURI("toto/test/tata");
        assertEquals(uri.opaquePart(), null);
    }

    @Test
    public void testOpaquePart2() {
        URI uri = URI.createGenericURI("scheme", "opaquePart", "fragment");
        assertEquals(uri.opaquePart(), "opaquePart");
    }

    @Test
    public void testAuthority1() {
        String[] segments = { "s1", "s2" };
        URI uri = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals(uri.authority(), null);
    }

    @Test
    public void testAuthority2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                "query", "fragment");
        assertEquals(uri.authority(), "authority");
    }

    @Test
    public void testUserInfo1() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                "query", "fragment");
        assertEquals(uri.userInfo(), null);
    }

    @Test
    public void testUserInfo2() {
        URI uri = URI.createHierarchicalURI("scheme", "user@authority",
                "device:", "query", "fragment");
        assertEquals(uri.userInfo(), "user");
    }

    @Test
    public void testHost1() {
        URI uri = URI.createHierarchicalURI("scheme", null, "device:",
                "query", "fragment");
        assertEquals(uri.host(), null);
    }

    @Test
    public void testHost2() {
        URI uri = URI.createHierarchicalURI("scheme", "user@host:port",
                "device:", "query", "fragment");
        assertEquals(uri.host(), "host");
    }

    @Test
    public void testPort1() {
        URI uri = URI.createHierarchicalURI("scheme", "user@host", "device:",
                "query","fragment");
        assertEquals(uri.port(), null);
    }

    @Test
    public void testPort2() {
        URI uri = URI.createHierarchicalURI("scheme", "user@host:port",
                "device:", "query", "fragment");
        assertEquals(uri.port(), "port");
    }

    @Test
    public void testDevice1() {
        URI uri = URI.createHierarchicalURI("scheme", "user@host", null,
                "query","fragment");
        assertEquals(uri.device(), null);
    }

    @Test
    public void testDevice2() {
        URI uri = URI.createHierarchicalURI("scheme", "user@host", "device:",
                "query", "fragment");
        assertEquals(uri.device(), "device:");
    }

    @Test
    public void testSegments1() {
        String[] vide = {};
        String[] segments = {};
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");

        assertArrayEquals(vide, uri.segments());
    }

    @Test
    public void testSegments2() {
        String[] segments = { "foo", "bar" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        String[] s = { "foo", "bar" };
        assertArrayEquals(s, uri.segments());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testSegmentsList1() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        List<String> s = uri.segmentsList();
        s.add("test");//la liste est non modifiable : exception
    }

    @Test
    public void testSegmentsList2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        List<String> s = new ArrayList<String>();
        s.add("toto");
        s.add("titi");
        assertEquals(s, uri.segmentsList());
    }

    @Test
    public void testSegmentCount1() {
        String[] segments = { "test" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        assertEquals(1, uri.segmentCount());
    }

    @Test
    public void testSegmentCount2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                null, "query", "fragment");

        assertEquals(0, uri.segmentCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSegment1() {
        String[] segments = { "test" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri.segment(1);
    }

    @Test
    public void testSegment2() {
        String[] segments = { "test" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        assertEquals("test", uri.segment(0));
    }

    @Test
    public void testLastSegment1() {
        String[] segments = {};
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        assertEquals(null, uri.lastSegment());
    }

    @Test
    public void testLastSegment2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        assertEquals("titi", uri.lastSegment());
    }

    @Test
    public void testLastSegment3() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                null, "query", "fragment");
        assertEquals(null, uri.lastSegment());
    }

    @Test
    public void testPath1() {
        URI uri = URI.createGenericURI("scheme", "opaquePart", "fragment");
        assertEquals(null, uri.path());
    }

    @Test
    public void testPath2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        assertEquals("/toto/titi", uri.path());
    }

    @Test
    public void testDevicePath1() {
        URI uri = URI.createURI("test:test");
        assertEquals(null, uri.devicePath());
    }

    @Test
    public void testDevicePath2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", null,
                segments, "query", "fragment");
        assertEquals("//authority/toto/titi", uri.devicePath());
    }

    @Test
    public void testDevicePath3() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", null, "device:",
                segments, "query", "fragment");
        assertEquals("device:/toto/titi", uri.devicePath());
    }

    @Test
    public void testDevicePath4() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        assertEquals("//authority/device:/toto/titi", uri.devicePath());
    }

    @Test
    public void testQuery1() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                null, null, "fragment");
        assertEquals(null, uri.query());
    }

    @Test
    public void testQuery2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                null, "query", "fragment");
        assertEquals("query", uri.query());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendQuery1() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 null, "fragment");
        uri = uri.appendQuery("query#query");
    }
/*
    @Test
    public void testAppendQuery2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", "fragment");
        uri = uri.appendQuery("newquery");
        assertEquals("newquery", uri.query());
    }

    @Test
    public void testAppendQuery3() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 null, "fragment");
        uri = uri.appendQuery("query");
        assertEquals("query", uri.query());
    }
*/
    @Test
    public void testTrimQuery1() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 null, "fragment");
        URI new_uri = uri.trimQuery();
        assertEquals(uri, new_uri);
    }

    @Test
    public void testTrimQuery2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", "fragment");
        uri = uri.trimQuery();
        assertEquals("scheme://authority/device:#fragment",
                uri.toString());
    }

    @Test
    public void testFragment1() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", "fragment");
        assertEquals("fragment", uri.fragment());
    }

    @Test
    public void testFragment2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", null);
        assertEquals(null, uri.fragment());
    }

    @Test
    public void testAppendFragment1() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", null);
        uri = uri.appendFragment("fragment");
        assertEquals("fragment", uri.fragment());
    }

    @Test
    public void testAppendFragment2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", "fragment");
        uri = uri.appendFragment("newfragment");
        assertEquals("newfragment", uri.fragment());
    }

    @Test
    public void testTrimFragment1() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", null);
        URI new_uri = uri.trimFragment();
        assertEquals(uri, new_uri);
    }

    @Test
    public void testTrimFragment2() {
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                 "query", "fragment");
        uri = uri.trimFragment();
        assertEquals("scheme://authority/device:?query",
                uri.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResolve1() {
        String[] segments = { "toto", "titi" };
        URI base = URI.createHierarchicalURI(segments, "query", "fragment");
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri.resolve(base);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResolve2() {
        String[] segments = { "toto", "titi" };
        URI base = URI.createURI("here");
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri.resolve(base);
    }

    @Test
    public void testResolve3() {
        String[] segments = { "toto", "titi" };
        URI base = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        URI uri = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals("scheme://authority/device:/toto/toto/titi?query" +
                        "#fragment", uri.resolve(base).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResolveBoolean1() {
        String[] segments = { "toto", "titi" };
        URI base = URI.createHierarchicalURI(segments, "query", "fragment");
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri.resolve(base, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testResolveBoolean2() {
        String[] segments = { "toto", "titi" };
        URI base = URI.createURI("here");
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri.resolve(base, true);
    }

    @Test
    public void testResolveBoolean3() {
        String[] segments = { "toto", "titi" };
        URI base = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        URI uri = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals("scheme://authority/device:/toto/toto/titi?query" +
                        "#fragment",uri.resolve(base, true).toString());
    }

    @Test
    public void testResolveBoolean4() {
        String[] segments = { "toto", "titi" };
        URI base = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        URI uri = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals("scheme://authority/device:/toto/toto/titi?query" +
                        "#fragment",
                uri.resolve(base, false).toString());
    }

    @Test
    public void testDeresolve1() {
        URI uri = URI.createURI("scheme://authority/device:/test/test/toto?query" +
                        "#fragment");
        URI base = URI.createURI("here");
        assertEquals(uri.toString(), uri.deresolve(base).toString());
    }

    @Test
    public void testDeresolve2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createURI("scheme://authority/device:/toto/titi/bar?query" +
                        "#fragment");
        URI base = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals(uri.toString(), uri.deresolve(base).toString());
    }

    @Test
    public void testDeresolve3() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createURI("scheme://authority/device:/toto/toto/titi?query" +
                        "#fragment");
        URI base = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        URI exp_uri = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals(exp_uri.toString(), uri.deresolve(base).toString());
    }

    @Test
    public void testDeresolveBoolean1() {
        URI uri = URI
                .createURI("scheme://authority/device:/toto/toto/titi?query" +
                        "#fragment");
        URI base = URI.createURI("test");
        assertEquals(uri.toString(),
                uri.deresolve(base, true, true, true).toString());
    }

    @Test
    public void testDeresolveBoolean2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createURI("scheme://authority!/device:/toto/toto/titi?query" +
                        "#fragment");
        URI base = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals(uri.toString(),
                uri.deresolve(base, true, true, true).toString());
    }

    @Test
    public void testDeresolveBoolean3() {
        String[] segments = { "toto", "titi" };
        URI uri = URI
                .createURI("scheme://authority/device:/toto/toto/titi?query" +
                        "#fragment");
        URI base = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        assertFalse(uri.deresolve(base, true, false, true)
                .hasAbsolutePath());
    }

    @Test
    public void testDeresolveBoolean4() {
        String[] segments = { "toto", "titi" };
        URI uri = URI
                .createURI("scheme://authority/device:/toto/toto/titi?query" +
                        "#fragment");
        URI base = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        URI exp_uri = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals(exp_uri.toString(),
                uri.deresolve(base, true, false, true).toString());
    }

    @Test
    public void testToFileString1() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI(segments, "query", "fragment");
        assertEquals(null, uri.toFileString());
    }

    @Test
    public void testToFileString2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI(segments, null, "fragment");
        assertEquals("s1/s2", uri.toFileString());
    }

    @Test
    public void testToPlateformString1() {
        URI uri = URI.createURI("platform:/project-name");
        assertEquals(null, uri.toPlatformString(true));
    }

    @Test
    public void testToPlateformString2() {
        URI uri = URI.createURI("platform:/project-name/path%23");
        assertEquals("/path#", uri.toPlatformString(true));
    }

    @Test
    public void testToPlateformString3() {
        URI uri = URI.createURI("platform:/project-name/path%23");
        assertEquals("/path%23", uri.toPlatformString(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSegment1() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri = uri.appendSegment("tata/");//segment invalide
    }

    @Test
    public void testAppendSegment2() {
        String[] segments = { "toto", "titi" };
        String[] s = { "toto", "titi", "tata" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri = uri.appendSegment("tata");
        assertArrayEquals(s, uri.segments());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSegments1() {
        String[] segments = { "toto", "titi" };
        String[] s = { "tutu","tata/" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri = uri.appendSegments(s);
    }

    @Test
    public void testAppendSegments2() {
        String[] segments = { "toto", "titi" };
        String[] s = { "tutu","tata" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri = uri.appendSegments(s);
        String[] all = { "toto", "titi","tutu","tata" };
        assertArrayEquals(all, uri.segments());
    }

    @Test
    public void testTrimSegments1() {
        String[] segments = {};
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        URI new_uri = uri.trimSegments(1);
        assertEquals(uri, new_uri);
    }

    @Test
    public void testTrimSegments2() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri = uri.trimSegments(3);
        String[] s = {};
        assertArrayEquals(s, uri.segments());
    }

    @Test
    public void testTrimSegments3() {
        String[] segments = { "toto", "titi" };
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        uri = uri.trimSegments(1);
        String[] s = {"toto"};
        assertArrayEquals(s, uri.segments());
    }

    @Test
    public void testTrimSegments4() {
        String[] segments = {"tutu"};
        URI uri = URI.createHierarchicalURI("scheme", "authority", "device:",
                segments, "query", "fragment");
        URI new_uri = uri.trimSegments(0);
        assertEquals(uri, new_uri);
    }
}