import ArticleTree.DBHandler;

public class UIHandler
{

    public UIHandler(IOHandler ioHandler)
    {
        _ioHandler=ioHandler;
        _dbHandler = new DBHandler();
    }
    public void start()
    {
        _ioHandler.printStr(WELCOME_MSG);
        while(true)
        {

        }
    }
    private final IOHandler _ioHandler;
    private DBHandler _dbHandler;

    private static final String WELCOME_MSG = "Welcome to the offline wiki!\nPlease enter your query below:\n";
}
