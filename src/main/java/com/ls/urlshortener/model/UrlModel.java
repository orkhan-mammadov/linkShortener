package com.ls.urlshortener.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "url_entity")
@NoArgsConstructor
@AllArgsConstructor
public class UrlModel {

    @Id
    @NotNull
    private long id;

    @Column(name = "short_url")
    @NotNull
    private String shortUrl;

    @Column(name = "original_url", length = 1024)
    @NotNull
    private String originalUrl;
}
