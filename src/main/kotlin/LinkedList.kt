class LinkedList {

    private var head: Node? = null

    private val lastNode: Node?
        get() {
            var currentNode = head

            while (currentNode?.next != null)
                currentNode = currentNode.next

            return currentNode
        }

    val size: Int
        get(){
            var count = 0
            var currentNode = head
            while (currentNode != null){
                count++
                currentNode = currentNode.next
            }
            return count
    }

    fun addLast(data: String){

        val newNode = Node(data, null)

        if (head == null){
            head = newNode
        }else{
            lastNode!!.next = newNode
        }
    }

    fun addFirst(data: String){
        val newNode = Node(data, null)
        newNode.next = head
        head = newNode
    }

    fun addBefore(index: Int, data: String){

        val newNode = Node(data, null)

        var before = head
        repeat(index - 1){
            before = before!!.next
        }

        var after = head
        repeat(index){
            after = after!!.next
        }

        before!!.next = newNode
        newNode.next = after
    }

    fun getAt(index: Int): String{
        var currentNode = head

        repeat(index){
            currentNode  = currentNode!!.next
        }
        return currentNode!!.data
    }

    fun getAll(){
        var currentNode = head

        while (currentNode != null){
            print("[${currentNode.data}] ")
            currentNode = currentNode.next
        }
    }
//sam
    fun removeAt(index: Int){

        if (index == 0){
            head = head!!.next
            return
        }

        var before = head
        repeat(index - 1){
            before = before!!.next
        }
        before!!.next = before!!.next!!.next
    }
}

class Node(val data: String, var next: Node?)

fun main(){

    val list = LinkedList()

    list.addLast("Sam")
    list.addLast("Loves")
    list.addLast("Payal")
    list.addFirst("lord")
    list.addBefore(3, "queen")
    list.getAll()

//    println(list.getAt(1))
//    println(list.size)
//
//    list.removeAt(2)
//
//    println(list.getAt(0))
//    println(list.getAt(1))
//    println(list.size)
}