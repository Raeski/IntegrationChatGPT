package br.com.gptw.model;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Builder
public class GptwDTO {

    private String text;
}
