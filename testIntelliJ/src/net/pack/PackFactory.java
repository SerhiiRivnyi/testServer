package net.pack;

import net.pack.packs.FriendPacket;
import net.pack.packs.LoginPacket;
import net.pack.packs.UserPacket;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 12.01.12
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
public class PackFactory {

    public PackFactory(){

    }

    public IPacket generatePack(int idPack, byte[] b) {
        IPacket pack = createPacket(idPack);
        return null;
    }

    private IPacket createPacket(int idPack) {
        switch (idPack){
            case PacketSetting.JOIN_PACKET:{

            }
            case PacketSetting.LOGIN_PACKET:{
                return new LoginPacket();
            }
            case  PacketSetting.USER_PACKET:{
                return new UserPacket();
            }
            case PacketSetting.NAME_PACKET:{

            }
            case PacketSetting.MONEY_PACKET:{

            }
            case PacketSetting.GOLD_PACKET:{

            }
            case PacketSetting.MAP_PACKET:{

            }
            case PacketSetting.MAP_INSTALL_UNIT_PACKET:{

            }
            case PacketSetting.FRIEND_PACKET:{
                return new FriendPacket();
            }
            case PacketSetting.GARBAGE_PACKET:{

            }
        }
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
