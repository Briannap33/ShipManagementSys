package Controllers;

import Models.ContainerShip;
import Models.Pallet;
import Models.Port;
import Utils.SearchUtil;

import java.io.*;

public class PalletController {
    private File file;
    private Pallet pallet;

    private PalletNode head;
    private Pallet pickedPallet;
    private final String fileName = "Pallet.xml";

        public PalletController(File file, Pallet pallet){
            this.file = file;
            this.pallet = pallet;
        }

        public void addPallet(Pallet nxtPallet, String goodDescrip, int goodQuantity, int unitVal, double totWeight, double totSize ) {
            Pallet newPallet = new Pallet(nxtPallet, goodDescrip, goodQuantity, unitVal, totWeight,totSize);
            PalletController.PalletNode newNode = new PalletController.PalletNode();

            newNode.next = head;
            head = newNode;

            System.out.println("Pallet added");
        }

        public void showPallets() {
            PalletController.PalletNode now = head;
            while (now != null) {
                System.out.println(now.pallet);
                now = now.next;
            }
        }

        public static class PalletNode {
            public Pallet pallet;
            public PalletNode next;

          public PalletNode() {
                this.pallet = pallet;
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


    public void load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Pallet.xml"))) {
            while (true) {
                try {
                    Pallet pallet = (Pallet) in.readObject();
                    System.out.println("Loaded pallet: " + pallet);
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }


    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Pallet.xml"))) {
            out.writeObject(pallet);
        }
    }

    public String file() {
        return "Pallet.xml";
    }
    public void reset() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Pallet.xml"))) {    //writing nothing clears file data

        }
    }
}


