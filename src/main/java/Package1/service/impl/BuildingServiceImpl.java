package Package1.service.impl;

import Package1.dao.BuildingDao;
import Package1.dao.ckyeuvk.BuildingCkyeuvk;
import Package1.dao.impl.BuildingDaoImpl;
import Package1.model.input.BuildingSearchInput;
import Package1.model.output.BuildingSearchOutput;
import Package1.service.BuildingService;

import java.util.ArrayList;
import java.util.List;

public class BuildingServiceImpl implements BuildingService {

    BuildingDao buildingDao = new BuildingDaoImpl();

    @Override
    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchFilterInput) {
        List<BuildingSearchOutput> results = new ArrayList<>();
        List<BuildingCkyeuvk> buildingCkyeuvks = buildingDao.findBuilding(buildingSearchFilterInput.getName());

        for(BuildingCkyeuvk item: buildingCkyeuvks) {
            BuildingSearchOutput buildingSearchFilterOutput = new BuildingSearchOutput();
            buildingSearchFilterOutput.setId(item.getId());
            buildingSearchFilterOutput.setName(item.getName());
            buildingSearchFilterOutput.setAddress(item.getStreet() +" - "+ item.getDistrict() +" - "+ item.getWard());
            results.add(buildingSearchFilterOutput);
        }

        return results;
    }
}
