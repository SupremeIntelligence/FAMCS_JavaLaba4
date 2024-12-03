package org.famcs.JavaLaba4;

public final class DataAccessManager 
{
    private static DataAccessManager instance;

    private DataReader reader;
    private DataWriter writer;
    private final String projectDirectory;

    private DataAccessManager ()
    {
        projectDirectory = System.getProperty("user.dir");
        this.reader = null;
        this.writer = null;
    }

    //public static Data
}
