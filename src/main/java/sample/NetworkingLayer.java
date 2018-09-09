package sample;

import me.immathan.xring.Ring;
import me.immathan.xring.Server;

import java.util.ArrayList;
import java.util.List;

public class NetworkingLayer {

    private String[] serverUrls = new String[]{"http://1.1.2.2", "http://2.2.2.2", "http://3.3.3.3", "http://4.4.4.4"};

    NetworkingLayer() {
        ArrayList<Server> servers = new ArrayList<>();
        for (String serverUrl : serverUrls) {
            servers.add(new Server(serverUrl));
        }
        Ring ring = new Ring(300, servers);
    }

    public static void main(String[] args) {

        NetworkingLayer networkingLayer = new NetworkingLayer();

    }

}
