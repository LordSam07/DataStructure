class BinarySearchTree {

    var index = 0
    var searchIndex = 0
    var root: BSNode? = null
    private var inorderArray = ArrayList<Int>()

    fun inOrder(node: BSNode?) {

        if (node == null)
            return

        inOrder(node.lChild)
        print("[${node.data}]")
        inOrder(node.rChild)
    }

    fun convertToBinarySearchTree(node: BSNode?){

        createInOrderArray(node)

        replaceNodes(node)

    }

    private fun replaceNodes(node: BSNode?){

        if (node == null)
            return

        replaceNodes(node.lChild)
        node.data = inorderArray[index++]
        replaceNodes(node.rChild)
    }

    private fun createInOrderArray(node: BSNode?) {

        if (node == null)
            return

        createInOrderArray(node.lChild)
        inorderArray.add(node.data)
        createInOrderArray(node.rChild)

        inorderArray.sort()
    }

    fun search(node: BSNode?, data: Int) {

        searchIndex++

        if (node == null){
            print("Not Found")
            return
        }

        when {
            node.data == data -> print("Found at : $searchIndex")
            node.data > data -> search(node.lChild, data)
            node.data < data -> search(node.rChild, data)
        }
    }
}

class BSNode(var data: Int, var lChild: BSNode? = null, var rChild: BSNode? = null)

fun main(){

    val tree = BinarySearchTree()
    tree.root = BSNode(2)
    tree.root!!.lChild = BSNode(3)
    tree.root!!.rChild = BSNode(1)
    tree.root!!.lChild!!.lChild = BSNode(9)
    tree.root!!.lChild!!.rChild = BSNode(7)
    tree.root!!.rChild!!.lChild = BSNode(4)
    tree.root!!.rChild!!.rChild = BSNode(5)
    tree.inOrder(tree.root)
    println()
    tree.convertToBinarySearchTree(tree.root)
    tree.inOrder(tree.root)
    println()
    tree.search(tree.root, 7)
}