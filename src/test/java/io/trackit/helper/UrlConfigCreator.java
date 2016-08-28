package io.trackit.helper;

import io.trackit.domain.TrackitUser;
import io.trackit.domain.UrlConfig;
import io.trackit.repository.UrlConfigRepository;

public class UrlConfigCreator {

    private final TrackitUser trackitUser;
    private final String url;
    private final UrlConfigRepository urlConfigRepository;

    public UrlConfigCreator(TrackitUser trackitUser, String url, UrlConfigRepository urlConfigRepository) {
        this.trackitUser = trackitUser;
        this.url = url;
        this.urlConfigRepository = urlConfigRepository;
    }

    public UrlConfig create() {
        UrlConfig urlConfig = new UrlConfig();
        urlConfig.setTrackitUser(trackitUser);
        urlConfig.setUrl(url);
        return urlConfigRepository.saveAndFlush(urlConfig);
    }


}
