package io.trackit.dto;

public class CreateUrlConfigDto {
    private String url;
    private Long trackitUserId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTrackitUserId() {
        return trackitUserId;
    }

    public void setTrackitUserId(Long trackitUserId) {
        this.trackitUserId = trackitUserId;
    }
}
