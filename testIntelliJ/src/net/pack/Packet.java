package net.pack;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 12.01.12
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
abstract public class Packet implements IPacket{
    protected int _id;
    protected String command = PacketSetting.MODIFY_INFO;

    public int getId(){
        return _id;
    }

    public String getCommand(){
        return command;
    }
    
    protected void toLog(String message){
        Class cl = this.getClass();
        String name = cl.getName();
        name = name.substring(name.lastIndexOf(".")+1);
        System.out.println("id:" + getId() + " pack:" + name + " message:" + message);
    }

    //data get from client
    public void serialize(byte[] data){

    };

    /**
     * data send to client
     * @return null;
     */
    public byte[] deserialize() throws IOException {
        byte[] result = null;
        return result;
    };

    abstract public void local(HashMap data);
}
