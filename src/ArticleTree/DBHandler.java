package ArticleTree;
import java.util.Random;
import java.util.ArrayList;
public class DBHandler
{
 private static final int MAX_ALPHABET = 24;
 //will currently generate temp, later will use from file/hardcoded.
  public DBHandler()
  {
   curr_point = generateTree();
  }
  public ArrayList<String> getPredictions()
  {
   return getPredictionsRecursive(curr_point);
  }
  private static ArrayList<String> getPredictionsRecursive(ArticleNode curr)
  {
   ArrayList<String> predictions = new ArrayList<>(10);
   if(curr==null){
    return predictions;
   }
   if(curr.isArticle())
   {
    predictions.add(curr.getTitle());
   }
   for(int i = 0;i<MAX_ALPHABET&&predictions.size()<10;i++)
   {
    predictions.addAll( getPredictionsRecursive(curr.getGeneralNext(i)) );
   }
   return predictions;
  }

  public void pointerForward(Character ch)
  {
   curr_point = curr_point.getNext(ch);
  }
  public void pointerBack()
  {
   curr_point = curr_point.getPrev();
  }
  public boolean pointingOnArticle()
  {
   return curr_point.isArticle();
  }
  private static ArticleNode generateTree()
  {
   return generateRandomTree(50,5);
  }
  private ArticleNode curr_point;




 public static ArticleNode generateRandomTree(int numberOfArticles, int maxTitleLength) {
  ArticleNode root = new ArticleNode(new Article("ROOT"));

  Random random = new Random();
  for (int i = 0; i < numberOfArticles; i++) {
   String randomTitle = generateRandomTitle(random, maxTitleLength);
   Article article = new Article(randomTitle);
   root.addArticle(article, 0);
  }

  return root;
 }

 private static String generateRandomTitle(Random random, int maxTitleLength) {
  int titleLength = random.nextInt(maxTitleLength) + 1; // Ensure at least one character
  StringBuilder title = new StringBuilder();

  for (int i = 0; i < titleLength; i++) {
   char randomChar = (char) ('A' + random.nextInt(26)); // Generate random uppercase letter
   title.append(randomChar);
  }

  return title.toString();
 }
}
