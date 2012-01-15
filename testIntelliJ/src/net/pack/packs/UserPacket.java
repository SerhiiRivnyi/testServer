package net.pack.packs;

import com.user.User;
import javassist.bytecode.ByteArray;
import net.pack.Packet;
import net.pack.PacketSetting;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 13.01.12
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class UserPacket extends Packet{

    private int _userId = 0;
    private int _userCoins = 0;
    private int _userGold = 0;
    private int _userExp = 0;
    private String _userName = "";
    private String _userAvatar = "";

    public UserPacket(){
        _id = PacketSetting.USER_PACKET;
    }

    @Override
    public void serialize(byte[] data){

    };

    @Override
    public byte[] deserialize() throws IOException {
        byte[] result = null;
        int size = 0;
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        ba.write(getId());
        String str = "{" + addToJson("id", _userId) + "," + addToJson("coins", _userCoins) + "," +
                addToJson("gold", _userGold) + ","+ addToJson("exp", _userExp) + "," +
                addToJson("name", _userName) + ","+ addToJson("avatar", _userAvatar) + "}";
        size = 4 + 4 + 4 + str.getBytes().length;
        ba.write(size);
        ba.write(1);
        ba.write(str.getBytes());
        result = ba.toByteArray();
        return result;
    };

    private String addToJson(String key, String value){
        String str = key + ":" + value;
        return str;
    }

    private String addToJson(String key, int value){
        String str = key + ":" + value;
        return str;
    }
    
    public void local(HashMap data){
        if(data.containsKey("user")){
            User user = (User)data.get("user");
            _userId = user.getId();
            _userCoins = user.getCoins();
            _userGold = user.getGold();
            _userExp = user.getExp();
            _userAvatar = user.getAvatar();
            _userName = user.getName();
            return;
        }
        if(data.containsKey("userId")){
            _userId = (Integer)data.get("userId");
        }
        if(data.containsKey("userCoins")){
            _userCoins = (Integer)data.get("userCoins");
        }
        if(data.containsKey("userGold")){
            _userGold = (Integer)data.get("userGold");
        }
        if(data.containsKey("userExp")){
            _userExp = (Integer)data.get("userExp");
        }
        if(data.containsKey("userName")){
            _userName = (String)data.get("userName");
        }
        if(data.containsKey("userAvatar")){
            _userAvatar = (String)data.get("userAvatar");
        }
    }

    public int getUserId() {
        return _userId;
    }

    public int getUserCoins() {
        return _userCoins;
    }

    public int getUserGold() {
        return _userGold;
    }

    public int getUserExp() {
        return _userExp;
    }

    public String getUserName() {
        return _userName;
    }

    public String getUserAvatar() {
        return _userAvatar;
    }

}
