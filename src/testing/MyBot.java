package testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.jibble.pircbot.PircBot;
import org.jibble.pircbot.User;

public class MyBot extends PircBot
{
    public static final String CHANNEL = "#namaztak";
    boolean boolTrivia = false;    
    boolean correct = false;
    public InputStream input;
    public List<String> triviaQuestions;
    public List<String> triviaAnswers;
    public Scanner reader;
    public final File file = new File("/home/Varuct/TwitchBot/dist/users.txt");
    public final File userPointsFile = new File("/home/Varuct/TwitchBot/dist/Users.properties");
    public final Properties userPoints = new Properties();
    private final Trivia trivia = new Trivia(this);
    public MyBot() throws FileNotFoundException, IOException
    {
        this.setName("VeractBot");
        trivia.setTrivia();
        triviaQuestions = trivia.getTriviaQuestions();
        triviaAnswers = trivia.getTriviaAnswers();
        input = new FileInputStream(userPointsFile);
        userPoints.load(input);
    }
    
    @Override
    public void onUserList(String channel, User[] users)
    {
        String list = "";
        users = getUsers(MyBot.CHANNEL);
        for(User user : users)
        {
            list = list + " " + user.getNick();
        }
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) 
    {
                
        if(message.equalsIgnoreCase("!trivia") && sender.equalsIgnoreCase("veract"))
        {
            sendMessage(MyBot.CHANNEL, "Syntax: !trivia enable / disable");
        }
        
        else if(message.equalsIgnoreCase("!trivia enable") && sender.equalsIgnoreCase("veract"))
        {
            boolTrivia = true;
            
            Timer timer = new Timer();
            TimerTask task = new task(this);
            timer.scheduleAtFixedRate(task, 10000, 60000);
            sendMessage(MyBot.CHANNEL, "Trivia is now enabled.");
        }
        
        else if (message.equalsIgnoreCase("!trivia disable") && sender.equalsIgnoreCase("veract"))
        {
            boolTrivia = false;
            sendMessage(MyBot.CHANNEL, "Trivia is now disabled.");
        }
                
        if(correct == false && message.equalsIgnoreCase(triviaAnswers.get(task.i)))
        {
            sendMessage(MyBot.CHANNEL, sender + ": You are correct! ");
            correct = true;
            task.i++;
            
        }
        
        else if(correct == false && message.contains(triviaAnswers.get(task.i)))
        {
            sendMessage(MyBot.CHANNEL, sender + ": You are correct! ");
            correct = true;
            task.i++;
        }
        
        if(message.equalsIgnoreCase("!pi") && sender.equalsIgnoreCase("Veract"))
        {
            sendMessage(MyBot.CHANNEL, "Here, have some PI!");
            sendMessage(MyBot.CHANNEL, String.valueOf(Math.PI));
        }
        
        if(message.equalsIgnoreCase("!points"))
        {
            int i = Integer.valueOf(userPoints.getProperty("Lkimahril".toLowerCase()));
            userPoints.setProperty(sender.toLowerCase(), "0");
            if(sender.equalsIgnoreCase("Lkimahril"))
            {
                i--;
                userPoints.setProperty("Lkimahril".toLowerCase(), String.valueOf(i));
            }
            
            sendMessage(MyBot.CHANNEL, sender + " has " + userPoints.getProperty(sender.toLowerCase()) + " points.");
            
            
        }
        
        
    }
}
