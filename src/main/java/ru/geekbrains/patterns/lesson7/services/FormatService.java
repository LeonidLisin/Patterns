package ru.geekbrains.patterns.lesson7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.patterns.lesson7.persistence.entities.Format;
import ru.geekbrains.patterns.lesson7.persistence.repositories.FormatRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FormatService {

    private final FormatRepository formatRepository;

    public List<Format> findAllFormats(){
        return formatRepository.findAll();
    }

}
