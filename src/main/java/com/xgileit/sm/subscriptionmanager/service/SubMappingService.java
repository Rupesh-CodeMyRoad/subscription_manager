package com.xgileit.sm.subscriptionmanager.service;

import com.xgileit.sm.subscriptionmanager.dto.SubMappingDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;

public interface SubMappingService {
   // SubMapping saveUpdateSubMapping(SubTypeDto subTypeDto);

	SubMapping saveUpdateSubMapping(SubMappingDto subMappingDto);

	Boolean getSubStatusByRefId(String refId);
}
