class CircularLinkedList {

    private var head: CNode ?= null

    private val lastNode: CNode?
        get() {
            var currentNode = head

            while (currentNode?.next != head)
                currentNode = currentNode!!.next

            return currentNode
        }

    val size: Int
        get(){
            var count = 0
            var currentNode = head
            while (currentNode!!.next != head){
                count++
                currentNode = currentNode.next
            }
            count++
            return count
        }

    fun addLast(data: String){
        val newNode = CNode(data, null)

        if (head == null){
            head = newNode
            newNode.next = head
            return
        }else{
            lastNode!!.next = newNode
            newNode.next = head
        }
    }

    fun addFirst(data: String){
        val newNode = CNode(data, null)
        val cn = lastNode
        newNode.next = head
        head = newNode
        cn!!.next = head
    }

    fun addBefore(index: Int, data: String){

        if (index == 0) {
            addFirst(data)
            return
        }

        val newNode = CNode(data, null)

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
        var cn = head
        repeat(index){
            cn = cn!!.next
        }
        return cn!!.data
    }

    fun getAll(){
        var currentNode = head

        while (currentNode!!.next != head){
            print("[${currentNode.data}] ")
            currentNode = currentNode.next
        }
        print("[${currentNode.data}] ")
    }

    fun removeAt(index: Int){
        if (index == 0){
            val cn = lastNode
            head = head!!.next
            cn!!.next = head
            return
        }

        var before = head
        repeat(index - 1){
            before = before!!.next
        }
        before!!.next = before!!.next!!.next
    }
}

class CNode(val data: String, var next: CNode?)

fun main(){

    val list = CircularLinkedList()

    list.addLast("Lord")
    list.addLast("Sam")
    list.addLast("is")
    list.addLast("cool")
    list.addFirst("The")
    list.addBefore(0, "man")
    //list.removeAt(3)
    list.getAll()
    println(list.getAt(1))
}