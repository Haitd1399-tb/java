package Package1.dao;

import Package1.dao.ckyeuvk.BuildingCkyeuvk;

import java.util.List;

public interface BuildingDao {
    List<BuildingCkyeuvk> findBuilding(String name);
}
