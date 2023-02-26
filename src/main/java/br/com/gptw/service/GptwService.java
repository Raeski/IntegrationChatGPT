package br.com.gptw.service;

import br.com.gptw.model.GptwBDO;
import br.com.gptw.model.GptwDTO;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GptwService {
    @Value("${gptw.token}")
    private String TOKEN;

    public GptwDTO ask(GptwBDO gptwBDO){
        OpenAiService openAiService = new OpenAiService(TOKEN);

        CompletionRequest completionRequest = new CompletionRequest();
        completionRequest.setModel("text-davinci-003");
        completionRequest.setMaxTokens(100);
        completionRequest.setPrompt(gptwBDO.getText());
        completionRequest.setTemperature(0.0);
        CompletionResult completion = openAiService.createCompletion(completionRequest);

        return GptwDTO.builder().text(completion.getChoices().get(0).getText()).build();
    }

}
