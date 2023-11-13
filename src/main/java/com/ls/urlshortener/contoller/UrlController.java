package com.ls.urlshortener.contoller;

import com.ls.urlshortener.contoller.request.UrlRequestDTO;
import com.ls.urlshortener.contoller.response.UrlResponseDto;
import com.ls.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    public ResponseEntity<UrlResponseDto> getShortLink(@RequestBody UrlRequestDTO requestDTO) {
        requestDTO.validateURL();
        var response = urlService.createAndSaveShortUrl(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    public void redirectToYouTube(@PathVariable String shortUrl,
                                  HttpServletResponse response) throws IOException {
        var urlToRedirect = urlService.getOriginalUrl(shortUrl);
        response.sendRedirect(urlToRedirect);
    }
}
