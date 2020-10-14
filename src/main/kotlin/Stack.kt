class Stack {

    private var top: SNode? = null

    fun push(data: String){

        val newNode = SNode(data, null)

        if (top == null){
            top = newNode
            return
        }

        newNode.down = top
        top = newNode
    }

    fun pop(){

        if (top == null){
            println(" Stack is empty")
        }else{
            val cn = top
            top = top!!.down
            cn!!.down = null
            println("Poped : ${cn.data}")
        }
    }

    fun getAll(){
        var cn = top

        while (cn != null){
            println("[${cn.data}]")
            cn = cn.down
        }
    }

    fun top(){
        println("Top : ${top!!.data}")
    }
}

class SNode(val data: String, var down: SNode?)

fun main(){

    val obj = Stack()
    obj.push("GoodDay")
    obj.push("Parle-G")
    obj.push("Marie")
    obj.pop()
    obj.getAll()
    obj.top()
}