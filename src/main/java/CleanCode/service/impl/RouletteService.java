package CleanCode.service.impl;

import CleanCode.exception.RoulException;
import CleanCode.model.Bet;
import CleanCode.model.Roulette;
import CleanCode.repository.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RouletteService implements CleanCode.service.RouletteService {
    @Autowired
    private RouletteRepository rouletteRepository;
    @Override
    public void createRoulete(Roulette roulette) throws RoulException{
        try {
            rouletteRepository.save(roulette);
        } catch (Exception e) {
            throw new RoulException("can't create a roulette");
        }
    }
    public List<Roulette> findRoulettes() throws RoulException {
        try {
            return rouletteRepository.findRoulettes();
        } catch (Exception e) {
            throw new RoulException("can't find the roulettes");
        }
    }
    public boolean getStatus(Long id) throws RoulException{
        Roulette roulette = null;
        try {
            roulette = rouletteRepository.findRouletteById(id);
            return roulette.getStatus();
        }catch (Exception e) {
            throw new RoulException("Can't change the status");
        }
    }
    public List<Bet> changeStatus(Long id) throws RoulException {
        Roulette roulette = null;
        try {
            roulette = rouletteRepository.findRouletteById(id);
            if (!roulette.getStatus()) {
                roulette.setStatus(true);
                rouletteRepository.save(roulette);
                return null;
            }else{
                roulette.setStatus(false);
                List<Bet> list = colorAndNumberWinner(roulette);
                List<Bet> copyList = new ArrayList<Bet>(list);
                roulette.setBets(0);
                roulette.getBetList().clear();
                rouletteRepository.save(roulette);
                return copyList;
            }
        } catch (Exception e) {
            throw new RoulException("Can't change the status");
        }
    }
    private List<Bet> colorAndNumberWinner(Roulette roulette){
        String color = null;
        Random rand = new Random();
        int upperbound = 37;
        int winningNumber = rand.nextInt(upperbound);
        if (winningNumber%2 == 0){
            color = "red";
        }else{
            color = "black";
        }
        List<Bet> list = selectWinners(roulette, winningNumber, color);
        return list;
    }
    private List<Bet> selectWinners(Roulette roulette, int winningNumber, String color){
        List<Bet> list = roulette.getBetList();
        System.out.println(list);
        for (Bet b: list){
            if (b.getColor() != null) {
                if (b.getColor().equals(color)) {
                    b.setResult("winner Color");
                    b.setMoneyEarned((float) (b.getMoney() * 1.8));
                    rouletteRepository.save(b);
                }
            }else{
                if (b.getNumber() == winningNumber){
                    b.setResult("winner Number");
                    b.setMoneyEarned((b.getMoney()*5));
                rouletteRepository.save(b);
                }
            }

        }
        return list;
    }
}
