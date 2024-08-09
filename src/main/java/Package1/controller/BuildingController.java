package Package1.controller;

import Package1.model.input.BuildingSearchInput;
import Package1.model.output.BuildingSearchOutput;
import Package1.service.BuildingService;
import Package1.service.impl.BuildingServiceImpl;

import java.util.List;

public class BuildingController {

    private BuildingService buildingService = new BuildingServiceImpl();

    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
        List<BuildingSearchOutput> results = buildingService.findBuilding(buildingSearchInput);

        return results;
    }
}
