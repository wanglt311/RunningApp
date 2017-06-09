package demo.domain.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by vagrant on 6/9/17.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
//deal with jpa what to annotation --> Entity
//but in mongoDB -->
@Document
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))//with "final"
//add persistenceCon add to constructor(Point)
public class SupplyLocation {
    @Id//spring data, not jpa, not mongoDB
    private String id;
    private String address1;
    private String address2;
    private String city;

    @GeoSpatialIndexed//tell spring data location point GeoSpatialIndex
    private final Point location;
    private String state;
    private String zip;
    private String type;

    //upload is latitude & longitude
    @JsonCreator
    public SupplyLocation(@JsonProperty("latitude") double latitude,
                          @JsonProperty("longitude") double longitude) {
        this.location = new Point(longitude, latitude);//x, y
    }

    public SupplyLocation() {
        this.location = new Point(0.0, 0.0);
    }

    //pass in location
//    public SupplyLocation(Point location) {
//        this.location = location;
//    }

    public double getLatitude() {
        return this.location.getY();
    }

    public double getLongitude() {
        return this.location.getX();
    }


}
