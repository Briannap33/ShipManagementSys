package Controllers;

import Models.Container;
import Models.ContainerShip;
import Models.Pallet;
import Models.Port;
import Utils.SearchUtil;

import java.io.*;

public class ContainerController {
    private File file;
    private Container container;
    private ContainerNode head;
    private Container pickedContainer;

    public ContainerController(File file, Container container){
        this.file=file;
        this.container=container;
    }

    public void addContainer(int containerNum, int containerSize) {
        Container newContainer = new Container(containerNum, containerSize);
        ContainerController.ContainerNode newNode = new ContainerController.ContainerNode(newContainer);
        //new port node to beginning of list
        newNode.next = head;
        head = newNode;

        System.out.println("Container added");
    }


    public void showContainers() {
        ContainerController.ContainerNode now = head;
        while (now != null) {
            System.out.println(now.container);
            now = now.next;
        }
    }

    public static class ContainerNode {
        Container container;
        ContainerController.ContainerNode next;

        ContainerNode(Container container) {
            this.container = container;
            this.next = null;
        }
    }

    public void searchNamesGoods(String goodsName) {
        SearchUtil.searchNamesGoods(goodsName);
    }


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

    public static void removePallet(Container container, Pallet pallet) {
        if (container.palletsHead != null) {
            Pallet.PalletNode now = container.palletsHead;
            Pallet.PalletNode past = null;

            while (now != null && now.pallet != pallet) {
                past = now;
                now = now.next;
            }
            if (now != null) {
                if (past != null) {
                    past.next = now.next;
                } else {
                    container.palletsHead = now.next;
                }
            }
        }
    }




    public void load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Container.xml"))) {
            while (true) {
                try {
                    Container container = (Container) in.readObject();
                    System.out.println("Loaded container" + container);
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }


    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Container.xml"))) {
            out.writeObject(container);
        }
    }

    public String file() {
        return "Container.xml";
    }

    public void reset() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Container.xml"))) {    //writing nothing clears file data

        }
    }

}
