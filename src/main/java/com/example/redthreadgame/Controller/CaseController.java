package com.example.redthreadgame.Controller;

import com.example.redthreadgame.DTO.IN.CaseDTOIN;
import com.example.redthreadgame.DTO.OUT.CaseDTOOUT;
import com.example.redthreadgame.Service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/case")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @GetMapping("/get")
    public List<CaseDTOOUT> getAllCases(){

        return caseService.getAllCases();
    }

    @PostMapping("/add")
    public ResponseEntity addCase(@RequestBody CaseDTOIN caseDTOIN){

        caseService.addCase(caseDTOIN);

        return ResponseEntity.status(200).body("Case Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCase(
            @PathVariable Integer id,
            @RequestBody CaseDTOIN caseDTOIN){

        caseService.updateCase(id,caseDTOIN);

        return ResponseEntity
                .status(200)
                .body("Case Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCase(
            @PathVariable Integer id){

        caseService.deleteCase(id);

        return ResponseEntity
                .status(200)
                .body("Case Deleted");
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity approveCase(
            @PathVariable Integer id){

        caseService.approveCase(id);

        return ResponseEntity.status(200)
                .body("Case Approved");
    }
}