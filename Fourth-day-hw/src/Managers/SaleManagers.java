package Managers;

import Entities.Campaign;
import Entities.Game;
import Entities.User;

public class SaleManagers implements ISaleService {

    private final IVerificationService iVerificationService;
    private final IUserService iUserService;

    public SaleManagers(IVerificationService iVerificationService, IUserService iUserService) {
        this.iVerificationService = iVerificationService;
        this.iUserService = iUserService;
    }
    //Dependency Injection


    @Override
    public void saleWithDiscount(User user, Game game, Campaign campaign) {

        boolean verification = iVerificationService.verification(user,iUserService.getUsers());

        if(!verification){
            System.out.println("Couldn't login. Try Again!");
        }
        else{
            int userWallet = user.getMoney();
            int userMoney = user.getMoney();
            int gamePrice = game.getPrice();
            int discountedPrice = gamePrice-(gamePrice*campaign.getDiscount_amount())/100;

            userMoney=userWallet -discountedPrice;

            if(userMoney<0){
                System.out.println("There is no more money for games. Add money to your wallet.");
                System.out.println("***********************************************************");
            }
            else{
                System.out.println("User money left: "+userMoney+"₺.");
                user.setMoney(userMoney);
            }

        }
    }

    @Override
    public void sale(User user, Game game) {

        boolean verification = iVerificationService.verification(user,iUserService.getUsers());

        if(!verification){
            System.out.println("Couldn't login");
        }
        else{
            double userWallet = user.getMoney();
            int gamePrice = game.getPrice();

        }
    }

    private void sale(Game game, User user, boolean buy, int userWallet, int gamePrice) {
        int newUserMoney= userWallet-gamePrice;
        if (newUserMoney <0){
            System.out.println(user.getFirst_name() + " doesn't have enough money to buy "+ game.getName());
            buy = false;
        }
        if (buy) {
            user.setMoney(newUserMoney);
            user.getHasGames().add(game);
            System.out.println(user.getFirst_name() + " bought " + game.getName() + " with $"+gamePrice + " money left : $"+ user.getMoney());
        }
    }
}
