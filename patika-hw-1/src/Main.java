import model.House;
import model.Villa;
import model.Summerhouse;
import repository.HouseRepository;
import repository.VillaRepository;
import repository.SummerhouseRepository;
import service.BuildingService;
import service.BuildingServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        House h1 = new House(new BigDecimal("100000"), 100.0, "3+1");
        House h2 = new House(new BigDecimal("150000"), 120.0, "4+1");
        House h3 = new House(new BigDecimal("200000"), 140.0, "5+1");

        Villa v1 = new Villa(new BigDecimal("300000"), 200.0, "3+1");
        Villa v2 = new Villa(new BigDecimal("350000"), 220.0, "6+2");
        Villa v3 = new Villa(new BigDecimal("400000"), 250.0, "7+2");

        Summerhouse s1 = new Summerhouse(new BigDecimal("250000"), 150.0, "3+1");
        Summerhouse s2 = new Summerhouse(new BigDecimal("270000"), 160.0, "4+2");
        Summerhouse s3 = new Summerhouse(new BigDecimal("290000"), 180.0, "7+2");

        HouseRepository houseRepo = new HouseRepository();
        houseRepo.create(h1);
        houseRepo.create(h2);
        houseRepo.create(h3);

        VillaRepository villaRepo = new VillaRepository();
        villaRepo.create(v1);
        villaRepo.create(v2);
        villaRepo.create(v3);

        SummerhouseRepository summerhouseRepo = new SummerhouseRepository();
        summerhouseRepo.create(s1);
        summerhouseRepo.create(s2);
        summerhouseRepo.create(s3);

        BuildingService buildingService = new BuildingServiceImpl(houseRepo, villaRepo, summerhouseRepo);

        System.out.println("Total of house prices: " + buildingService.getTotalPrice(houseRepo));
        System.out.println("Total of villa prices: " + buildingService.getTotalPrice(villaRepo));
        System.out.println("Total of summerhouse prices: " + buildingService.getTotalPrice(summerhouseRepo));
        System.out.println("Total of all building prices: " + buildingService.getAllBuildingsPrices());
        System.out.println("Average of house square meters: " + buildingService.getAverageSquareMeter(houseRepo));
        System.out.println("Average of villa square meters: " + buildingService.getAverageSquareMeter(villaRepo));
        System.out.println("Average of summerhouse square meters: " + buildingService.getAverageSquareMeter(summerhouseRepo));
        System.out.println("Total of all building square meters: " + buildingService.getAllBuildingsSquareMeters());
        System.out.println("Buildings with 3+1 room: " + buildingService.filterByRoomNumber("3+1"));
    }
}
