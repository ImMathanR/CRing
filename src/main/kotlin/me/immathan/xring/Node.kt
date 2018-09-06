package me.immathan.xring

class Node(internal var hash: Int) {

    internal var left: Node? = null
    internal var right: Node? = null
    internal var parent: Node? = null
    internal var server: Server? = null

    override fun equals(other: Any?): Boolean {
        return (other as Node).hash == this.hash
    }

}
