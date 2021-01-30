public class Singleton
{
    public static void main(String[] args) {
        MainServer server = MainServer.getInstance(1212, "localhost");
    }
}
class MainServer
{
    private int port;
    private String ip;
    private static MainServer mainServer;

    private MainServer(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public static MainServer getInstance(int port, String ip)
    {
        if(mainServer == null)
        {
            mainServer = new MainServer(port, ip);
        }
        return mainServer;
    }
}
