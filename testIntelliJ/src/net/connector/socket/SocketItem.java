package net.connector.socket;

import evt.ISocketEvent;
import net.pack.IPacket;
import net.pack.packs.UserPacket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 19:42
 * To change this template use File | Settings | File Templates.
 */
public class SocketItem implements Runnable{
    private ISocketEvent _owner;

    private int _port;
    private String _url;
    private boolean _isConnect = false;
    private boolean _isAvailable = true;

    ServerSocket _providerSocket;
    Socket _socket;
    ObjectOutputStream _out;
    ObjectInputStream _in;
    DataInputStream _dIn;

    public SocketItem(int port, String url, ISocketEvent owner) {
        _owner = owner;
        _port = port;
        _url = url;
        _isConnect = true;
    }

    public void createConnection(ServerSocket server, Socket socket){
        _providerSocket = server;
        _socket = socket;

        Thread t = new Thread(this);
        t.start();
    }

    private void createConnection() {
        try {
            _providerSocket = new ServerSocket(_port, 0, InetAddress.getByName("localhost"));
            toLog("Waiting for connection" + " " + _providerSocket.getInetAddress());
            _socket = _providerSocket.accept();
            _out = new ObjectOutputStream(_socket.getOutputStream());
            _out.flush();
            _dIn = new DataInputStream(_socket.getInputStream());

            int idPack = _dIn.readInt();
            int sizePack = _dIn.readInt();
            int crc = _dIn.readInt();

            byte[] b = new byte[sizePack - 12];
            _dIn.readFully(b);

            parseData(idPack, crc, b);

            toLog("Connection received from " + _socket.getInetAddress().getHostName() + " " + _socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            toLog("Connection is failed " + e.toString());
        }
    }

    private void parseData(int idPack, int crc, byte[] b) {
        _owner.answerComplete(idPack, crc, b);
        //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void run() {
        //while (_isConnect) {
        createConnection();
        //}
    }

    public void disconnect() {
        _isConnect = false;
    }

    public int getPort() {
        return _port;
    }

    public String getUrl() {
        return _url;
    }

    public boolean isConnect() {
        return _isConnect;
    }

    private void toLog(String message) {
        System.out.println("SocketItem:" + message);
    }

    public void send(IPacket pack){
        toLog(_out.toString() + " " + pack.toString());
        return;
        /*try{
            _out.write(pack.deserialize());
            _out.flush();
        }catch (IOException e){
            toLog("send exception");
        } */
    }
}
