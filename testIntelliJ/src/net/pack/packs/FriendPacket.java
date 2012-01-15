package net.pack.packs;

import net.pack.Packet;
import net.pack.PacketSetting;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 13.01.12
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class FriendPacket extends Packet{

    private Vector<Object> _friends;

    public FriendPacket(){
        _id = PacketSetting.FRIEND_PACKET;
    }


    @Override
    public void local(HashMap data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
