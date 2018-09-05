package me.immathan.xring

import org.junit.Assert
import org.junit.Test

class BSTTest {

    private var binaryTree = BST()

    @org.junit.Before
    @Throws(Exception::class)
    fun setUp() {
        binaryTree.insert(Node(10))
        binaryTree.insert(Node(20))
        binaryTree.insert(Node(4))
        binaryTree.insert(Node(8))
        binaryTree.insert(Node(7))
    }

    @org.junit.Test
    fun insert() {
        Assert.assertEquals(binaryTree.root!!.data.toLong(), 10)
        Assert.assertEquals(binaryTree.root!!.left!!.data.toLong(), 4)
        Assert.assertEquals(binaryTree.root!!.left!!.right!!.left!!.data.toLong(), 7)
    }

    @org.junit.Test
    fun searchData() {
        Assert.assertTrue(binaryTree.search(7))
        Assert.assertFalse(binaryTree.search(30))
        Assert.assertTrue(binaryTree.search(20))
        Assert.assertFalse(binaryTree.search(11))
    }

    @Test
    fun min() {
        Assert.assertEquals(binaryTree.min()!!.data.toLong(), 4)
        Assert.assertNotEquals(binaryTree.min()!!.data.toLong(), 7)
    }

    @Test
    fun max() {
        Assert.assertEquals(binaryTree.max()!!.data.toLong(), 20)
        Assert.assertNotEquals(binaryTree.max()!!.data.toLong(), 7)
    }

    @Test
    fun inOrder() {
        binaryTree.inOrder()
    }

    @Test
    fun preOrder() {
        binaryTree.preOrder()
    }

    @Test
    fun postOrder() {
        binaryTree.postOrder()
    }

    @Test
    fun remove() {
        binaryTree.remove(Node(4))
        inOrder()
        Assert.assertEquals(binaryTree.min()!!.data.toLong(), 7)
        binaryTree.remove(Node(7))
        inOrder()
        Assert.assertEquals(binaryTree.min()!!.data.toLong(), 8)
    }

    @Test
    fun predecessor() {
        val binaryTree = BST()
        binaryTree.insert(Node(10))
        binaryTree.insert(Node(20))
        binaryTree.insert(Node(4))
        binaryTree.insert(Node(8))
        binaryTree.insert(Node(7))

        Assert.assertEquals(binaryTree.predecessor(8), Node(7))
        Assert.assertEquals(binaryTree.predecessor(20), Node(10))
        Assert.assertNull(binaryTree.predecessor(4))
    }

    @Test
    fun successor() {
        val binaryTree = BST()
        binaryTree.insert(Node(10))
        binaryTree.insert(Node(20))
        binaryTree.insert(Node(4))
        binaryTree.insert(Node(8))
        binaryTree.insert(Node(7))

        Assert.assertEquals(binaryTree.successor(4), Node(7))
        Assert.assertEquals(binaryTree.successor(8), Node(10))
        Assert.assertNull(binaryTree.successor(20))
    }

}