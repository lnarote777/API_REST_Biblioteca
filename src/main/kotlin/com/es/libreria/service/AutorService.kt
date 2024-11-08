package com.es.libreria.service

import com.es.libreria.model.Autor
import com.es.libreria.repository.AutorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AutorService {

    @Autowired
    private lateinit var autorRepository: AutorRepository

    /*
    RESPONSABILIDADES
    Controlar la lógica de Negocio
    Comunicarse con el repository
     */

    fun getById(id: String) : Autor?{
        //1º Implementar la lógica de Negocio
        var idL: Long = 0
        try {
            idL = id.toLong()
        }catch (e: Exception){
            println(e.message)
            return null
        }

        //2º comunicacion con repository
        val autor = autorRepository.findByIdOrNull(idL)
        return autor
    }
}