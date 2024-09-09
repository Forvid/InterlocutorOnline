fun main() {
    val secondsAgo = 3600  // Пример: 1 час назад
    println(agoToText(secondsAgo))
}

fun agoToText(seconds: Int): String {
    return when {
        seconds in 0..60 -> "был(а) только что"
        seconds in 61..3600 -> "был(а) ${minutesToText(seconds / 60)} назад"
        seconds in 3601..86400 -> "был(а) ${hoursToText(seconds / 3600)} назад"
        seconds in 86401..172800 -> "был(а) вчера"
        seconds in 172801..259200 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun minutesToText(minutes: Int): String {
    return when (minutes % 10) {
        1 -> if (minutes % 100 == 11) "$minutes минут" else "$minutes минуту"
        2, 3, 4 -> if (minutes % 100 in 12..14) "$minutes минут" else "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursToText(hours: Int): String {
    return when (hours % 10) {
        1 -> if (hours % 100 == 11) "$hours часов" else "$hours час"
        2, 3, 4 -> if (hours % 100 in 12..14) "$hours часов" else "$hours часа"
        else -> "$hours часов"
    }
}
