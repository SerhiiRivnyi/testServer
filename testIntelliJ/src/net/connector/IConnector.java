package net.connector;

import net.pack.PackFactory;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public interface IConnector {
    void connect();
    void disconnect();
    void setPackFactory(PackFactory packFactory);
}
