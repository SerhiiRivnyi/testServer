package net;

import net.connector.IConnector;
import net.connector.socket.SocketConnector;
import net.pack.IPacket;
import net.pack.PackFactory;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class ServerManager {
    private HashMap<Integer, IPacket> _packets;
    private HashMap<Integer,IConnector> _connections;
    private PackFactory _packFactory;
    IConnector conn;

    public ServerManager(){
        _packets = new HashMap<Integer, IPacket>();
        _connections = new HashMap<Integer, IConnector>();
        _packFactory = new PackFactory();
    }
    
    public boolean connect(int id){
        //if(_connections[id])
        conn = _connections.get(id);

        if(conn == null){
            createConnect(id);
        }
        return true;
    }

    private void createConnect(int id) {
        conn = new SocketConnector(id);
        conn.setPackFactory(_packFactory);
        conn.connect();
        //To change body of created methods use File | Settings | File Templates.
    }

}
