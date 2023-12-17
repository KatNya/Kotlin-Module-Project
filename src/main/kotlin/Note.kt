class Note(override var name: String, var text: String):UnityObj{
    fun showNote(){
        println("Название заметки:\n$name\nЗаметка:\n$text")
        println("   ")
    }
}