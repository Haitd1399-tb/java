package Package1.dao;

import Package1.dao.entity.BuildingEntity;

import java.util.List;

public interface BuildingDao {
    List<BuildingEntity> findBuilding(String name);
}
