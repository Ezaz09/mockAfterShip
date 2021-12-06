package com.mockAfterShip.mockAfterShip.responseentites.mocktrackingnumber;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckpointEntity {
    private String slug;

    private String city;

    @JsonProperty("created_at")
    private Date createdAt;

    private String location;

    @JsonProperty("country_name")
    private String countryName;

    private String message;

    @JsonProperty("country_iso3")
    private String countryIso;

    private String tag;

    private String subtag;

    @JsonProperty("subtag_message")
    private String subtagMessage;

    @JsonProperty("checkpoint_time")
    private Date checkpointTime;

    private List<Object> coordinates;

    private String state;

    private String zip;

    @JsonProperty("raw_tag")
    private String rawTag;
}
