package br.com.gptw.controller;

import br.com.gptw.service.GptwService;
import br.com.gptw.model.GptwBDO;
import br.com.gptw.model.GptwDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/question")
public class QuestionsController {


    private final GptwService gptwService;

    public QuestionsController(GptwService gptwService) {
        this.gptwService = gptwService;
    }

    @GetMapping
    public ResponseEntity<GptwDTO> whyQuestion(@RequestBody GptwBDO gptwBDO){
        GptwDTO gptwDTO = gptwService.ask(gptwBDO);
        return ResponseEntity.ok(gptwDTO);
    }
}
