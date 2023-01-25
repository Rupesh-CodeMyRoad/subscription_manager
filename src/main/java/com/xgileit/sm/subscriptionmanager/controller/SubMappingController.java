package com.xgileit.sm.subscriptionmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xgileit.sm.subscriptionmanager.dto.SubMappingDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;
import com.xgileit.sm.subscriptionmanager.service.SubMappingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/subMapping")
public class SubMappingController {

    private final SubMappingService service;
    /**
     * Used to save subscription type
     *
     * @return success or failure response
     */
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveSubType(@RequestBody SubMappingDto subMappingDto) {
        SubMapping response = service.saveUpdateSubMapping(subMappingDto);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value = "/getSubStatus")
    public Boolean getSubStatusByRefId(@RequestParam  String refId) {
         return service.getSubStatusByRefId(refId);
    }
}
