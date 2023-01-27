package com.xgileit.sm.subscriptionmanager.controller;

import com.xgileit.sm.subscriptionmanager.dto.SubMappingDto;
import com.xgileit.sm.subscriptionmanager.model.SubMapping;
import com.xgileit.sm.subscriptionmanager.service.SubMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

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

    @GetMapping(value = "/getSubDetails")
    public Mono<Map> getSubStatusByRefId(@RequestParam String subReferenceId) {
        System.out.println("service called");
        Map<String,Object> response = service.getSubStatusByRefId(subReferenceId);
        Mono<Map> data = Mono.just(response);
        return data;
    }
}
