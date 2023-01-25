package com.xgileit.sm.subscriptionmanager.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
