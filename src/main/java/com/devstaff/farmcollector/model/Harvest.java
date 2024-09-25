package com.devstaff.farmcollector.model;

import com.devstaff.farmcollector.model.enumeration.Season;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "harvested")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Harvest {

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

    @Column(name = "actual_amount")
    private Double actualAmount;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;
}
