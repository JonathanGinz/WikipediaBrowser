package ArticleTree;
import java.util.Map;
/**
 * Class represents a node in the DB tree
 * expansion IS NOT and WILL NOT be available at runtime!
 * this DB is designed to be as power effective as possible, not as memory or complexity
 * the creation will be with a diffrent runtime and DB will stay static otherwise
 * (will prob implement this in cpp for that, this is just POC)
 * */
public class ArticleNode
{
    public Boolean isArticle()
    {
        return _article.isFiller;
    }
    public ArticleNode(Article article)
    {
        _prev = null;
        _article = article;
    }
    public ArticleNode(ArticleNode prev,Article article)
    {
        _prev = prev;
        _article = article;
    }
    public ArticleNode getGeneralNext(int ind)
    {
        if(this._next.size()<=ind)
        {
            return(null);
        }
        var next_iter = this._next.values().iterator();
        ArticleNode curr_next = next_iter.next();
        while(--ind>0){curr_next = next_iter.next();}
        return curr_next;
    }
    public ArticleNode getNext(Character chr)
    {
        if(!this._next.containsKey(chr))
        {
            return(new ArticleNode(this,
                    new Article(NO_RESULTS,NO_RESULTS)));
        }
        return this._next.get(chr);
    }
    public ArticleNode getPrev()
    {
        if(_prev==null)
        {
            return this;
        }
        return _prev;
    }
    public String getTitle(){return _article.getTitle();}
    /**
     * Function recursivley adds article
     * @param index - goes up each time until end of name, to help with navigation of tree
     * */
    public void addArticle(Article article,int index)
    {
        Character curr_char = (Character)article.getTitle().charAt(index);
        if(_article.getTitle().equals(article.getTitle()))
        {
            _article = article; //able to cast because no duplicate titles in wikipedia
            return;
        }
        if(!this._next.containsKey(curr_char))
        {
            _next.put(curr_char,new ArticleNode(
                    this,new Article(article.getTitle().substring(0,index))));
        }
        _next.get(curr_char).addArticle(article,index+1);
    }
    private ArticleNode _prev;
    private Map<Character,ArticleNode> _next;
    private Article _article;
    private static final String NO_RESULTS = "NO RESULTS";
}
