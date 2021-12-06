package com.mockAfterShip.mockAfterShip.responseentites.mocktrackingnumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingNumberResponse {
    private HashMap<String, Object> meta;
    private HashMap<String, Object> data;
}
