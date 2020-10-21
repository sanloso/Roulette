package CleanCode.repository;

import CleanCode.model.Bet;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BetRepository {
    public void save(Bet bet);
    public List<Bet> findBets();
}
