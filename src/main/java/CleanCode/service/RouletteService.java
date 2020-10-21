package CleanCode.service;

import CleanCode.exception.RoulException;
import CleanCode.model.Roulette;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouletteService {
    public void createRoulete(Roulette roulette) throws RoulException;
    public List<Roulette> findRoulettes() throws RoulException;
    public void changeStatus(Long id) throws RoulException;
}
