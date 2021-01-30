public class Factory
{
    public static void main(String[] args) {
        Music m = MusicFactory.getMusic("traditional", new Rhythm("slow", 1), "somebody");

    }
}
class Rhythm
{
    private String s;
    private int note;
    public Rhythm(String s, int note)
    {
        this.s = s;
        this.note = note;
    }
}

class Music
{
    private Rhythm rhythm;
    private String player;
    public Music(Rhythm rhythm, String player)
    {
        this.rhythm = rhythm;
        this.player = player;
    }
}
class PopMusic extends Music
{

    public PopMusic(Rhythm rhythm, String player) {
        super(rhythm, player);
    }
}
class TraditionalMusic extends Music
{

    public TraditionalMusic(Rhythm rhythm, String player) {
        super(rhythm, player);
    }
}
class MusicFactory
{
    public static Music getMusic(String kind, Rhythm rhythm, String player)
    {
        if(kind.equals("traditional"))
            return new TraditionalMusic(rhythm, player);
        return new PopMusic(rhythm, player);
    }
}