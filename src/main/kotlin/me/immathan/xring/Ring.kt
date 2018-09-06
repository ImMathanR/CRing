package me.immathan.xring

import com.sun.xml.internal.fastinfoset.util.StringArray
import me.immathan.xring.utils.HashCodeHelper

class Ring {

    private val serverUrls = arrayOf("http://1.1.2.2", "http://2.2.2.2", "http://3.3.3.3", "http://4.4.4.4")

    private var servers = mutableListOf<Server>()

    private val bst = BST()

    constructor() {
        for (serverUrl in serverUrls) {
            val server = Server(serverUrl)
            servers.add(server)
            val node = Node(HashCodeHelper.getHashCode(server.address))
            node.server = server
            bst.insert(node)
        }

        print("Servers Prepared")
    }

}