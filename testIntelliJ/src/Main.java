import net.ServerManager;
import org.DBManager;

/**
 * Created by IntelliJ IDEA.
 * User: seric
 * Date: 11.01.12
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static ServerManager _server;

    public static void main(String[] args) {
        new DBManager();
        _server = new ServerManager();
        _server.connect(125);
        // TODO code application logic here
    }
}
