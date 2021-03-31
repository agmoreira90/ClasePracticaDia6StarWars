package com.personajes.starwars.services;

import com.personajes.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
   List<CharacterDTO> getCharacter(String name);
}
