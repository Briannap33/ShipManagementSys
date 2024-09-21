package Models;

import Utils.MyLinkedList;

import java.io.File;

public class ContainerShip {
    public String shipName;
    public String identShip;
    public String flagState;
    private  Port currentPort;
    public boolean atSea;
    public String shipPhotoURL;
    public Container.ContainerNode containerShipNodes;

    private MyLinkedList<Container>  onShip;

    public ContainerShip(String shipName, String identShip, String flagState, String shipPhotoURL) {
        this.shipName = shipName;
        this.identShip = identShip;
        this.flagState = flagState;
        this.shipPhotoURL = shipPhotoURL;
        this.onShip = new MyLinkedList<>();
    }



    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getIdentShip() {
        return identShip;
    }

    public void setIdentShip(String identShip) {
        this.identShip = identShip;
    }

    public String getFlagState() {
        return flagState;
    }

    public void setFlagState(String flagState) {
        this.flagState = flagState;
    }

    public String getShipPhotoURL() {
        return shipPhotoURL;
    }

    public void setShipPhotoURL(String shipPhotoURL) {
        this.shipPhotoURL = shipPhotoURL;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContainerShip that = (ContainerShip) o;

        if (!shipName.equals(that.shipName)) return false;
        if (!identShip.equals(that.identShip)) return false;
        if (!flagState.equals(that.flagState)) return false;
        return shipPhotoURL.equals(that.shipPhotoURL);
    }

    public void loadCont(Container container){
        onShip.insert(container);
        System.out.println("Container loaded to " + shipName);
    }
    public void unLoadCont(Container container){
        onShip.remove(container);
        System.out.println("Container unloaded from " + shipName);
    }

    public void launch(){
        if(!atSea && currentPort != null){
            atSea = true;
            currentPort = null;
            System.out.println(shipName + " is now launched ");
        }else{
            System.out.println("launching is not possible at this time.");
        }
    }
    public  void dock(Port port){
        if (atSea){
            atSea = false;
            currentPort = port;
            System.out.println(shipName + "has been docked at" + port.getPortName());
        }
    }

    @Override
    public String toString() {
        return "containerShip{" +
                "shipName='" + shipName + '\'' +
                ", identShip='" + identShip + '\'' +
                ", flagState='" + flagState + '\'' +
                ", shipPhotoURL='" + shipPhotoURL + '\'' +
                '}';

    }
    public static class ContainerShipNode {
        public ContainerShip containerShip;
        public ContainerShipNode next;

        public ContainerShipNode(ContainerShip containerShip, ContainerShipNode next){
            this.containerShip = containerShip;
            this.next = next;
        }
    }
}
