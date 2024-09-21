package Models;


import Utils.MyLinkedList;

public class Port {
    public String portName;
    public int interPortCode;
    public String portCountry;

        Container.ContainerNode contOnShore;
        public ContainerShip.ContainerShipNode shipsDock;
    private static PortNode head;
    private MyLinkedList<Container> inPort;
    private MyLinkedList<ContainerShip> atPort;


    public Port(String portName, int interPortCode, String portCountry) {
        if (uniquePortCode(interPortCode)) {
            this.portName = portName;
            this.interPortCode = interPortCode;
            this.portCountry = portCountry;
            this.contOnShore = null;
            this.shipsDock = null;
        }
    }


    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public int getInterPortCode() {
        return interPortCode;
    }

    public void setInterPortCode(int interPortCode) {
        if(uniquePortCode(interPortCode)){
            this.interPortCode = interPortCode;
        } else{
            throw new IllegalArgumentException(interPortCode +" already in use.")  ;
        }
    }
    private boolean uniquePortCode(int interPortCode) {
        PortNode now = head;
        while (now != null) {
            if (now.port.getInterPortCode() == interPortCode) {
                return false;
            }
            now = now.next;
        }
        return true;
    }
    public String getPortCountry() {
        return portCountry;
    }

    public void setPortCountry(String portCountry) {
        this.portCountry = portCountry;

    }

    public void addContOnShore(Container container) {
        Container.ContainerNode newNode = new Container.ContainerNode(container);
        newNode.next = contOnShore;
        contOnShore = newNode;

        System.out.println("Container " + container.containerNum + " has been put into onshore in " + portName);
    }
    public void loadCont(Container container){
        inPort.insert(container);
        System.out.println("Container loaded to " + portName);
    }
    public void unLoadCont(Container container){
        inPort.remove(container);
        System.out.println("Container unloaded from " + portName);
    }
    public void portShip(ContainerShip containerShip){
        atPort.insert(containerShip);
        System.out.println(containerShip.getShipName() + "has arrived at " +portName);
    }
    public  void deportShip(ContainerShip containerShip){
        atPort.remove(containerShip);
        System.out.println(containerShip.getShipName() + " departed from " +portName);
    }

    public MyLinkedList<ContainerShip> getAtPort() {
        return atPort;
    }

    public void setAtPort(MyLinkedList<ContainerShip> atPort) {
        this.atPort = atPort;
    }


    public static class PortNode {
        public Port port;
        public PortNode next;

        public PortNode(Port port){
            this.port = port;
            this.next = next;
        }
    }


    @Override
    public String toString() {
        return "Port{" +
                "portName='" + portName + '\'' +
                ", interPortCode=" + interPortCode +
                ", portCountry='" + portCountry + '\'' +
                ", contOnShore=" + contOnShore +
                ", shipsDock=" + shipsDock +
                '}';
    }
}
