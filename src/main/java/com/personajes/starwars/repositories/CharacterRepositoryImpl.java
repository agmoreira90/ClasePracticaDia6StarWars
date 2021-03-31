package com.personajes.starwars.repositories;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personajes.starwars.dto.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    @Override
    public List<CharacterDTO> getCharacter(String name) {
        List<CharacterDTO> personajes = null;
        List<CharacterDTO> personajesAux = new ArrayList<>();
        personajes = loadDB();
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i).getName().contains(name)){
                personajesAux.add(personajes.get(i));
            }
        }
        return personajesAux;
    }


    private List<CharacterDTO> loadDB() {
        File file = null;
        List<CharacterDTO> personajes = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<CharacterDTO>> typeRef = new TypeReference<List<CharacterDTO>>() {
            };
            personajes = objectMapper.readValue(file, typeRef);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }
}
