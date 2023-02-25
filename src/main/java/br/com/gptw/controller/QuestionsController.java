package br.com.gptw.controller;

import br.com.gptw.integration.GptwIntegration;
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


    private final GptwIntegration gptwIntegration;

    public QuestionsController(GptwIntegration gptwIntegration) {
        this.gptwIntegration = gptwIntegration;
    }

    @GetMapping
    public ResponseEntity<GptwDTO> whyQuestion(@RequestBody GptwBDO gptwBDO){
        GptwDTO gptwDTO = gptwIntegration.ask(gptwBDO);
        return ResponseEntity.ok(gptwDTO);
    }
}
