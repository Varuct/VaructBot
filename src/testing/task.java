package testing;
import java.util.TimerTask;
import java.util.Random;

public class task extends TimerTask
{
    private final MyBot bot;
    public static int i = 1;
    public static int r;
    private Random random = new Random();
    
    public task(MyBot bot)
    {
        this.bot = bot;
    }
    
    
    @Override
    public final void run() 
    {
        bot.correct = false;
        bot.sendMessage(MyBot.CHANNEL, bot.triviaQuestions.get(i));
    }
    
}
