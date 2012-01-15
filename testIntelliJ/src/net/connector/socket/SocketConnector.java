package net.connector.socket;

import com.user.User;
import evt.IEventListener;
import evt.ISocketEvent;
import net.ServerSetting;
import net.connector.IConnector;
import net.pack.IPacket;
import net.pack.PackFactory;
import net.pack.packs.UserPacket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class SocketConnector implements IConnector, ISocketEvent {
    private int _id = 0;
    private SocketItem _socketItem;
    private ServerSocket _providerSocket;

    private PackFactory _packFactory;

    public SocketConnector(int id){
        _id = id;
        try{
            _providerSocket = new ServerSocket(ServerSetting.PORT, 0, InetAddress.getByName("localhost"));
        }catch (IOException e){

        }
    }

    public void setPackFactory(PackFactory packFactory){
        _packFactory = packFactory;
    }

    public void connect(){
        if(_socketItem == null){
            createSocket();
            toLog("create socket successfully");
            return;
        }
        toLog("socket is available");
    }
    
    public void disconnect(){

    }

    private void createSocket() {
        while(true){
            try{
                _socketItem = new SocketItem(ServerSetting.PORT, ServerSetting.URL, this);
                Socket socket = _providerSocket.accept();
                _socketItem.createConnection(_providerSocket, socket);
            }catch (IOException e){
                toLog("create Socket failed" + e.getMessage());
            }
        }
    }

    private void toLog(String message){
        System.out.println("SocketConnector:" + message);
    }

    @Override
    public void answerComplete(int idPack, int crc, byte[] b) {
        toLog("answer -> idPack:" + idPack + " crc:" + crc + " available()" + b);
        IPacket pack = _packFactory.generatePack(idPack, b);
        testUserSend();
    }

    private void testUserSend() {
        UserPacket userPacket = new UserPacket();
        User user = new User();
        user.setAvatar("");
        user.setId(123);
        user.setCoins(255);
        user.setExp(222);
        user.setGold(22);
        user.setName("Sergey");
        HashMap data = new HashMap();
        data.put("user", user);
        userPacket.local(data);
        toLog(_socketItem + " ");
        //_socket.send(userPacket);
    }

    @Override
    public void answerFail(String message) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void closeConnect() {
        disconnect();
    }

    @Override
    public void completeConnect() {
        toLog("completeConnection");
    }
}
