package me.immathan.xring

class BST {

    var root: Node? = null

    /**
     * To insert a Node into the BST
     * @param dataNode Node to insert
     */
    fun insert(dataNode: Node) {
        if (root == null) {
            this.root = dataNode
            return
        }

        var temp = root
        while (temp != null) {
            if (dataNode.data < temp.data) {
                if (temp.left != null) {
                    temp = temp.left
                } else {
                    dataNode.parent = temp
                    temp.left = dataNode
                    temp = dataNode
                }
            } else if (dataNode.data > temp.data) {
                if (temp.right != null) {
                    temp = temp.right
                } else {
                    dataNode.parent = temp
                    temp.right = dataNode
                    temp = dataNode
                }
            } else { // This means that the data is already in the tree
                break
            }
        }
    }

    fun remove(node: Node) {
        removeNode(root, node.data)
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
            System.out.print(" " + node.data)
            inOrder(node.left)
            inOrder(node.right)
        }
    }

    private fun postOrder(node: Node?) {
        if (node != null) {
            inOrder(node.left)
            inOrder(node.right)
            System.out.print(" " + node.data)
        }
    }

    private fun inOrder(node: Node?) {
        if (node != null) {
            inOrder(node.left)
            System.out.print(" " + node.data)
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

    private fun removeNode(node: Node?, data: Int): Node? {
        if (node == null) {
            return null
        }

        if (data < node.data) {
            node.left = removeNode(node.left, data)
        } else if (data > node.data) {
            node.right = removeNode(node.right, data)
        } else {
            if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            }

            node.data = minNode(node.right)!!.data
            node.right = removeNode(node.right, node.data)
        }

        return node
    }

    /**
     * To search for a data into the BST
     * @param data Integer data to search
     * @return true if the data is present
     */
    fun search(data: Int): Boolean {
        return searchNode(root, data) != null
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

    private fun searchNode(node: Node?, data: Int): Node? {
        if (node == null) {
            return null
        }
        if (node.data < data) {
            return searchNode(node.right, data)
        } else if (node.data > data) {
            return searchNode(node.left, data)
        }
        return node
    }

}
