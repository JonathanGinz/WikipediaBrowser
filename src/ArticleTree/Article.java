package ArticleTree;

public class Article
{
    public Article(String title)
    {
        _title = title;
        _info = "ERROR - NOT A VALID TITLE";
        isFiller = true;
    }
    public Article(String title,String info)
    {
        _title = title;
        _info = info;
        isFiller = false;
    }
    public String getTitle()
    {
        return _title;
    }
    private final String _title; //currently nothing else needed
    private final String _info;
    public final boolean isFiller;
}
