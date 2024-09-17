package ru.geekbrains.patterns.lesson7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.patterns.lesson7.persistence.DTO.TrackDTO;
import ru.geekbrains.patterns.lesson7.services.FormatService;
import ru.geekbrains.patterns.lesson7.services.TrackService;

@Controller
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;
    private final FormatService formatService;

    @GetMapping("addtrack")
    public String addNewTrack(Model model){
        model.addAttribute("formats", formatService.findAllFormats());
        return "addtrack";
    }

    @PostMapping("addtrack")
    public String saveTrack(TrackDTO trackDTO){
        trackService.saveTrack(trackDTO);
        return "redirect:/showalltracks";
    }

    @GetMapping("showalltracks")
    public String showAllTracks(Model model){
        model.addAttribute("tracks", trackService.findAllTracks());
        return "showalltracks";
    }
}
