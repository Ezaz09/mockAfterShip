package com.mockAfterShip.mockAfterShip.rest;

import com.mockAfterShip.mockAfterShip.domain.TrackingNumber;
import com.mockAfterShip.mockAfterShip.responseentites.mocktrackingnumber.TrackingNumberEntity;
import com.mockAfterShip.mockAfterShip.responseentites.mocktrackingnumber.TrackingNumberResponse;
import com.mockAfterShip.mockAfterShip.service.TrackingNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trackings")
@RequiredArgsConstructor
public class TrackingNumbersResource {
    private final TrackingNumberService trackingNumberService;

    @GetMapping
    @Transactional
    public ResponseEntity<List<TrackingNumber>> getAll() {
        return trackingNumberService.getAll();
    }

    @GetMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<TrackingNumber> getById(@PathVariable Integer id) {
        return trackingNumberService.getById(id);
    }

    @GetMapping(value = "/{slug}/{trackingNumber}")
    public ResponseEntity<TrackingNumberResponse> getBySlugAndTrackingNumber(@PathVariable String slug, @PathVariable String trackingNumber) {
        return trackingNumberService.getBySlugAndTrackingNumber(slug, trackingNumber);
    }

    @DeleteMapping(value = "/byId/{id}")
    @Transactional
    public ResponseEntity deleteById(@PathVariable int id) {
        return trackingNumberService.deleteById(id);
    }

    @DeleteMapping(value = "/{afterShipId}")
    public ResponseEntity<TrackingNumberResponse> deleteByAfterShipId(@PathVariable String afterShipId) {
        return trackingNumberService.deleteByAfterShipId(afterShipId);
    }

    @PostMapping
    public ResponseEntity<TrackingNumberResponse> postTrackingNumberByResponse(@RequestBody Map<String, TrackingNumberEntity> trackingData,
                                                                                @RequestHeader ("aftership-api-key") String apiKey) {
        return trackingNumberService.postTrackingNumberByResponse(trackingData, apiKey);
    }

    @PostMapping(value = "/byTrackingNumber")
    @Transactional
    public ResponseEntity<TrackingNumber> postTrackingNumber(@RequestBody TrackingNumber trackingNumber) {
        return trackingNumberService.postTrackingNumber(trackingNumber);
    }
}
