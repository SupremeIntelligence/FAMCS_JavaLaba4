package org.famcs.JavaLaba4;
import java.nio.file.Path;
import java.nio.file.Paths;
public final class DataAccessManager 
{
    private static volatile DataAccessManager instance;

    private DataReader reader;
    private DataWriter writer;
    private final Path projectDir;

    private DataAccessManager ()
    {
        projectDir = Paths.get("").toAbsolutePath();
        this.reader = null;
        this.writer = null;
    }

    public static DataAccessManager getInstance()
    {
            if (instance == null) //если обьект еще не создан
            {
                synchronized (DataAccessManager.class) 
                {
                    if (instance == null)                     //или не был создан в промежутке между первой или второй проверкой
                    {
                        instance = new DataAccessManager();         
                    }
                }
            }
            return instance;
    }

    public void initialize_read (String fileName, String fileType)
    {
        DataReader baseReader = new TXTReader(fileName);

        switch (fileType.toLowerCase())
        {
            case "txt":
                reader = baseReader;
            case "json":
                reader = new JSONReaderDecorator(baseReader);
            case "xml":
                reader = new XMLReaderDecorator(baseReader);
            default:
                reader = baseReader;
        }
    }
    public void initialize_write(String fileName, String fileType)
    {
        DataWriter baseWriter = new TXTWriter(fileName);

        switch (fileType.toLowerCase())
        {
            case "txt":
                writer = baseWriter;
            case "json":
                writer = new JSONWriterDecorator(baseWriter);
            case "xml":
                writer = new XMLWriterDecorator(baseWriter);
            default:
            writer = baseWriter;
        }
    }

    DataReader getDataReader ()
    {
        return reader;
    }

    DataWriter getDataWriter ()
    {
        return writer;
    }
}
