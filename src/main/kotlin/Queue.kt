class Queue {

    private var front: QNode? = null
    private var rear: QNode? = null

    fun enqueue(data: String){

        val newNode = QNode(data, null)

        if (rear == null){
            rear = newNode
            front = rear
            return
        }

        newNode.next = front
        front = newNode
    }

    fun dequeue(){
        var cn = front
        while (cn?.next != rear)
            cn = cn!!.next
        rear = cn
        rear!!.next = null
    }

    fun getAll(){
        var cn =  front

        while (cn != null){
            print("[${cn.data}] ")
            cn = cn.next
        }
    }

    fun getFront(){
        print("[${front!!.data}] ")
    }

    fun getRear(){
        print("[${rear!!.data}] ")
    }
}

class QNode(val data: String, var next: QNode?)

fun main(){

    val obj = Queue()
    obj.enqueue("sam")
    obj.enqueue("is")
    obj.enqueue("cool")
    obj.dequeue()
    obj.getFront()
    obj.getRear()
    obj.getAll()
}