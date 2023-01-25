package com.xgileit.sm.subscriptionmanager.controller;

import com.xgileit.sm.subscriptionmanager.dto.SubTypeDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;
import com.xgileit.sm.subscriptionmanager.model.SubType;
import com.xgileit.sm.subscriptionmanager.service.SubMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> saveSubType(@RequestBody SubTypeDto subTypeDto) {
        SubMapping response = service.saveUpdateSubMapping(subTypeDto);
        return ResponseEntity.ok(response);
    }
}
