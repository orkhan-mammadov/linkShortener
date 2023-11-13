package com.ls.urlshortener.service.impl;

import com.ls.urlshortener.service.IdGeneratorService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Scope("singleton")
public class IdGeneratorServiceImpl implements IdGeneratorService {

    private final AtomicLong counter;

    private IdGeneratorServiceImpl() {
        counter = new AtomicLong(0);
    }

    public long generateId() {
        return counter.incrementAndGet();
    }
}
