package Models;


import Controllers.PalletController;
import Utils.MyLinkedList;

public class Container {
    public int containerNum;
    public int containerSize;
    private static ContainerNode head;
    public static Pallet.PalletNode palletsHead;
    private MyLinkedList<Pallet> palletList;

    public Container(int containerNum, int containerSize) {
        if (uniqueContNum(containerNum)) {
            this.containerNum = containerNum;
            this.containerSize = containerSize;
            this.palletList = new MyLinkedList<>();
        }
    }
    public int getContainerNum() {
        return containerNum;
    }

    public void setContainerNum(int containerNum) {
        if(uniqueContNum(containerNum)){
            this.containerNum = containerNum;
        } else{
            throw new IllegalArgumentException("Already in use.")  ;
        }
    }
    private boolean uniqueContNum(int containerNum) {
        Container.ContainerNode now = head;
        while (now != null) {
            if (now.container.getContainerNum() == containerNum) {
                return false;
            }
            now = now.next;
        }
        return true;
    }

    public int getContainerSize() {

        return containerSize;
    }

    public void setContainerSize(int containerSize) {

        this.containerSize = containerSize;
    }
    public PalletController.PalletNode getPallets() {
if(palletsHead != null){
    return palletsHead;
} else {
    return null;
}

}

public void removePallet(Pallet pallet) {
}

        public static class ContainerNode {
        public Container container;
        public ContainerNode next;

        public ContainerNode(Container container){
            this.container = container;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        return "container{" +
                "containerNum=" + containerNum +
                ", containerSize=" + containerSize +
                '}';
    }
}
