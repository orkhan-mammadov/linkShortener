package com.ls.urlshortener.repo;

import com.ls.urlshortener.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepo extends JpaRepository<UrlModel, Long> {
    UrlModel findByShortUrl(String shortUrl);

}
