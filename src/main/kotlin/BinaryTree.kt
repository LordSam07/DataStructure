class BinaryTree {

    var root: BNode? = null

    fun inOrder(node: BNode?) {

        if (node == null)
            return

        inOrder(node.lChild)
        print("[${node.data}]")
        inOrder(node.rChild)
    }

    fun preOrder(node: BNode?) {

        if (node == null)
            return

        print("[${node.data}]")
        preOrder(node.lChild)
        preOrder(node.rChild)
    }

    fun postOrder(node: BNode?) {

        if (node == null)
            return

        postOrder(node.lChild)
        postOrder(node.rChild)
        print("[${node.data}]")
    }
}

class BNode(val data: String, var lChild: BNode? = null, var rChild: BNode? = null)

fun main() {

    val tree = BinaryTree()
    tree.root = BNode("Sam")
    tree.root!!.lChild = BNode("is")
    tree.root!!.rChild = BNode("cool")

    tree.preOrder(tree.root)

}