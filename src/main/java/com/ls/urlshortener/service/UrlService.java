package com.ls.urlshortener.service;

import com.ls.urlshortener.contoller.request.UrlRequestDTO;
import com.ls.urlshortener.contoller.response.UrlResponseDto;

public interface UrlService {

    UrlResponseDto createAndSaveShortUrl(UrlRequestDTO requestDTO);

    String getOriginalUrl(String shortUrl);
}
