package Models;

import Controllers.PalletController;

public class Pallet {
    public Pallet nextPallet;
    public String goodDescrip;
    public int goodQuantity;
    public int unitVal;
    public double totWeight;
    public double totSize;
    private PalletNode head;

    public Pallet(Pallet nextPallet, String goodDescrip, int goodQuantity, int unitVal, double totWeight, double totSize) {
        this.nextPallet = nextPallet;
        this.goodDescrip = goodDescrip;
        this.goodQuantity = goodQuantity;
        this.unitVal = unitVal;
        this.totWeight = totWeight;
        this.totSize = totSize;


    }


    public Pallet getNxtPallet() {
        return nextPallet;
    }

    public void setNxtPallet(Pallet nxtPallet) {
        this.nextPallet = nxtPallet;
    }

    public String getGoodDescrip() {
        return goodDescrip;
    }

    public void setGoodDescrip(String goodDescrip) {
        this.goodDescrip = goodDescrip;
    }

    public int getGoodQuantity() {
        return goodQuantity;
    }

    public void setGoodQuantity(int goodQuantity) {
        this.goodQuantity = goodQuantity;
    }

    public int getUnitVal() {
        return unitVal;
    }

    public void setUnitVal(int unitVal) {
        this.unitVal = unitVal;
    }

    public double getTotWeight() {
        return totWeight;
    }

    public void setTotWeight(double totWeight) {
        this.totWeight = totWeight;
    }

    public double getTotSize() {
        return totSize;
    }

    public void setTotSize(double totSize) {
        this.totSize = totSize;
    }

    public boolean checkAddPallet(double containerSize, PalletNode head){
        double occupiedSpace = 0;
        PalletNode usingPalletNode = head;

       while (usingPalletNode != null){
           occupiedSpace += usingPalletNode.pallet.getTotSize();
           usingPalletNode = usingPalletNode.next;
       }
        double newSpaceNeeded = this.getTotSize();
       return occupiedSpace +newSpaceNeeded <= containerSize;


    }
    public static class PalletNode extends PalletController.PalletNode {
        public Pallet pallet;
        public PalletNode next;

        public PalletNode(Pallet pallet, PalletNode next){

            this.pallet = pallet;
            this.next = next;
        }
    }
    @Override
    public String toString() {
        return "pallets{" +
                "nxtPallet=" + nextPallet +
                ", goodDescrip='" + goodDescrip + '\'' +
                ", goodQuantity=" + goodQuantity +
                ", unitVal=" + unitVal +
                ", totWeight=" + totWeight +
                ", totSize=" + totSize +
                '}';
    }
}
