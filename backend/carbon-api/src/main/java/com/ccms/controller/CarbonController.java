package com.ccms.controller;

import com.ccms.service.CarbonService;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;
import java.util.Map;

@RestController
@RequestMapping("/api/carbon")
public class CarbonController {
    private final CarbonService carbonService;

    public CarbonController(CarbonService carbonService) {
        this.carbonService = carbonService;
    }

    @GetMapping("/stats")
    public Map<String, Object> stats() {
        DoubleSummaryStatistics stats = carbonService.getStats();
        return Map.of(
                "count", stats.getCount(),
                "sum", stats.getSum(),
                "avg", stats.getAverage(),
                "min", stats.getMin(),
                "max", stats.getMax()
        );
    }
}
