package Controllers;

import Models.Container;
import Models.ContainerShip;
import Models.Port;
import Utils.SearchUtil;

import java.io.*;

public class ContainerShipController {
    private File file;
private ContainerShip containerShip;
    private ContainerShipNode head;
    private ContainerShip pickedContainerShip;
public ContainerShipController(File file, ContainerShip containerShip){
    this.file = file;
    this.containerShip = containerShip;
}

    public void addContainerShip(String shipName, String identShip, String flagState, String shipPhotoURL) {
        ContainerShip newContainerShip = new ContainerShip(shipName, identShip, flagState, shipPhotoURL);
        ContainerShipController.ContainerShipNode newNode = new ContainerShipController.ContainerShipNode(newContainerShip);

        newNode.next = head;
        head = newNode;
        System.out.println("Container Ship added");
    }

    public void showContainerShips() {
        ContainerShipController.ContainerShipNode now = head;
        while (now != null) {
            System.out.println(now.containerShip);
            now = now.next;
        }
    }

    public static class ContainerShipNode {
        ContainerShip containerShip;
        ContainerShipNode next;

        ContainerShipNode(ContainerShip containerShip) {
            this.containerShip = containerShip;
            this.next = null;
        }
    }
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
    public void loadCont(ContainerShip containerShip, Container container){
        containerShip.loadCont(container);
    }
    public void unLoadCont(ContainerShip containerShip, Container container){
        containerShip.unLoadCont(container);
    }




    public void launch(ContainerShip containerShip){
containerShip.launch();    }

    public void dock(ContainerShip containerShip, Port port){
containerShip.dock(port);   }

    public void load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ContainerShip.xml"))) {
            while (true) {
                try {
                    ContainerShip containerShip = (ContainerShip) in.readObject();
                    System.out.println("Loaded container ship: " + containerShip);
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }


    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ContainerShip.xml"))) {
            out.writeObject(containerShip);

        }
    }
        public String file () {
            return "ContainerShip.xml";
        }
    public void reset() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ContainerShip.xml"))) {    //writing nothing clears file data

        }
    }
    }


