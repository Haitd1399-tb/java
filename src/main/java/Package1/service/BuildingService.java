package Package1.service;

import Package1.model.input.BuildingSearchInput;
import Package1.model.output.BuildingSearchOutput;

import java.util.List;

public interface BuildingService {
    List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchFilterInput);
}
