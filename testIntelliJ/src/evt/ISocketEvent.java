package evt;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 12.01.12
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
public interface ISocketEvent {
    void answerComplete(int idPack, int crc, byte[] b);
    void answerFail(String message);
    void closeConnect();
    void completeConnect();
}
