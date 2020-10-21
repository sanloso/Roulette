package CleanCode.controller;

import CleanCode.exception.RoulException;
import CleanCode.model.Bet;
import CleanCode.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bets")
public class BetController {
    @Autowired
    public BetService betService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createBet(@RequestBody Bet bet) throws RoulException {
        Long id = Long.valueOf(betService.findBets().size())+1;
        bet.setId(id);
        try {
            betService.createBet(bet);
            return new ResponseEntity<>(bet.getId(), HttpStatus.ACCEPTED);
        } catch (RoulException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllBets(){
        try {
            List<Bet> bets = betService.findBets();
            return new ResponseEntity<>(bets, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
