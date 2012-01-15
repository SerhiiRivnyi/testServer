package net.pack.packs;

import net.pack.Packet;
import net.pack.PacketSetting;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 12.01.12
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class LoginPacket extends Packet {

    public LoginPacket(){
        _id = PacketSetting.LOGIN_PACKET;
        toLog("");
    }

    @Override
    public void local(HashMap data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
