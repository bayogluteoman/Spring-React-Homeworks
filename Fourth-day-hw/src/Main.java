import Entities.Campaign;
import Entities.Game;
import Entities.User;
import Managers.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<User> userSet = new HashSet<>();
        IVerificationService iVerificationService = new EdevletVerification();
        ICampaignService iCampaignService = new CampaignManagers();
        IGameService iGameService = new GameManagers();
        IUserService iUserService = new UserManagers(userSet);
        ISaleService iSaleService = new SaleManagers(iVerificationService,iUserService);

        User user = new User(1,1234567890,"Teoman","Bayoğlu");

        iUserService.add(user);

        if(iVerificationService.verification(user,iUserService.getUsers())){
            System.out.println("Successful login!");
            iUserService.update(user,200);
        }

        Game fifa = new Game(1,"FIFA 2021",100);
        Game valorant = new Game(2,"VALORANT",100);
        Game nba = new Game(3,"NBA 2021",100);

        iGameService.add(fifa);
        iGameService.add(valorant);
        iGameService.add(nba);

        Campaign eaSports = new Campaign(1,"EA Sports","FIFA 2021",20);
        iCampaignService.add(eaSports);
        iSaleService.saleWithDiscount(user,fifa,eaSports);

        Campaign sony = new Campaign(2,"Sony","Valorant",20);
        iCampaignService.add(sony);
        iSaleService.saleWithDiscount(user,valorant,sony);

        Campaign xbox = new Campaign(3,"XBOX ","NBA 2021",20);
        iCampaignService.add(xbox);
        iSaleService.saleWithDiscount(user,nba,xbox);

        iCampaignService.update(xbox,45);
        iCampaignService.delete(sony);

        iGameService.update(fifa,150);
    }
}
