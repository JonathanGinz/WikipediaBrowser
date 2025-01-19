import java.util.Scanner;

public class ConsoleHandler implements IOHandler
{
    public void printStr(String str)
    {
        System.out.print(str);
    }
    public String getStr()
    {
        return(scanner.nextLine());
    }
    public char getch(){
        return  (char)scanner.nextByte();
    }
    private static final Scanner scanner = new Scanner(System.in);
}
