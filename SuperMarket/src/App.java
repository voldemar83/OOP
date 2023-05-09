import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromotionClient;
import Classes.SpecialClient;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {

       Market market = new Market();
       iActorBehaviour item1 = new OrdinaryClient("Беликов Антон" + " -");
       iActorBehaviour item2 = new SpecialClient("Фокин Владимир" + " - Vip", 1101);
       iActorBehaviour item3 = new OrdinaryClient("Туль Инна" + " -");
       iActorBehaviour item4 = new OrdinaryClient("Файзулин Руслан" + " -");
       iActorBehaviour item5 = new SpecialClient("Максимов Антон" + " - Vip", 1221);
       iActorBehaviour item6 = new OrdinaryClient("Смирнова Светлана" + " -");
       iActorBehaviour item7 = new PromotionClient("Огурцова Юлия" + " - Promo", 1333);

       market.acceptToMarket(item1);
       market.acceptToMarket(item2);
       market.acceptToMarket(item3);
       market.acceptToMarket(item4);
       market.acceptToMarket(item5);
       market.acceptToMarket(item6);
       market.acceptToMarket(item7);
       market.update();
    }
}