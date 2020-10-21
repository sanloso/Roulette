package CleanCode.repository.impl;

import CleanCode.exception.RoulException;
import CleanCode.model.Roulette;
import CleanCode.repository.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouletteRespository implements RouletteRepository {
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "ROULETTE";
    @Override
    public void save(Roulette roulette) {
        redisTemplate.opsForHash().put(KEY, roulette.getId().toString(), roulette);
    }
    @Override
    public List<Roulette> findRoulettes() {
        return redisTemplate.opsForHash().values(KEY);
    }
    @Override
    public Roulette findRouletteById(Long id) throws RoulException {
        Roulette roulette;
        roulette = (Roulette) redisTemplate.opsForHash().get(KEY, id.toString());
        return roulette;
    }
}
