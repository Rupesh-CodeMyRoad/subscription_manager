package com.xgileit.sm.subscriptionmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity responsible for storing subscription type data
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_type")
public class SubType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_type_id", nullable = false)
    private Long subTypeId;

    @Column(name = "sub_name", nullable = false, unique = true)
    private String subName;

    @Column(name = "status")
    private Boolean status;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subType", orphanRemoval = true)
    private SubMapping subMapping;

}
