var listOfFolders: MutableList<Folder> = mutableListOf()

fun main(){

    var creat : (MutableList<Note>)->Unit = {createFolder()}
    var select : (UnityObj) -> Unit = {folder :UnityObj -> showAllNote(folder as Folder)}
    var exit : (String) -> Unit ={end -> println(end) }
    DoMenu.compleateMenu("меню1",listOfFolders, onCreate = creat, onSelect = select, onExit = exit )

}

fun showAllNote(folder: Folder) {
    val onCreate: (MutableList<Note>) -> Unit = {createNote(folder.list) }
    val onSelect: (UnityObj) -> Unit = { note -> (note as Note).showNote() }
    val onExit: ((String) -> Unit) = { println("Возврат в главное меню \n") }
    DoMenu.compleateMenu("нефолдер", folder.list, onCreate, onSelect, onExit)

}

fun createNote(list: MutableList<Note>) {
    println("Введите заголовок заметки")

    val input = readln()
    if (!input.equals("")) {
        println("Напишите заметку")
        val text = readln()
        list.add(Note(input, text))
    } else {
        println("Отмена создания заметки")
    }
}

fun createFolder() {
    println("Введите название архива")
    var nameFolder: String
    var emptyListOfNotes: MutableList<Note> = mutableListOf()
    while (true) {
        nameFolder = readln()
        if (nameFolder.equals("")) {
            println("Архив должен иметь название. Введите название")
        } else {
            break
        }
    }
    listOfFolders.add(Folder(nameFolder, emptyListOfNotes ))
}





