package Package1.view;

import Package1.controller.BuildingController;
import Package1.model.input.BuildingSearchInput;
import Package1.model.output.BuildingSearchOutput;

import java.util.List;
import java.util.Scanner;

public class BuildingListView {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        BuildingSearchInput buildingSearchInput = new BuildingSearchInput();
        buildingSearchInput.setName(name);
        BuildingController buildingController = new BuildingController();
        List<BuildingSearchOutput> buildingSearchOutputs = buildingController.findBuilding(buildingSearchInput);
        for (BuildingSearchOutput item: buildingSearchOutputs) {
            System.out.print("ID: " + item.getId());
            System.out.print(", name: " + item.getName());
            System.out.println(", address: " + item.getAddress());
        }
        in.close();
    }
}
