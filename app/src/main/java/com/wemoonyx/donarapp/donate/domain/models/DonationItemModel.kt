package com.wemoonyx.donarapp.donate.domain.models

import androidx.annotation.DrawableRes
import com.wemoonyx.donarapp.R

data class DonationItemModel(
    val id: Int,
    @DrawableRes val imgOrganization: Int,
    val name: String,
    val category: String,
    val shortDescription: String
)

val listDonationOrganizations = listOf(
    DonationItemModel(
        id = 1,
        imgOrganization = R.drawable.arani,
        name = "Arani El Salvador",
        category = "Animalista",
        shortDescription = "Ayudamos a animales en condiciones de abandono"
    ),
    DonationItemModel(
        id = 2,
        imgOrganization = R.drawable.manada_pick_alt,
        name = "La Manada de Pick",
        category = "Animalista",
        shortDescription = "Brindamos una segunda oportunidad a los animales"
    ),
    DonationItemModel(
        id = 3,
        imgOrganization = R.drawable.huellitas,
        name = "Huellitas",
        category = "Animalista",
        shortDescription = "Somos un refugio para animalitos en abandono"
    ),
    DonationItemModel(
        id = 4,
        imgOrganization = R.drawable.jardin_peludos,
        name = "Mi Jardín de peludos",
        category = "Animalista",
        shortDescription = "Ayudamos a animales en condiciones de abandono"
    ),
)