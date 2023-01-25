package com.xgileit.sm.subscriptionmanager.service;

import com.xgileit.sm.subscriptionmanager.dto.SubTypeDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;

public interface SubMappingService {
    SubMapping saveUpdateSubMapping(SubTypeDto subTypeDto);
}
