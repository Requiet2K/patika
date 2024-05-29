package service;

import model.Building;
import repository.BuildingRepository;
import repository.HouseRepository;
import repository.VillaRepository;
import repository.SummerhouseRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collection;


public class BuildingServiceImpl implements BuildingService {

    private final HouseRepository houseRepo;
    private final VillaRepository villaRepo;
    private final SummerhouseRepository summerhouseRepo;

    public BuildingServiceImpl(HouseRepository houseRepo, VillaRepository villaRepo, SummerhouseRepository summerhouseRepo) {
        this.houseRepo = houseRepo;
        this.villaRepo = villaRepo;
        this.summerhouseRepo = summerhouseRepo;
    }

    @Override
    public BigDecimal getTotalPrice(BuildingRepository<? extends Building> repository) {
        return repository.getBuildingList().stream()
                .map(Building::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Double getAverageSquareMeter(BuildingRepository<? extends Building> repository) {
        List<? extends Building> buildings = repository.getBuildingList();
        if (buildings.isEmpty()) {
            return null;
        }
        return buildings.stream()
                .mapToDouble(Building::getSquareMeter)
                .average().orElse(0.0);
    }

    @Override
    public List<Building> filterByRoomNumber(String roomNumber) {
        return Stream.of(houseRepo.getBuildingList(), villaRepo.getBuildingList(), summerhouseRepo.getBuildingList())
                .flatMap(Collection::stream)
                .filter(b -> b.getRoomNumber().equals(roomNumber))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getAllBuildingsPrices() {
        return Stream.of(houseRepo, villaRepo, summerhouseRepo)
                .map(this::calculateTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Double getAllBuildingsSquareMeters() {
        return Stream.of(houseRepo, villaRepo, summerhouseRepo)
                .flatMap(repo -> repo.getBuildingList().stream())
                .mapToDouble(Building::getSquareMeter)
                .sum();
    }

    private BigDecimal calculateTotalPrice(BuildingRepository<? extends Building> repository) {
        return repository.getBuildingList().stream()
                .map(Building::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
