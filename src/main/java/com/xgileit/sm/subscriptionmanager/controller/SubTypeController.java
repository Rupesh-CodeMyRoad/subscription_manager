package com.xgileit.sm.subscriptionmanager.controller;

import com.xgileit.sm.subscriptionmanager.dto.SubTypeDto;
import com.xgileit.sm.subscriptionmanager.model.SubType;
import com.xgileit.sm.subscriptionmanager.service.SubTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/subType")
public class SubTypeController {

    private final SubTypeService service;

    /**
     * Used to save subscription type
     *
     * @return success or failure response
     */
    @PostMapping(value = "/save")
    public ResponseEntity<?> saveSubType(@RequestBody SubTypeDto subTypeDto) {
        SubType response = service.saveUpdateSubType(subTypeDto);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value="/getSubType")
    public SubType findSubTypeById(@RequestParam Long subTypeId)
    {
       return service.findSubTypeById(subTypeId);
    }
}
