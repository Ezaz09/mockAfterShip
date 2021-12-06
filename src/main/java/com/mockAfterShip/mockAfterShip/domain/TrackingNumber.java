package com.mockAfterShip.mockAfterShip.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tracking_numbers")
public class TrackingNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String slug;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "after_ship_id")
    private String afterShipId;

    private String status;

    @Column(name = "status_date")
    private Date statusDate;

    @Column(name = "fake_api_key")
    private String fakeApiKey;
}
