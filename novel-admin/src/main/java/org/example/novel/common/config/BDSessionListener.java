package org.example.novel.common.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author：hb
 * @Package：org.example.novel.common.config
 * @Project：my
 * @Date：22/11/2024 9:18 am
 */
public class BDSessionListener implements SessionListener {
    private final AtomicInteger sessionCount = new AtomicInteger(0);
    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
    }
}
