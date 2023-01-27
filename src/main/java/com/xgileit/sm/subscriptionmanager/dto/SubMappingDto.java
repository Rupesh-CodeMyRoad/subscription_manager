package com.xgileit.sm.subscriptionmanager.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SubMappingDto {

    private Long subMappingId;

    private String subReferenceId;

    private Boolean status;

    @NotNull(message = "Subscription Type should not be blank")
    private Long subType;

    @NotNull(message = "Consumer name should not be blank")
    private String consumerName;

}
