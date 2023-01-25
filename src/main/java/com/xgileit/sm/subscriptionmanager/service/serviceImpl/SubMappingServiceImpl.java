package com.xgileit.sm.subscriptionmanager.service.serviceImpl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.xgileit.sm.subscriptionmanager.dto.SubMappingDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;
import com.xgileit.sm.subscriptionmanager.model.SubType;
import com.xgileit.sm.subscriptionmanager.repo.SubMappingRepo;
import com.xgileit.sm.subscriptionmanager.repo.SubTypeRepo;
import com.xgileit.sm.subscriptionmanager.service.SubMappingService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SubMappingServiceImpl implements SubMappingService {
    
	private final SubMappingRepo subMappingRepo;
	private final SubTypeRepo subTypeRepo;
	
	
	@Override
    public SubMapping saveUpdateSubMapping(SubMappingDto subMappingDto) {
	SubMapping subMapping = subMappingRepo.getReferenceById(subMappingDto.getSubMappingId());
	SubType subType = subTypeRepo.findById(subMappingDto.getSubType()).orElseThrow(() -> new RuntimeException("Subscription type not found"));
	   if(ObjectUtils.isEmpty(subMapping))
		{
		subMapping.setSubMappingId(subMappingDto.getSubMappingId());
		subMapping.setSubReferenceId(subMappingDto.getSubReferenceId());
		subMapping.setStatus(subMappingDto.getStatus());
		subMapping.setDateLogged(new Date());
		subMapping.setSubType(subType);
		}
	   //update
		else
		{
			subMapping.setStatus(subMappingDto.getStatus());
			subMapping.setDateLogged(new Date());
			subMapping.setSubType(subType);
		}
		try {
		return subMappingRepo.save(subMapping);
		}
		catch (Exception e) {
		 throw new RuntimeException(e.getMessage());
		}
    	
    }


	@Override
	public Boolean getSubStatusByRefId(String refId) {
	 SubMapping subMapping = subMappingRepo.getBySubReferenceId(refId);
	  return subMapping.getStatus();
	}
}
