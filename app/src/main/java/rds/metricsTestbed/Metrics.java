package rds.metricsTestbed;

import com.codahale.metrics.MetricRegistry;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Metrics {
    private MeterRegistry meterRegistry;

    @Autowired
    public Metrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void hit(Car car, Cow cow) {
        meterRegistry.counter("hits",
                "kind", "car",
                "color", car.getColor()
        ).increment();
        meterRegistry.counter("hits",
                "kind", "cow",
                "color", cow.getColor()
        ).increment();
        System.out.println(car + " hit " + cow);
    }

    public void escaped(Car car) {
        meterRegistry.counter("escapes",
                "kind", "car",
                "color", car.getColor()
        ).increment();
        System.out.println(car + " escaped!");
    }

    public void escaped(Cow cow) {
        meterRegistry.counter("escapes",
                "kind", "cow",
                "color", cow.getColor()
        ).increment();
        System.out.println(cow + " escaped!");
    }
}
