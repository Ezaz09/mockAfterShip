package com.mockAfterShip.mockAfterShip.responseentites.mocktrackingnumber;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

 /** Link to AfterShip API -> https://developers.aftership.com/reference/get-trackings **/
public class TrackingNumberEntity {
    private String id;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("created_date_as_date")
    private Date createdDateAsDate;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("last_updated_at")
    private Date lastUpdatedAt;

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("after_ship_id")
    private String afterShipId;

    private String slug;

    private boolean active;

    private List<Object> android;

    @JsonProperty("custom_fields")
    private HashMap<String,String> customFields;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("delivery_time")
    private int deliveryTime;

    @JsonProperty("destination_country_iso3")
    private String destinationCountryIso;

    @JsonProperty("courier_destination_country_iso3")
    private String courierDestinationCountryIso;

    private List<String> emails;

    @JsonProperty("expected_delivery")
    private Date expectedDelivery;

    private List<Object> ios;

    private Object note;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("order_date")
    private Date orderDate;

    @JsonProperty("order_id_path")
    private Object orderIdPath;

    @JsonProperty("origin_country_iso3")
    private String originCountryIso;

    @JsonProperty("shipment_package_count")
    private int shipmentPackageCount;

    @JsonProperty("shipment_pickup_date")
    private Date shipmentPickupDate;

    @JsonProperty("shipment_delivery_date")
    private Date shipmentDeliveryDate;

    @JsonProperty("shipment_type")
    private String shipmentType;

    @JsonProperty("shipment_weight")
    private double shipmentWeight;

    @JsonProperty("shipment_weight_unit")
    private String shipmentWeightUnit;

    @JsonProperty("signed_by")
    private String signedBy;

    private List<Object> smses;

    private String source;

    private String tag;

    private String subtag;

    @JsonProperty("subtag_message")
    private String subtagMessage;

    private String title;

    @JsonProperty("tracked_count")
    private int trackedCount;

    @JsonProperty("last_mile_tracking_supported")
    private Boolean lastMileTrackingSupported;

    private String language;

    @JsonProperty("unique_token")
    private String uniqueToken;

    private List<CheckpointEntity> checkpoints;

    @JsonProperty("subscribed_smses")
    private List<Object> subscribedSmses;

    @JsonProperty("subscribed_emails")
    private List<Object> subscribedEmails;

    @JsonProperty("return_to_sender")
    private boolean returnToSender;

    @JsonProperty("order_promised_delivery_date")
    private Date orderPromisedDeliveryDate;

    @JsonProperty("delivery_type")
    private String deliveryType;

    @JsonProperty("pickup_location")
    private String pickupLocation;

    @JsonProperty("pickup_note")
    private String pickupNote;

    @JsonProperty("courier_tracking_link")
    private String courierTrackingLink;

    @JsonProperty("first_attempted_at")
    private Date firstAttemptedAt;

    @JsonProperty("courier_redirect_link")
    private String courierRedirectLink;

    @JsonProperty("tracking_account_number")
    private Integer trackingAccountNumber;

    @JsonProperty("tracking_origin_country")
    private String trackingOriginCountry;

    @JsonProperty("tracking_destination_country")
    private String trackingDestinationCountry;

    @JsonProperty("tracking_key")
    private String trackingKey;

    @JsonProperty("tracking_postal_code")
    private String trackingPostalCode;

    @JsonProperty("tracking_ship_date")
    private Date trackingShipDate;

    @JsonProperty("tracking_state")
    private String trackingState;

    @JsonProperty("tracking_lines")
    private List<Object> trackingLines;

    @JsonProperty("on_time_status")
    private String onTimeStatus;

    @JsonProperty("on_time_difference")
    private String onTimeDifference;

}
