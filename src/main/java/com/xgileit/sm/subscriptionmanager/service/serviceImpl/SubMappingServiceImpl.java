package com.xgileit.sm.subscriptionmanager.service.serviceImpl;

import com.xgileit.sm.subscriptionmanager.dto.SubTypeDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;
import com.xgileit.sm.subscriptionmanager.service.SubMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubMappingServiceImpl implements SubMappingService {
    @Override
    public SubMapping saveUpdateSubMapping(SubTypeDto subTypeDto) {
        return null;
    }
}
