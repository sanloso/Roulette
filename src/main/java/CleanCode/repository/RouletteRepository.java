package CleanCode.repository;

import CleanCode.exception.RoulException;
import CleanCode.model.Bet;
import CleanCode.model.Roulette;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RouletteRepository {
    public void save(Roulette roulette);
    public List<Roulette> findRoulettes();
    public Roulette findRouletteById(Long id) throws RoulException;
    public void save(Bet bet);
    public List<Bet> findBets();
}
