package Main;

import Controllers.ContainerController;
import Controllers.ContainerShipController;
import Controllers.PalletController;
import Controllers.PortController;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Models.Container;
import Models.ContainerShip;
import Models.Pallet;
import Models.Port;

import Utils.MyLinkedList;
import Utils.SearchUtil;

public class Driver {


    private static MyLinkedList<Object> myLinkedList;
    private PalletController palletController;
    private PortController portController;
    private ContainerController containerController;
    private ContainerShipController containerShipController;
    private Port port;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Driver driver = new Driver();
        driver.start();
    }

//}

    public void start() throws IOException, ClassNotFoundException {
        initializingControllers();
        myLinkedList = new MyLinkedList<>();

        Scanner scanner = new Scanner(System.in);

        port = new Port("port9" , 77, "Aus");

        //load();
    save();


        int option;
        do {
            option = mainMenu();
            switch (option) {
                case 1 -> runAddPort();
                case 2 -> runAddContainerShip();
                case 3 -> runAddPallet();
                case 4 -> runAddContainer();
                case 5 -> runLoadUnload();
                case 6 -> runLaunchDock();
                case 7 -> runViewLocations();
                case 8 -> runSearchForGoods();
                case 9 -> runRemovePallet();
                case 10 -> save();
                case 11 -> load();
               case 12 -> resetData();
                default -> System.out.println("Invalid option entered" + option);
            }
            Utils.ScannerInput.readNextLine("\n Press the enter key to continue");
        } while (option != 0) ;


            }


    private int mainMenu() {

                System.out.println("""
                         -------Port Management System------------
                        |  1) Add a port                         |
                        |  2) Add container ship                 |
                        |  3) Add a pallet                       |
                        |  4) Add a container                    |
                        |----------------------------------------|
                        |  5) Load/Unload existing containers    |
                        |  6) Launch and dock container Ships    |  
                        |  7) View ALL ship locations                |
                        |  8) Search for goods
                        |  9) Remove Pallets
                        |----------------------------------------|
                        |  10) Save all                          |
                        |  11) Load all                          |
                        |  12) Reset all                         |
                        |----------------------------------------|
                        |  0) Exit                               |
                        |-------------------------------------""");
                return Utils.ScannerInput.readNextInt("==>> ");


            }
            private static void runAddPort(){
        Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Port Name: ");
                String portName = scanner.nextLine();
                System.out.println("Enter International Port Code: ");
                int interPortCode = scanner.nextInt();
                System.out.println("Enter Port Country: ");
                String portCountry = scanner.nextLine();

                myLinkedList.insert(new Port(portName, interPortCode, portCountry));

            }
    private static void runAddContainerShip(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Ship Name: ");
        String shipName = scanner.nextLine();
        System.out.println("Enter Ship indentifier: ");
        String identShip = scanner.nextLine();
        System.out.println("Enter Ship flag state: ");
        String flagState = scanner.nextLine();
        System.out.println("Enter url of photo of ship: ");
        String shipPhotoURL = scanner.nextLine();

        myLinkedList.insert(new ContainerShip(shipName, identShip, flagState, shipPhotoURL));

    }
    private static void runAddPallet(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter description of the pallet: ");
        String goodDescrip = scanner.nextLine();
        System.out.println("Enter quantity of goods: ");
        int goodQuantity = scanner.nextInt();
        System.out.println("Enter value per unit: ");
        int unitVal = scanner.nextInt();
        System.out.println("Enter weight of the pallet: ");
        double totWeight = scanner.nextDouble();
        System.out.println("Enter size of the pallet: ");
        double totSize = scanner.nextDouble();

        myLinkedList.insert(new Pallet(null,goodDescrip, goodQuantity, unitVal,totWeight, totSize));

    }
    private static void runAddContainer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Port Name: ");
        int containerNum = scanner.nextInt();
        System.out.println("Enter International Port Code: ");
        int containerSize = scanner.nextInt();

        myLinkedList.insert(new Container(containerNum, containerSize));

    }

    private void runSearchForGoods(){
        SearchUtil.searchNamesGoods("");
    }
    public void runRemovePallet(){
        Container container = new Container(1, 100);
        Pallet pallet = new Pallet(null, "product",3,4,5,6);
        ContainerController.removePallet(container, pallet);
        System.out.println(" Container details after removal:  ");
        System.out.println(container);
    }

    private void runViewLocations() {
        portController.shipLocation();
    }

    private void runLoadUnload() {
        ContainerShip containerShip = new ContainerShip("ship0", "AAA", "New York", "URL");
        Port port = new Port("Port0" , 077, "USA");
        Container container = new Container(1,100);

        //unload/load to and from ship
        containerShip.loadCont(container);
        containerShip.unLoadCont(container);

        //load/unload too and from port
        port.loadCont(container);
        port.unLoadCont(container);
    }
    private void runLaunchDock() {
        ContainerShip containerShip = new ContainerShip("ship1", "AAA", "New York", "URL");
        Port port = new Port("Port1", 777, "USA");
        Container container = new Container(1,100);


        port.portShip(containerShip);
        port.deportShip(containerShip);
    }


                private void exitApp() throws IOException {
                save();
                System.out.println("Exiting....");
                System.exit(0);
                }

                private void initializingControllers() {
                  File portFile = new File("Port.xml");
                  File palletFile = new File("Pallet.xml");
                  File containerFile = new File("Container.xml");
                  File containerShipFile = new File("ContainerShip.xml");

                  Port port = new Port("port6" , 777, "Australia");
Pallet pallet = new Pallet(null, "product1",9,33,234,43);
Container container = new Container(3400,9994);
ContainerShip containerShip = new ContainerShip("Titanic", "AACD", "USA", "URL");

                    portController = new PortController(portFile, port);
                    palletController = new PalletController(palletFile, pallet);
                    containerController = new ContainerController(containerFile, container);
                    containerShipController = new ContainerShipController(containerShipFile, containerShip);
                }
                    private void save() throws IOException {
                 //   portController.save();
                    palletController.save();
                    containerController.save();
                    containerShipController.save();
    }

    private void load() throws IOException, ClassNotFoundException {
        portController.load();
        palletController.load();
        containerController.load();
        containerShipController.load();

    }
    private void resetData() throws IOException {
        portController.reset();
        palletController.reset();
        containerController.reset();
        containerShipController.reset();
    }
    }


