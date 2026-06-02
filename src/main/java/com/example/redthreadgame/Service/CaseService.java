package com.example.redthreadgame.Service;

import com.example.redthreadgame.DTO.IN.CaseDTOIN;
import com.example.redthreadgame.DTO.OUT.CaseDTOOUT;
import com.example.redthreadgame.Model.Case;
import com.example.redthreadgame.Repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final ModelMapper modelMapper;
    private final CaseRepository caseRepository;

    // GET ALL

    public List<CaseDTOOUT> getAllCases(){

        List<CaseDTOOUT> cases = new ArrayList<>();

        for(Case c : caseRepository.findAll()){

            cases.add(modelMapper.map(c, CaseDTOOUT.class));
        }

        return cases;
    }

    // ADD

    public void addCase(CaseDTOIN caseDTOIN){

        Case crimeCase = modelMapper.map(caseDTOIN, Case.class);

        crimeCase.setStatus("PENDING");

        caseRepository.save(crimeCase);
    }

    // UPDATE

    public void updateCase(Integer id , CaseDTOIN caseDTOIN){

        Case oldCase = caseRepository.findById(id).orElseThrow();

        oldCase.setTitle(caseDTOIN.getTitle());
        oldCase.setScenario(caseDTOIN.getScenario());
        oldCase.setDifficulty(caseDTOIN.getDifficulty());

        caseRepository.save(oldCase);
    }

    // DELETE

    public void deleteCase(Integer id){

        caseRepository.deleteById(id);
    }

    // APPROVE

    public void approveCase(Integer id){

        Case crimeCase = caseRepository.findById(id).orElseThrow();

        crimeCase.setStatus("APPROVED");

        caseRepository.save(crimeCase);
    }
}