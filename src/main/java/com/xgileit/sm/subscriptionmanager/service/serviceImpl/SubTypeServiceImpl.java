package com.xgileit.sm.subscriptionmanager.service.serviceImpl;

import com.xgileit.sm.subscriptionmanager.dto.SubTypeDto;
import com.xgileit.sm.subscriptionmanager.model.SubType;
import com.xgileit.sm.subscriptionmanager.repo.SubTypeRepo;
import com.xgileit.sm.subscriptionmanager.service.SubTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubTypeServiceImpl implements SubTypeService {

    private final SubTypeRepo subTypeRepo;

    @Override
    public SubType saveUpdateSubType(SubTypeDto subTypeDto) {
        SubType subType;
        if (subTypeDto.getSubTypeId() == null) {
            subType = SubType.builder()
                    .subName(subTypeDto.getSubName())
                    .status(true)
                    .build();
        } else {
            subType = subTypeRepo.findById(subTypeDto.getSubTypeId())
                    .orElseThrow(() -> new RuntimeException("Subscription type not found"));
            subType.setSubName(subTypeDto.getSubName());
            subType.setStatus(subTypeDto.getStatus());
        }
        try {
            subTypeRepo.save(subType);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return subType;
    }
}
