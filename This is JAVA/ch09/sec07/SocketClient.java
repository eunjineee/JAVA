package ch09.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
    public class SocketClient {
        ChatServer chatServer;
        Socket socket;
        DataInputStream dis;
        DataOutputStream dos;
        String clientIp;
        String chatName;
    }

}
    //생성자
    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();
            receive();
        } catch(IOException e) {

        }
    }
}
