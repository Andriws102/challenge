package com.javaexercise.challenge.aspect;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceTrackerHandler implements ObservationHandler<Observation.Context> {

    private static final Logger log = LoggerFactory.getLogger(PerformanceTrackerHandler.class);

    @Override
    public void onStart(Observation.Context context) {
        log.info("start execution {}", context.getName());
        context.put("time",System.currentTimeMillis());
    }

    @Override
    public void onError(Observation.Context context) {
        log.info("execution error {} ", context.getError().getMessage());
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
        ObservationHandler.super.onEvent(event, context);
    }

    @Override
    public void onScopeOpened(Observation.Context context) {
        ObservationHandler.super.onScopeOpened(context);
    }

    @Override
    public void onScopeClosed(Observation.Context context) {
        ObservationHandler.super.onScopeClosed(context);
    }

    @Override
    public void onScopeReset(Observation.Context context) {
        ObservationHandler.super.onScopeReset(context);
    }

    @Override
    public void onStop(Observation.Context context) {
        long duration = System.currentTimeMillis() - context.getOrDefault("time", 0L);
        log.info("finish execution " + context.getName() + " final time: " + duration + "ms");
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }
}
