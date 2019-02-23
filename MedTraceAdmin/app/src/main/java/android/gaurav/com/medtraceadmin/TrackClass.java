package android.gaurav.com.medtraceadmin;

public class TrackClass {

    String timestamp;
    String name;
    Double latitude, longitude;

    public TrackClass(String timestamp, String name, Double latitude, Double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.name = name;

    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
