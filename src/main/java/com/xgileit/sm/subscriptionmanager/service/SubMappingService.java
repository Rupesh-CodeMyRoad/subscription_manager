package com.xgileit.sm.subscriptionmanager.service;

import com.xgileit.sm.subscriptionmanager.dto.SubMappingDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;

import java.util.Map;

public interface SubMappingService {

	SubMapping saveUpdateSubMapping(SubMappingDto subMappingDto);

	Map<String,Object> getSubStatusByRefId(String subReferenceId);
}
