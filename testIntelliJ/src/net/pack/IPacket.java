package net.pack;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public interface IPacket {
    public int getId();
    public String getCommand();
    public void serialize(byte[] data);
    public byte[] deserialize() throws IOException;
    public void local(HashMap data);
}
