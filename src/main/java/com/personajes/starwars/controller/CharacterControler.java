package com.personajes.starwars.controller;

import com.personajes.starwars.dto.CharacterDTO;
import com.personajes.starwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/personajes")
public class CharacterControler {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/starwars/{name}")
    public List<CharacterDTO> getCharacter(@PathVariable(name = "name", required = false) String name){
        return this.characterService.getCharacter(name);
    }
}
