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

    fun reverse(){

        var i = head
        var j = lastNode
        var l = size - 2

        while ( i != j && j!!.next != i){

            val temp = i!!.data
            i.data = j.data
            j.data = temp

            getAll()
            println()

            i = i.next

            j = head
            repeat(l){
                j = j!!.next
            }
            l--
        }
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

class Node(var data: String, var next: Node?)

fun main(){

    val list = LinkedList()

    list.addLast("Sam")
    list.addLast("Loves")
    list.addLast("Payal")
    list.addFirst("lord")
    list.addBefore(3, "queen")

    list.getAll()
    println()
    list.reverse()

}