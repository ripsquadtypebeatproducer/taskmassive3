fun main() {
    val alphabet = arrayOf(
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И',
        'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т',
        'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ',
        'Э', 'Ю', 'Я'
    )

    println("Введите 'зашифровать' или 'расшифровать':")
    val action = readln()
    println("Введите ключевое слово:")
    val keyword = readln().uppercase()
    println("Введите текст:")
    val text = readln().uppercase()

    val cipheredText = StringBuilder()
    val decodedText = StringBuilder()

    for (i in text.indices) {
        val offset = keyword[i % keyword.length] - 'А' + 1 // Расчитываем смещение
        val alphabetIndex = (alphabet.indexOf(text[i]) + (if (action == "зашифровать") offset else -offset + 33)) % 33
        if (action == "зашифровать") {
            cipheredText.append(alphabet[alphabetIndex])
        } else {
            decodedText.append(alphabet[alphabetIndex])
        }
    }

    when (action) {
        "зашифровать" -> println("Зашифрованный текст: $cipheredText")
        "расшифровать" -> println("Дешифрованный текст: $decodedText")
        else -> println("Неверное действие")
    }
}