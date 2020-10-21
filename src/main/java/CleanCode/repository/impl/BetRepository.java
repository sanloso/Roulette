package CleanCode.repository.impl;

import CleanCode.model.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BetRepository implements CleanCode.repository.BetRepository {
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "BET";
    @Override
    public void save(Bet bet) {
        redisTemplate.opsForHash().put(KEY, bet.getId().toString(), bet);
    }
    @Override
    public List<Bet> findBets() {
        return redisTemplate.opsForHash().values(KEY);
    }
}
