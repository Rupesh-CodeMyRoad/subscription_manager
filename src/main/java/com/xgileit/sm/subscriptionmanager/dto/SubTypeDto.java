package com.xgileit.sm.subscriptionmanager.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SubTypeDto {
    private Long subTypeId;

    @NotNull(message = "Subscription Name should not be blank")
    private String subName;

    @NotNull(message = "Consumer Name should not be blank")
    private String consumerName;

    private Boolean status;
}
