package net.pack;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 12.01.12
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class PacketSetting {
    public static final int LOGIN_PACKET = 1;
    public static final int JOIN_PACKET = 2;

    public static final int USER_PACKET = 10;
    public static final int NAME_PACKET = 11;
    public static final int MONEY_PACKET = 12;
    public static final int GOLD_PACKET = 13;

    public static final int MAP_PACKET = 301;
    public static final int MAP_INSTALL_UNIT_PACKET = 302;

    public static final int FRIEND_PACKET = 401;

    public static final int GARBAGE_PACKET = 101;

    //key to update params, field - not null
    public static final String UPDATE_INFO = "U";
    //key to create or change all modification from packet
    public static final String CREATE_INFO = "C";
    //key to delete params, install param - null, 0, etc..
    public static final String DELETE_INFO = "D";
    //key to modify params, field - all, whith null
    public static final String MODIFY_INFO = "M";
}
