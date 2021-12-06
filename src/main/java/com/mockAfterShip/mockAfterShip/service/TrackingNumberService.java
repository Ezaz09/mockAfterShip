package com.mockAfterShip.mockAfterShip.service;

import com.mockAfterShip.mockAfterShip.domain.TrackingNumber;
import com.mockAfterShip.mockAfterShip.repository.TrackingNumberRepository;
import com.mockAfterShip.mockAfterShip.responseentites.mocktrackingnumber.TrackingNumberEntity;
import com.mockAfterShip.mockAfterShip.responseentites.mocktrackingnumber.TrackingNumberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class TrackingNumberService {
    private final TrackingNumberRepository trackingNumberRepository;

    public ResponseEntity<List<TrackingNumber>> getAll() {
        List<TrackingNumber> trackingNumbers = trackingNumberRepository.findAll();
        return new ResponseEntity<>(trackingNumbers, HttpStatus.OK);
    }

    public ResponseEntity<TrackingNumber> getById(int id) {
        Optional<TrackingNumber> trackingNumberById = trackingNumberRepository.findById(id);
        return trackingNumberById
                .map(trackingNumber -> new ResponseEntity<>(trackingNumber, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<TrackingNumberResponse> getBySlugAndTrackingNumber(String slug,
                                                                             String trackingNumber) {
        TrackingNumber trackingNumberFromRep = trackingNumberRepository.getTrackingNumberBySlugAndTrackingNumber(slug, trackingNumber);

        if(trackingNumberFromRep == null) {
            return new ResponseEntity<>(createTrackingNumberResponseForNotFoundResponse(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(createTrackingNumberResponseForFoundStatus(createTrackingNumberEntity(trackingNumberFromRep)), HttpStatus.OK);
    }

    private TrackingNumberResponse createTrackingNumberResponseForNotFoundResponse() {
        TrackingNumberResponse trackingNumberResponse = new TrackingNumberResponse();
        HashMap<String, Object> meta = new HashMap<>();
        meta.put("code", 4004);
        meta.put("message", "Tracking does not exist.");
        meta.put("type", "NotFound");
        trackingNumberResponse.setMeta(meta);
        trackingNumberResponse.setData(new HashMap<>());
        return trackingNumberResponse;
    }

    private TrackingNumberResponse createTrackingNumberResponseForFoundStatus(TrackingNumberEntity tracking) {
        TrackingNumberResponse trackingNumberResponse = createTrackingNumberResponseForHttpSuccess();

        HashMap<String, Object> data = new HashMap<>();
        data.put("tracking", tracking);
        trackingNumberResponse.setData(data);
        return trackingNumberResponse;
    }

    private TrackingNumberResponse createTrackingNumberResponseForHttpSuccess() {
        TrackingNumberResponse trackingNumberResponse = new TrackingNumberResponse();
        HashMap<String, Object> meta = new HashMap<>();
        meta.put("code", 200);
        trackingNumberResponse.setMeta(meta);
        return trackingNumberResponse;
    }

    private TrackingNumberEntity createTrackingNumberEntity(TrackingNumber trackingNumber) {
        TrackingNumberEntity trackingNumberEntity = new TrackingNumberEntity();
        trackingNumberEntity.setTrackingNumber(trackingNumber.getTrackingNumber());
        trackingNumberEntity.setSlug(trackingNumber.getSlug());
        trackingNumberEntity.setCreatedDateAsDate(trackingNumber.getStatusDate());
        return trackingNumberEntity;
    }

    public ResponseEntity deleteById(int id) {
        trackingNumberRepository.deleteById(id);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    public ResponseEntity<TrackingNumberResponse> deleteByAfterShipId(String afterShipId) {
        TrackingNumber trackingNumberByAfterShipId = trackingNumberRepository.getTrackingNumberByAfterShipId(afterShipId);
        if (trackingNumberByAfterShipId == null) {
            return new ResponseEntity<>(createTrackingNumberResponseForNotFoundResponse(), HttpStatus.NOT_FOUND);
        }

        trackingNumberRepository.delete(trackingNumberByAfterShipId);
        return new ResponseEntity<>(createResponseForSuccessfulDeleteByAfterShipId(), HttpStatus.OK);
    }

    private TrackingNumberResponse createResponseForSuccessfulDeleteByAfterShipId() {
        TrackingNumberResponse trackingNumberResponse = createTrackingNumberResponseForHttpSuccess();

        HashMap<String, Object> data = new HashMap<>();
        data.put("result", "success");
        trackingNumberResponse.setData(data);
        return trackingNumberResponse;
    }

    public ResponseEntity<TrackingNumber> postTrackingNumber(TrackingNumber trackingNumber) {
        TrackingNumber savedTrackingNumber = trackingNumberRepository.save(trackingNumber);
        return new ResponseEntity<>(savedTrackingNumber, HttpStatus.OK);
    }

    public ResponseEntity<TrackingNumberResponse> postTrackingNumberByResponse(Map<String, TrackingNumberEntity>  trackingData, String apiKey) {
        TrackingNumberEntity tracking = trackingData.get("tracking");
        TrackingNumber trackingNumber = new TrackingNumber();
        trackingNumber.setSlug(tracking.getSlug());
        trackingNumber.setTrackingNumber(tracking.getTrackingNumber());
        trackingNumber.setStatus("active");
        trackingNumber.setStatusDate(tracking.getCreatedDateAsDate());
        trackingNumber.setFakeApiKey(apiKey);
        tracking.setTrackingAccountNumber(null);
        tracking.setActive(true);
        tracking.setUniqueToken("deprecated");
        tracking.setSource("api");
        tracking.setTitle(tracking.getTrackingNumber());
        tracking.setLastMileTrackingSupported(null);


        String afterShipId = createAfterShipId();
        trackingNumber.setAfterShipId(afterShipId);
        tracking.setAfterShipId(afterShipId);
        trackingNumberRepository.save(trackingNumber);

        return new ResponseEntity<>(createTrackingNumberResponseForFoundStatus(tracking), HttpStatus.OK);
    }

    private String createAfterShipId() {
        boolean createNewAfterShipId = true;
        String afterShipId = "";
        do{
            String newAfterShipId = String.valueOf(ThreadLocalRandom.current().nextInt(100, 100_000));
            TrackingNumber trackingNumberByAfterShipId = trackingNumberRepository.getTrackingNumberByAfterShipId(newAfterShipId);
            if(trackingNumberByAfterShipId == null) {
                afterShipId = newAfterShipId;
                createNewAfterShipId = false;
            }
        } while (createNewAfterShipId);
        return afterShipId;
    }
}
