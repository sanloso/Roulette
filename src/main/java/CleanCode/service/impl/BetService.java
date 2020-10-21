package CleanCode.service.impl;

import CleanCode.exception.RoulException;
import CleanCode.model.Bet;
import CleanCode.model.Roulette;
import CleanCode.repository.BetRepository;
import CleanCode.repository.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BetService implements CleanCode.service.BetService {
    @Autowired
    private BetRepository betRepository;
    @Autowired
    private RouletteRepository rouletteRepository;
    @Override
    public void createBet(Bet bet) throws RoulException {
        if (datacheck(bet)){
            Roulette roulette = rouletteRepository.findRouletteById(bet.getNumRoulette());
            roulette.setBets();
            rouletteRepository.save(roulette);
            betRepository.save(bet);
        }
    }
    @Override
    public List<Bet> findBets() throws RoulException {
        try {
            return betRepository.findBets();
        } catch (Exception e) {
            throw new RoulException("can't find the bets");
        }
    }

    @Override
    public boolean datacheck(Bet bet) throws RoulException {
        if (bet.getNumber() < 0 || bet.getNumber() > 37) {
            throw new RoulException("The number is incorrect, the range is between 0 to 36");
        }
        if (!bet.getColor().equals("red") && bet.getColor().equals("black")) {
            throw new RoulException("The color is incorrect. Even numbers are red, odd numbers are black");
        }
        if (bet.getMoney() < 0 || bet.getMoney() > 10000) {
            throw new RoulException("check the amount of money, the maximum amount is");
        }
        if (rouletteRepository.findRouletteById(bet.getNumRoulette()) == null){
            throw new RoulException("The roulette doesn't exist");
        }
        if (rouletteRepository.findRouletteById(bet.getNumRoulette()).getStatus() == false) {
            throw new RoulException("The roulette are not open");
        }
        return true;
    }
}
