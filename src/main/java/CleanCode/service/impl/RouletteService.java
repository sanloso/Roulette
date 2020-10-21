package CleanCode.service.impl;

import CleanCode.exception.RoulException;
import CleanCode.model.Roulette;
import CleanCode.repository.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void changeStatus(Long id) throws RoulException {
        Roulette roulette = null;
        try {
            roulette = rouletteRepository.findRouletteById(id);
            if (!roulette.getStatus()) {
                roulette.setStatus(true);
                rouletteRepository.save(roulette);
            }
        } catch (Exception e) {
            throw new RoulException("Can't change the status");
        }
    }
}
