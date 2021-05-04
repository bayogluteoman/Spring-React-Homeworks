package Managers;

import Entities.Game;

public class GameManagers implements IGameService{
    @Override
    public void add(Game game) {
        System.out.println("***********************************************************");
        System.out.println("The "+game.getName()+" has added with "+game.getPrice()+"₺." );

    }

    @Override
    public void delete(Game game) {
        System.out.println("The "+game.getName()+"has been deleted.");
    }

    @Override
    public void update(Game game, int newPrice) {
        game.setPrice(newPrice);
        System.out.println("The "+game.getName()+" price updated to "+game.getPrice()+"₺.");
    }
}
