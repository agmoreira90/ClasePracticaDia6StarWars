package com.personajes.starwars.services;

import com.personajes.starwars.dto.CharacterDTO;
import com.personajes.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterServiceImpl implements CharacterService{

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharacter(String name) {
        return this.characterRepository.getCharacter(name);
    }
}
