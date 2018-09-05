package me.immathan.xring

class Node(internal var data: Int) {

    internal var left: Node? = null
    internal var right: Node? = null
    internal var parent: Node? = null

    override fun equals(other: Any?): Boolean {
        return (other as Node).data == this.data
    }

}
