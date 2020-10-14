class DoublyLinkedList {

    private var head: DNode? = null
    private var tail: DNode? = null

    val size: Int
        get() {
            var cn = head
            var count = 0

            while (cn != null) {
                count++
                cn = cn.next
            }
            return count
        }

    fun addBefore(index: Int, data: String){

        if (index == 0){
            addPrev(data)
            return
        }

        val newNode = DNode(null, data, null)
        var before = head
        repeat(index){
            before = before!!.next
        }
        newNode.next = before
        newNode.prev = before!!.prev
        before!!.prev!!.next = newNode
        before!!.prev = newNode
    }

    fun addPrev(data: String){
        val newNode = DNode(null, data, null)

        if (head == null){
            head = newNode
            tail = head
            return
        }

        head!!.prev = newNode
        newNode.next = head
        head = newNode
    }

    fun addNext(data: String){
        val newNode = DNode(null, data, null)

        if (head == null){
            head = newNode
            tail = head
            return
        }

        tail!!.next = newNode
        newNode.prev = tail
        tail = newNode
    }

    fun getAllFromLeft(){
        var cn = head

        while (cn != null){
            print("[${cn.data}] ")
            cn = cn.next
        }
    }

    fun getAllFromRight(){
        var cn = tail

        while (cn != null){
            print("[${cn.data}] ")
            cn = cn.prev
        }
    }

    fun removeAt(index: Int){

        if (index == 0) {
            removeHead()
            return
        }
        if (index == size - 1){
            removeTail()
            return
        }

        var cn = head

        repeat(index){
            cn = cn!!.next
        }

        cn!!.prev!!.next = cn!!.next
        cn!!.next!!.prev = cn!!.prev
    }

    fun removeTail(){
        tail = tail!!.prev
        tail!!.next = null
    }

    fun removeHead(){
        head = head!!.next
        head!!.prev = null
    }

}

class DNode(var prev: DNode?, val data: String, var next: DNode?)

fun main(){

    val list = DoublyLinkedList()

    list.addPrev("is")
    list.addPrev("sam")
    list.addNext("great")
    list.addNext("lord")
    list.removeTail()
    list.addNext("man")
    list.removeHead()
    list.addPrev("Sam")
    println(list.size)
    list.removeAt(3)
    list.addBefore(0, "a")
    list.getAllFromLeft()

}