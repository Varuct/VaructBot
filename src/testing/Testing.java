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
        bot.connect("irc.twitch.tv", 6667, "");
        bot.joinChannel(MyBot.CHANNEL);
    }
}
