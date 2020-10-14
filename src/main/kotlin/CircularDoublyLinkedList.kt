class CircularDoublyLinkedList {

    private var head: CDNode? = null
    private var tail: CDNode? = null

    val size: Int
        get() {
            var cn = head
            var count = 0
            while (cn!!.next != head){
                count++
                cn = cn.next
            }
            count++
            return count
        }


    fun addPrev(data: String){
        val newNode = CDNode(null, data, null)

        if (head == null){
            head = newNode
            tail = newNode
            return
        }

        head!!.prev = newNode
        newNode.next = head
        head = newNode
        head!!.prev = tail
        tail!!.next = head
    }

    fun addNext(data: String){
        val newNode = CDNode(null, data, null)

        if (head == null){
            head = newNode
            tail = newNode
            return
        }

        tail!!.next = newNode
        newNode.prev = tail
        tail = newNode
        tail!!.next = head
        head!!.prev= tail
    }

    fun addBefore(index: Int, data: String){

        if (index == 0){
            addPrev(data)
            return
        }

        val newNode = CDNode(null, data, null)
        var before = head
        repeat(index){
            before = before!!.next
        }
        newNode.next = before
        newNode.prev = before!!.prev
        before!!.prev!!.next = newNode
        before!!.prev = newNode
    }

    fun getAllFromLeft(){
        var cn = head

        while (cn!!.next != head){
            print("[${cn.data}] ")
            cn = cn.next
        }
        print("[${cn.data}] ")
    }

    fun getAllFromRight(){
        var cn = tail

        while (cn!!.prev != tail){
            print("[${cn.data}] ")
            cn = cn.prev
        }
        print("[${cn.data}] ")
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
        val cn = tail
        tail = tail!!.prev
        cn!!.prev = null
        cn.next = null
        tail!!.next = head
        head!!.prev = tail
    }

    fun removeHead(){
        val cn = head
        head = head!!.next
        cn!!.prev = null
        cn.next = null
        head!!.prev = tail
        tail!!.next = head
    }
}

class CDNode(var prev: CDNode?, val data: String, var next: CDNode?)

fun main() {

    val list = CircularDoublyLinkedList()

    list.addPrev("cool")
    list.addPrev("is")
    list.addPrev("sam")
    list.addNext("and")
    list.addNext("savage")
    list.addBefore(4, "very")
    list.removeTail()
    list.removeHead()
    list.removeAt(list.size - 1)
    list.getAllFromLeft()
    println()
    println(list.size)
    list.getAllFromRight()

}