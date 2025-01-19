import java.util.Map;
public class ArticleNode
{
    //function gets next node according to correct char
    // (notice this tree will only work with console search, soul purpuse of our program)
    public ArticleNode getNext(Character letter)
    {
        return _next.get(letter);
    }
    //function returns top 10 alphabetical titles with matching name
    public String[] getPrediction()
    {
        String[] predicts = new String[10];
        int i =0;
        for(var title : _article.keySet())
        {
            predicts[i] =title;
        }
        return predicts;
    }
    private Map<String,String> _article;
    private Map<Character,ArticleNode> _next;
}
