package me.immathan.xring

import me.immathan.xring.utils.HashCodeHelper

class Ring(private val virtualNodes: Int, private val servers: ArrayList<Server>) {

    private val bst = BST()

    init {

        servers.map {

        }

        for(i in 0..virtualNodes / servers.size) {
            servers
                .map { Node(HashCodeHelper.getHashCode(it.address, i)) }
                .forEach { bst.insert(it) }
        }

        print("Servers Prepared")
        bst.inOrder()
        println("\n" + bst.predecessor(-1518825306)?.hash)
    }

    fun request(request: Request) {
        HashCodeHelper.getHashCode()
    }

}