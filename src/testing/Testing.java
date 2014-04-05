package testing;
import java.io.IOException;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

public class Testing extends PircBot
{
    public static void main(String[] args) throws IOException, IrcException
    {
        
        MyBot bot = new MyBot();
        bot.setVerbose(true);
        if(!args[1].equalsIgnoreCase(""))
        {
            MyBot.OAUTH = args[1];
        }
        bot.connect("irc.twitch.tv", 6667, MyBot.OAUTH);
        if(!args[0].equalsIgnoreCase(""))
        {
            if(args[0].charAt(0) != '#')
            {
                args[0] = "#" + args[0];
                MyBot.CHANNEL = args[0];
            }
            else
            {
                MyBot.CHANNEL = args[0];
            }
        }
        else
        {
            System.out.println("Not a valid channel");
        }
        
        bot.connect("irc.twitch.tv", 6667, "");
        bot.joinChannel(MyBot.CHANNEL);
    }
}
