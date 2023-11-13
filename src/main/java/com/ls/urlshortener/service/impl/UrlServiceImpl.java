package com.ls.urlshortener.service.impl;

import com.ls.urlshortener.contoller.request.UrlRequestDTO;
import com.ls.urlshortener.contoller.response.UrlResponseDto;
import com.ls.urlshortener.model.UrlModel;
import com.ls.urlshortener.repo.UrlRepo;
import com.ls.urlshortener.service.IdGeneratorService;
import com.ls.urlshortener.service.UrlService;
import com.ls.urlshortener.utils.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final IdGeneratorService idGenerator;

    private final UrlRepo urlRepo;

    private final Environment environment;

    /*
    ID generator should be separated.
    Would be best to have an in memory pre-generated ids to have a better performance.
    For scalability, id generator should be a common separate service.

    Creating and saving of shortUrl can be separated for not blocking each other.
    */
    @Override
    public UrlResponseDto createAndSaveShortUrl(UrlRequestDTO requestDTO) {
        var id = idGenerator.generateId();
        var shortUrl = UrlUtils.generateShortUrl(id);
        var urlModel = new UrlModel(id, shortUrl, requestDTO.getUrl());
        urlRepo.save(urlModel);
        return new UrlResponseDto(getApplicationBasedShortUrl(shortUrl));
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        return urlRepo.findByShortUrl(shortUrl).getOriginalUrl();
    }

    private String getApplicationBasedShortUrl(String shortUrl) {
        String port = environment.getProperty("server.port", "8080");
        String contextPath = environment.getProperty("server.servlet.context-path", "/");
        String baseUrl = environment.getProperty("server.address", "localhost");
        return String.format("http://%s:%s%s%s", baseUrl, port, contextPath, shortUrl);
    }
}
