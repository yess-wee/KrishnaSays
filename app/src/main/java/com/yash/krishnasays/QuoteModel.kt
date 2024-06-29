package com.yash.krishnasaysapp

data class QuoteModel(
                       val id: String,
                       val chapter: Long,
                       val verse: Long,
                       val slok: String,
                       val transliteration: String,
                       val tej: Tej,
                       val siva: Siva,
                       val purohit: Purohit,
                       val chinmay: Chinmay,
                       val san: San,
                       val adi: Adi,
                       val gambir: Gambir,
                       val madhav: Madhav,
                       val anand: Anand,
                       val rams: Rams,
                       val raman: Raman,
                       val abhinav: Abhinav,
                       val sankar: Sankar,
                       val jaya: Jaya,
                       val vallabh: Vallabh,
                       val ms: Ms,
                       val srid: Srid,
                       val dhan: Dhan,
                       val venkat: Venkat,
                       val puru: Puru,
                       val neel: Neel,
                       val prabhu: Prabhu,
)

data class Tej(
    val author: String,
    val ht: String,
)

data class Siva(
    val author: String,
    val et: String,
    val ec: String,
)

data class Purohit(
    val author: String,
    val et: String,
)

data class Chinmay(
    val author: String,
    val hc: String,
)

data class San(
    val author: String,
    val et: String,
)

data class Adi(
    val author: String,
    val et: String,
)

data class Gambir(
    val author: String,
    val et: String,
)

data class Madhav(
    val author: String,
    val sc: String,
)

data class Anand(
    val author: String,
    val sc: String,
)

data class Rams(
    val author: String,
    val ht: String,
    val hc: String,
)

data class Raman(
    val author: String,
    val sc: String,
    val et: String,
)

data class Abhinav(
    val author: String,
    val sc: String,
    val et: String,
)

data class Sankar(
    val author: String,
    val ht: String,
    val sc: String,
    val et: String,
)

data class Jaya(
    val author: String,
    val sc: String,
)

data class Vallabh(
    val author: String,
    val sc: String,
)

data class Ms(
    val author: String,
    val sc: String,
)

data class Srid(
    val author: String,
    val sc: String,
)

data class Dhan(
    val author: String,
    val sc: String,
)

data class Venkat(
    val author: String,
    val sc: String,
)

data class Puru(
    val author: String,
    val sc: String,
)

data class Neel(
    val author: String,
    val sc: String,
)

data class Prabhu(
    val author: String,
    val et: String,
    val ec: String,
)
