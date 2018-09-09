package me.immathan.xring

import kotlin.math.truncate

class BST {

    var root: Node? = null

    /**
     * To insert a Node into the BST
     * @param hashNode Node to insert
     */
    fun insert(hashNode: Node) {
        if (root == null) {
            this.root = hashNode
            return
        }

        var temp = root
        while (temp != null) {
            if (hashNode.hash < temp.hash) {
                if (temp.left != null) {
                    temp = temp.left
                } else {
                    hashNode.parent = temp
                    temp.left = hashNode
                    temp = hashNode
                }
            } else if (hashNode.hash > temp.hash) {
                if (temp.right != null) {
                    temp = temp.right
                } else {
                    hashNode.parent = temp
                    temp.right = hashNode
                    temp = hashNode
                }
            } else { // This means that the hash is already in the tree
                break
            }
        }
    }

    fun remove(node: Node) {
        removeNode(root, node.hash)
    }

    fun inOrder() {
        inOrder(root)
    }

    fun preOrder() {
        preOrder(root)
    }

    fun postOrder() {
        postOrder(root)
    }

    fun nearest(value: Int): Int {
        val node = searchNode(root, value)
        if(node != null) {
            return node.hash
        } else {
            if(root == null) {
                return 0
            }
            
            while (temp != null) {
                if (value < temp.hash) {
                    if (temp.left != null) {
                        temp = temp.left
                    } else {
                        hashNode.parent = temp
                        temp.left = hashNode
                        temp = hashNode
                    }
                } else if (hashNode.hash > temp.hash) {
                    if (temp.right != null) {
                        temp = temp.right
                    } else {
                        hashNode.parent = temp
                        temp.right = hashNode
                        temp = hashNode
                    }
                } else { // This means that the hash is already in the tree
                    break
                }
            }
        }
    }

    fun predecessor(value: Int): Node? {
        val node = searchNode(root, value)
        return predecessor(node!!)
    }

    fun successor(value: Int): Node? {
        val node = searchNode(root, value)
        return successor(node!!)
    }

    private fun preOrder(node: Node?) {
        if (node != null) {
            System.out.print(" " + node.hash)
            inOrder(node.left)
            inOrder(node.right)
        }
    }

    private fun postOrder(node: Node?) {
        if (node != null) {
            inOrder(node.left)
            inOrder(node.right)
            System.out.print(" " + node.hash)
        }
    }

    private fun inOrder(node: Node?) {
        if (node != null) {
            inOrder(node.left)
            System.out.print(" " + node.hash)
            inOrder(node.right)
        }
    }

    private fun predecessor(node: Node): Node? {
        var node = node
        if (node.left != null) {
            return maxNode(node.left)
        }

        var parent = node.parent
        while (parent != null && node === parent.left) {
            node = parent
            parent = parent.parent
        }

        return parent
    }

    private fun successor(node: Node): Node? {
        var node = node
        if (node.right != null) {
            return minNode(node.right)
        }

        var parent = node.parent
        while (parent != null && node === parent.right) {
            node = parent
            parent = parent.parent
        }

        return parent
    }

    private fun removeNode(node: Node?, hash: Int): Node? {
        if (node == null) {
            return null
        }

        if (hash < node.hash) {
            node.left = removeNode(node.left, hash)
        } else if (hash > node.hash) {
            node.right = removeNode(node.right, hash)
        } else {
            if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            }

            node.hash = minNode(node.right)!!.hash
            node.right = removeNode(node.right, node.hash)
        }

        return node
    }

    /**
     * To search for a hash into the BST
     * @param hash Integer hash to search
     * @return true if the hash is present
     */
    fun search(hash: Int): Boolean {
        return searchNode(root, hash) != null
    }

    fun min(): Node? {
        return if (root == null) {
            null
        } else minNode(root)
    }

    fun max(): Node? {
        return if (root == null) {
            null
        } else maxNode(root)
    }

    private fun maxNode(node: Node?): Node? {
        var node = node ?: return null

        while (node.right != null) {
            node = node.right!!
        }
        return node
    }

    private fun minNode(node: Node?): Node? {
        var node = node ?: return null

        while (node.left != null) {
            node = node.left!!
        }
        return node
    }

    private fun searchNode(node: Node?, hash: Int): Node? {
        if (node == null) {
            return null
        }
        if (node.hash < hash) {
            return searchNode(node.right, hash)
        } else if (node.hash > hash) {
            return searchNode(node.left, hash)
        }
        return node
    }

}
