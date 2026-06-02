package com.example.redthreadgame.DTO.IN;

import lombok.Data;

@Data
public class WitnessDTOIN {
    private String name;
    private String statement;
    private Double reliabilityScore;
    private Integer caseId;
}