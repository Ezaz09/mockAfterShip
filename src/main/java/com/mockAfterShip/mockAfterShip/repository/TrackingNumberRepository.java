package com.mockAfterShip.mockAfterShip.repository;

import com.mockAfterShip.mockAfterShip.domain.TrackingNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingNumberRepository extends JpaRepository<TrackingNumber, Integer> {
    @Query("From TrackingNumber as tn where tn.slug = :slug and tn.trackingNumber = :trackingNumber")
    TrackingNumber getTrackingNumberBySlugAndTrackingNumber(@Param("slug") String slug, @Param("trackingNumber") String trackingNumber);

    @Query("From TrackingNumber as tn where tn.afterShipId = :afterShipId")
    TrackingNumber getTrackingNumberByAfterShipId(@Param("afterShipId") String afterShipId);
}
