package CleanCode.service;

import CleanCode.exception.RoulException;
import CleanCode.model.Bet;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BetService {
    public void createBet(Bet bet) throws RoulException;
    public List<Bet> findBets() throws RoulException;
    public boolean datacheck(Bet bet) throws RoulException;
}
