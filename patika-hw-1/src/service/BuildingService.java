package service;

import model.Building;
import repository.BuildingRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BuildingService {
    BigDecimal getAllBuildingsPrices();
    Double getAllBuildingsSquareMeters();
    BigDecimal getTotalPrice(BuildingRepository<? extends Building> repository);
    Double getAverageSquareMeter(BuildingRepository<? extends Building> repository);
    List<Building> filterByRoomNumber(String roomNumber);
}
