package com.devstaff.farmcollector.model;

import com.devstaff.farmcollector.model.enumeration.Season;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "planted")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "season")
    private Season season;

    @OneToOne
    @JoinColumn(name = "crop_type_id", nullable = false)
    private CropType cropType;

    @Column(name = "planted_area")
    private String plantedArea;

    @Column(name = "expected_amount")
    private Double expectedAmount;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;
}
