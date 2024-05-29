package repository;

import model.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BuildingRepository<T extends Building> {
    private final List<T> buildingList = new ArrayList<>();

    public void create(T building) {
        buildingList.add(building);
    }

    public List<T> getBuildingList() {
        return List.copyOf(buildingList);
    }
}
