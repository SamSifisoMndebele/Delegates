import kotlin.reflect.KProperty

class MyClass {
    var p: String by Delegate()

    override fun toString() = "MyClass String"
}

class Delegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

fun main() {
    val myClass = MyClass()
    println(myClass.p)
    myClass.p = "Sam"
    myClass.p = "Mndebele"
}