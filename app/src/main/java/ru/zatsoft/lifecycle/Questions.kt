package ru.zatsoft.lifecycle

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


class Questions  {
    val questionsArray: MutableList<Question> = mutableListOf()
    init {
        questionsArray.add(Question("1. В период Отечественной войны 1812 главнокомандующими назначались: ",
            mapOf(
            "а) Кутузов и Тормасов" to false,
            "б) Барклай де Толли и Кутузов" to true,
            "в) Кутузов и Багратион" to false)))

        questionsArray.add( Question("2. «Вечный мир» с Украиной Россия установила в: ",mapOf(
            "а) 1648 г." to false,
            "б) 1654 г." to false,
            "в) 1686 г." to true)))

        questionsArray.add(Question("3. В 1768-1774 гг. Россия воевала с:",
            mapOf(
            "а) Германей" to false,
            "б) Швецией" to false,
            "в) Турцией" to true)))

        questionsArray.add(Question("13. Пушки из чугуна стали отливать при:",
            mapOf(
            "а) Иване Грозном" to true,
            "б) Иване III" to false,
            "в) Федоре Ивановиче" to false)))

        questionsArray.add(Question("5. Поводом городских восстаний 1648 г. стало повышение налога на: ",
            mapOf(
            "а) хлеб" to false,
            "б) соль" to true,
            "в) водку" to false)))
    }
}

@Parcelize
data class Question(val title: String, val answers: Map<String,Boolean>): Parcelable



