package com.es.libreria.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "autores")
data class Autor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var nombre: String,
    var nacionalidad: String,

    @Column(name = "anio_nacimiento")
    var anioNacimiento: Int,

    @Column(length = 1000)
    var biografia: String? = null,

    @OneToMany(mappedBy = "autor", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val libros: MutableList<Libro> = mutableListOf()
)