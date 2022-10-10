package com.kobzariev.prog.homework1.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Option {
    private String option;
    private AtomicInteger count = new AtomicInteger();

    public Option(String option, AtomicInteger count) {
        this.option = option;
        this.count = count;
    }

    public String getOption() {
        return option;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void addVote() {
        count.incrementAndGet();
    }
}
