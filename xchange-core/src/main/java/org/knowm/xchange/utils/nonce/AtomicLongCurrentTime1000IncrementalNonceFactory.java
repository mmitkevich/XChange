package org.knowm.xchange.utils.nonce;

import si.mazi.rescu.SynchronizedValueFactory;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCurrentTime1000IncrementalNonceFactory
        implements SynchronizedValueFactory<Long> {

    private final AtomicLong incremental = new AtomicLong(System.currentTimeMillis()*1000L);

    @Override
    public Long createValue() {

        return incremental.incrementAndGet();
    }
}
