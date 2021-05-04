package Managers;

import Entities.Campaign;
import Entities.Game;
import Entities.User;

public interface ISaleService {
    void saleWithDiscount(User user, Game game, Campaign campaign);
    void sale(User user, Game game);
}
