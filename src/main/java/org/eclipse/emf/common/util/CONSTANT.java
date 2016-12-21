package org.eclipse.emf.common.util;

import static org.eclipse.emf.common.util.URI.highBitmask;
import static org.eclipse.emf.common.util.URI.lowBitmask;

public class CONSTANT {
    /**
     * A pool for managing {@link URI} instances.
     */
    protected static final URIPool POOL = new URIPool(CommonUtil.REFERENCE_CLEARING_QUEUE);


    // Identifies a file-type absolute URI.
    protected static final String SCHEME_FILE = "file";
    protected static final String SCHEME_JAR = "jar";
    protected static final String SCHEME_ZIP = "zip";
    protected static final String SCHEME_ARCHIVE = "archive";
    protected static final String SCHEME_PLATFORM = "platform";
    protected static final String SCHEME_HTTP = "http";

    protected static final int SCHEME_FILE_HASH_CODE = SCHEME_FILE.hashCode();
    protected static final int SCHEME_JAR_HASH_CODE = SCHEME_JAR.hashCode();
    protected static final int SCHEME_ZIP_HASH_CODE = SCHEME_ZIP.hashCode();
    protected static final int SCHEME_ARCHIVE_HASH_CODE = SCHEME_ARCHIVE.hashCode();
    protected static final int SCHEME_PLATFORM_HASH_CODE = SCHEME_PLATFORM.hashCode();
    protected static final int SCHEME_HTTP_HASH_CODE = SCHEME_HTTP.hashCode();

    // Special segment values interpreted at resolve and resolve time.
    protected static final String SEGMENT_EMPTY = "";
    protected static final String SEGMENT_SELF = ".";
    protected static final String SEGMENT_PARENT = "..";

    // Special segments used for platform URIs.
    protected static final String SEGMENT_PLUGIN = "plugin";
    protected static final String SEGMENT_RESOURCE = "resource";

    // Special arrays uses for segments
    protected static final String[] NO_SEGMENTS = SegmentSequence.EMPTY_ARRAY;
    protected static final String[] ONE_EMPTY_SEGMENT = SegmentSequence.EMPTY_STRING_ARRAY;
    protected static final String[] ONE_SELF_SEGMENT = SegmentSequence.STRING_ARRAY_POOL.intern(SEGMENT_SELF, false);

    // Separators for parsing a URI string.
    protected static final char SCHEME_SEPARATOR = ':';
    protected static final String AUTHORITY_SEPARATOR = "//";
    protected static final int AUTHORITY_SEPARATOR_HASH_CODE = AUTHORITY_SEPARATOR.hashCode();
    protected static final char DEVICE_IDENTIFIER = ':';
    protected static final char SEGMENT_SEPARATOR = '/';
    protected static final char QUERY_SEPARATOR = '?';
    protected static final char FRAGMENT_SEPARATOR = '#';
    protected static final char USER_INFO_SEPARATOR = '@';
    protected static final char PORT_SEPARATOR = ':';
    protected static final char FILE_EXTENSION_SEPARATOR = '.';
    protected static final char ARCHIVE_IDENTIFIER = '!';
    protected static final String ARCHIVE_SEPARATOR = "!/";

    // Characters to use in escaping.
    protected static final char ESCAPE = '%';
    protected static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    // Some character classes, as defined in RFC 2396's BNF for URI.
    // These are 128-bit bitmasks, stored as two longs, where the Nth bit is set
    // iff the ASCII character with value N is included in the set.  These are
    // created with the highBitmask() and lowBitmask() methods defined below,
    // and a character is tested against them using matches().
    //
    protected static final long ALPHA_HI = highBitmask('a', 'z') | highBitmask('A', 'Z');
    protected static final long ALPHA_LO = lowBitmask('a', 'z') | lowBitmask('A', 'Z');
    protected static final long DIGIT_HI = highBitmask('0', '9');
    protected static final long DIGIT_LO = lowBitmask('0', '9');
    protected static final long ALPHANUM_HI = ALPHA_HI | DIGIT_HI;
    protected static final long ALPHANUM_LO = ALPHA_LO | DIGIT_LO;
    protected static final long HEX_HI = DIGIT_HI | highBitmask('A', 'F') | highBitmask('a', 'f');
    protected static final long HEX_LO = DIGIT_LO | lowBitmask('A', 'F') | lowBitmask('a', 'f');
    protected static final long UNRESERVED_HI = ALPHANUM_HI | highBitmask("-_.!~*'()");
    protected static final long UNRESERVED_LO = ALPHANUM_LO | lowBitmask("-_.!~*'()");
    protected static final long RESERVED_HI = highBitmask(";/?:@&=+$,");
    protected static final long RESERVED_LO = lowBitmask(";/?:@&=+$,");
    protected static final long URIC_HI = RESERVED_HI | UNRESERVED_HI;  // | ucschar | escaped
    protected static final long URIC_LO = RESERVED_LO | UNRESERVED_LO;

    // Additional useful character classes, including characters valid in certain
    // URI components and separators used in parsing them out of a string.
    //
    protected static final long SEGMENT_CHAR_HI = UNRESERVED_HI | highBitmask(";:@&=+$,");  // | ucschar | escaped
    protected static final long SEGMENT_CHAR_LO = UNRESERVED_LO | lowBitmask(";:@&=+$,");
    protected static final long PATH_CHAR_HI = SEGMENT_CHAR_HI | highBitmask('/');  // | ucschar | escaped
    protected static final long PATH_CHAR_LO = SEGMENT_CHAR_LO | lowBitmask('/');
    protected static final long MAJOR_SEPARATOR_HI = highBitmask(":/?#");
    protected static final long MAJOR_SEPARATOR_LO = lowBitmask(":/?#");
    protected static final long SEGMENT_END_HI = highBitmask("/?#");
    protected static final long SEGMENT_END_LO = lowBitmask("/?#");
    protected static final long PLATFORM_SEGMENT_RESERVED_HI = highBitmask("/?#\\");
    protected static final long PLATFORM_SEGMENT_RESERVED_LO = lowBitmask("/?#\\");

    // The intent of this was to switch over to encoding platform resource URIs
    // by default, but allow people to use a system property to avoid this.
    // However, that caused problems for people and we had to go back to not
    // encoding and introduce yet another factory method that explicitly enables
    // encoding.
    //
    protected static final boolean ENCODE_PLATFORM_RESOURCE_URIS =
            System.getProperty("URI.encodePlatformResourceURIs") != null &&
                    !"false".equalsIgnoreCase(System.getProperty("URI.encodePlatformResourceURIs"));

}
