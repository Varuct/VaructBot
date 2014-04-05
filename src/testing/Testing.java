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
        bot.connect("irc.twitch.tv", 6667, "oauth:olwvp3qjls791d0hagk9smdln0eqqgy");
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
        bot.joinChannel(MyBot.CHANNEL);
    }
}
