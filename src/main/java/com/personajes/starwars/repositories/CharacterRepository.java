package com.personajes.starwars.repositories;

import com.personajes.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {

    List<CharacterDTO> getCharacter(String name);

}
