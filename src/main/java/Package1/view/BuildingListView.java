package Package1.view;

import Package1.controller.BuildingController;
import Package1.model.input.BuildingSearchInput;
import Package1.model.output.BuildingSearchOutput;

import java.util.List;
import java.util.Scanner;

public class BuildingListView {
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String name = in.nextLine();

        String name = null;
        Integer floorArea = 100;
        String street = null;
        String district = null;
        String ward = null;

        BuildingSearchInput buildingSearchInput = new BuildingSearchInput();
        buildingSearchInput.setName(name);
        buildingSearchInput.setStreet(street);
        buildingSearchInput.setDistrict(district);
        buildingSearchInput.setWard(ward);
        buildingSearchInput.setFloorArea(floorArea);

        BuildingController buildingController = new BuildingController();
        List<BuildingSearchOutput> buildingSearchOutputs = buildingController.findBuilding(buildingSearchInput);
        for (BuildingSearchOutput item: buildingSearchOutputs) {
            System.out.print("ID: " + item.getId());
            System.out.print(", name: " + item.getName());
            System.out.println(", address: " + item.getAddress());
        }
//        in.close();
    }
}
