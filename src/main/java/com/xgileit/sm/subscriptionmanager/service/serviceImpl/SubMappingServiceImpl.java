package com.xgileit.sm.subscriptionmanager.service.serviceImpl;

import com.xgileit.sm.subscriptionmanager.dto.SubMappingDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;
import com.xgileit.sm.subscriptionmanager.model.SubType;
import com.xgileit.sm.subscriptionmanager.repo.SubMappingRepo;
import com.xgileit.sm.subscriptionmanager.repo.SubTypeRepo;
import com.xgileit.sm.subscriptionmanager.service.SubMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SubMappingServiceImpl implements SubMappingService {

    private final SubMappingRepo subMappingRepo;
    private final SubTypeRepo subTypeRepo;


    @Override
    public SubMapping saveUpdateSubMapping(SubMappingDto subMappingDto) {
        SubMapping subMapping;
        SubType subType = subTypeRepo.findById(subMappingDto.getSubType()).orElseThrow(() -> new RuntimeException("Subscription type not found"));
        if (subType.getStatus() == false) {
            throw new RuntimeException("Subscription service is deactivated. Sorry for the inconvenience");
        }
        String uniqueRefId = generateUniqueId(subMappingDto.getConsumerName(), subType.getSubName());
        if (subMappingDto.getSubMappingId() == null) {
            subMapping = new SubMapping();
            subMapping.setSubMappingId(subMappingDto.getSubMappingId());
            subMapping.setSubReferenceId(uniqueRefId);
            subMapping.setStatus(true);
            subMapping.setConsumerName(subMappingDto.getConsumerName());
            subMapping.setDateLogged(new Date());
            subMapping.setSubType(subType);
        }
        //update
        else {
            subMapping = subMappingRepo.findById(subMappingDto.getSubMappingId()).orElseThrow(() -> new RuntimeException("Subscription History not found"));
            subMapping.setStatus(subMappingDto.getStatus());
            subMapping.setDateLogged(new Date());
            subMapping.setSubType(subType);
        }
        try {
            return subMappingRepo.save(subMapping);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    @Override
    public Map<String,Object> getSubStatusByRefId(String subReferenceId) throws StackOverflowError {
        Map<String,Object> subData = new HashMap<>();
        SubMapping subMapping;
        try{
           subMapping = subMappingRepo.getBySubReferenceId(subReferenceId);
        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
        subData.put("subData",subMapping);
        return subData;
    }

    private static String generateUniqueId(String consumerName, String subName) {
        String uniqueID = UUID.randomUUID().toString().substring(0, 14).concat(consumerName).concat("-" + subName);
        System.out.println(uniqueID);
        return uniqueID;
    }
}
