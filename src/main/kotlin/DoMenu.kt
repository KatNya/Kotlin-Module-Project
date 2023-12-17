object DoMenu {
    fun <T : UnityObj> compleateMenu (
        typeMenu: String,
        listofObj: MutableList<T>,
        onCreate: (MutableList<Note>) -> Unit,
        onSelect: (UnityObj) -> Unit,
        onExit: (String) -> Unit,
    ) {
        while (true) {
            if (typeMenu.equals("меню1")) {
                println("0. Создать новый архив")
            } else {
                println("0. Создать новую заметку")
            }
            listofObj.forEachIndexed { index, element -> println("${index + 1}. ${element.name}") }
            println("${listofObj.size+1}. Выход")



            val input : Int? = readln().toIntOrNull()
            if(input==null) {
                println("Введено не число")
            } else if(input !in 0..listofObj.size+1) {
                println("Неизвестная команда")
            } else {
                when (input) {
                    0 -> onCreate(listofObj as MutableList<Note>)
                    (listofObj.size + 1) -> {
                    onExit("Конец")
                    break
                }
                    else -> {
                    onSelect(listofObj[input - 1])
                }
                }
            }


        }
    }
}