package com.xgileit.sm.subscriptionmanager.service;

import com.xgileit.sm.subscriptionmanager.dto.SubTypeDto;
import com.xgileit.sm.subscriptionmanager.model.SubType;

public interface SubTypeService {
    SubType saveUpdateSubType(SubTypeDto subTypeDto);

	SubType findSubTypeById(Long subTypeId);
}
