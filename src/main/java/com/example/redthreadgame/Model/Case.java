package com.example.redthreadgame.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cases")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String scenario;

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String status; // set by default PENDING or APPROVED

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    @OneToMany(mappedBy = "caseEntity", cascade = CascadeType.ALL)
    private List<Witness> witnesses;

    @OneToMany(mappedBy = "caseEntity", cascade = CascadeType.ALL)
    private List<Suspect> suspects;

    @OneToMany(mappedBy = "caseEntity", cascade = CascadeType.ALL)
    private List<Evidence> evidences;

    // OneToOne
    @OneToOne(mappedBy = "caseEntity", cascade = CascadeType.ALL)
    private CaseSolution caseSolution;

   // @OneToMany(mappedBy = "caseEntity", cascade = CascadeType.ALL)
    //private List<GameSession> gameSessions;
}
