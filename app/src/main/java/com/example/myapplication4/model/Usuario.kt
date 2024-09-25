package com.example.myapplication4.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario (val nome: String, val login: String, val senha: String) : Parcelable