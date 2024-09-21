package Utils;

import Controllers.PalletController;
import Models.Container;
import Models.ContainerShip;
import Models.Port;

public class SearchUtil {
    private static Port.PortNode head;
    private static Container.ContainerNode containerShipNodes;

    public static void searchNamesGoods(String goodsName) {
    Port.PortNode portNow = head;

    while (portNow != null) {
        System.out.println(" Looking in port: " + portNow.port.portName);
        searchGoodsInPort(portNow.port, goodsName);
        portNow = portNow.next;
    }
}

    public static void searchGoodsInPort(Port port, String goodsName) {
        ContainerShip.ContainerShipNode usingShip =port.shipsDock;

        while (usingShip != null) {
            System.out.println("Container ship used: " + usingShip.containerShip.shipName);
            searchGoodsInContShip(usingShip.containerShip, goodsName);
            usingShip = usingShip.next;
        }
    }

    public static void searchGoodsInContShip(ContainerShip containerShip, String goodsName) {
        ContainerShip.ContainerShipNode usingContNode = new ContainerShip.ContainerShipNode(containerShip, null);

        while (usingContNode != null) {
            System.out.println("Container ship used: " + usingContNode.containerShip.shipName);
            searchGoodsInCont(usingContNode.containerShip, goodsName);
            usingContNode = usingContNode.next;
        }
    }

    public static void searchGoodsInCont(ContainerShip containerShip, String goodsName) {

        Container.ContainerNode usingCont = containerShipNodes;

        while (usingCont != null) {
            System.out.println("Used Container: " + usingCont.container.getContainerNum());
            searchGoodsInPallet(usingCont.container.getPallets(), goodsName);
            usingCont = usingCont.next;
        }
    }
    public static void searchGoodsInPallet(PalletController.PalletNode palletNode, String goodsName) {

        while(palletNode !=null){
            if (palletNode.pallet.getGoodDescrip().equals(goodsName)) {
                System.out.println(" Pallet decription: " + palletNode.pallet.getGoodDescrip());
                System.out.println("  Quantity of goods: " + palletNode.pallet.getGoodQuantity());
                System.out.println("  Unit Valu: " + palletNode.pallet.getUnitVal());

            }
            palletNode = palletNode.next;

        }
    }
}
