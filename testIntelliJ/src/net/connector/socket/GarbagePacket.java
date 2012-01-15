package net.connector.socket;

import net.pack.Packet;
import net.pack.PacketSetting;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 13.01.12
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class GarbagePacket extends Packet{

    public GarbagePacket(){
        _id = PacketSetting.GARBAGE_PACKET;
    }

    @Override
    public void local(HashMap data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
