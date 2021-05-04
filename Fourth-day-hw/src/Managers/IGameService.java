package Managers;

import Entities.Game;

public interface IGameService {
    void add(Game game);
    void update(Game game, int newPrice);
    void delete(Game game);
}
