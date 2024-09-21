package Controllers;

import Models.Container;
import Models.ContainerShip;
import Models.Port;
import Utils.MyLinkedList;
import Utils.SearchUtil;

import java.io.*;

public class PortController {
    private File file;
private Port port;

    private Port.PortNode head;
    private Port pickedPort;
    private final String fileName = "Port.xml";
    private Container.ContainerNode containerShipNodes;
    private Container container;
    private MyLinkedList<Container> inPort;
    private MyLinkedList<ContainerShip> atPort;

    public PortController(File file, Port port){
        this.file=file;
        this.port = port;

    }

    public void addPort(String portName, int interPortCode, String portCountry) {
        Port newPort = new Port(portName, interPortCode, portCountry);
        Port.PortNode newNode = new Port.PortNode(newPort);

        //new port node to beginning of list
        newNode.next = head;
        head = newNode;

        System.out.println("Port " + portName + " added");
    }

    public void showPorts() {
        Port.PortNode now = head;
        while (now != null) {
            System.out.println(now.port);
            now = now.next;
        }
    }

    //  ---------------------------
    //  searching
    //  ---------------------------
    public void searchNamesGoods(String goodsName) {
    SearchUtil.searchNamesGoods(goodsName);    }


    private void searchGoodsInPort(Port port, String goodsName) {
        SearchUtil.searchGoodsInPort(port, goodsName);
    }

    private void searchGoodsInContShip(ContainerShip containerShip, String goodsName) {
        SearchUtil.searchGoodsInContShip(containerShip, goodsName);

    }

    private void searchGoodsInCont(ContainerShip containerShip, String goodsName) {

        SearchUtil.searchGoodsInCont(containerShip, goodsName);

    }

    private void searchGoodsInPallet(PalletController.PalletNode palletNode, String goodsName) {

        SearchUtil.searchGoodsInPallet(palletNode, goodsName);


    }

    public void shipLocation(){
        System.out.println("Ship stored at port " + port.getPortName() + ":");
        System.out.println("Ships at a port: ");
        MyLinkedList<ContainerShip> atPort = port.getAtPort();
    MyLinkedList.Node<ContainerShip> now = atPort.getHead();

    while(now!= null) {
        ContainerShip containerShip = now.getData();
        System.out.println(containerShip.getShipName());

        now = now.getNext();

    }

    }



    public void load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Port.xml"))) {
            while (true) {
                try {
                    Port port = (Port) in.readObject();
                    System.out.println("Loaded port: " + port);
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }


   public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Port.xml"))) {
            out.writeObject(port);
       }
    }

    public String file() {
        return "Port.xml";
    }

    public void reset() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Port.xml"))) {    //writing nothing clears file data

        }
    }
}












