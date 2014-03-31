package testing;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Trivia 
{
    private final MyBot bot;
    public Trivia(MyBot bot)
    {
        this.bot = bot;
    }
    private final File file = new File("/home/Varuct/TwitchBot/dist/trivia.txt");
    public Scanner reader;
    public List<String> triviaQuestions = new ArrayList(500);
    public List<String> triviaAnswers = new ArrayList(500);
    private int i = 10;
    
    public void setTrivia()
    {
        try 
        {
            reader = new Scanner(file);  // create the stream
        }
        catch (FileNotFoundException e) {}
        String line;
        while(reader.hasNextLine())
        {
            line = reader.nextLine();
            if(i % 2 == 0)
            {
                triviaQuestions.add(line);
            }
            else
            {
                triviaAnswers.add(line);
            }
            i++;
        }
        
    }
    public List<String> getTriviaQuestions()
    {
        return triviaQuestions;
    }
    public List<String> getTriviaAnswers()    
    {
        return triviaAnswers;
    }
}
