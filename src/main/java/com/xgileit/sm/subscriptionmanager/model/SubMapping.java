package com.xgileit.sm.subscriptionmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity responsible for storing subscription mapping data
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_mapping_id", nullable = false)
    private Long subMappingId;

    @Column(name = "sub_reference_id", nullable = false, unique = true)
    private String subReferenceId;

    @Column(name = "consumer_name", nullable = false, unique = true)
    private String consumerName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "dateLogged", nullable = false)
    private Date dateLogged;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "sub_type_id")
    private SubType subType;
}
