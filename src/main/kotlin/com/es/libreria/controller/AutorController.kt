package com.es.libreria.controller

import com.es.libreria.model.Autor
import com.es.libreria.service.AutorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/autores")
class AutorController {

    /*
    RESPONSABILIDADES
    Manejar las solicitudes HTTp
     */

    @Autowired
    private lateinit var autorService: AutorService

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: String
    ): Autor?{
        //1º Comprobación básica de los parametros de entrada
        if (id.isNullOrEmpty()) {
            return null
        }

        //2º Comunico el controller con el service
        return autorService.getById(id)
    }
}