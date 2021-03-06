package CleanCode.controller;

import CleanCode.exception.RoulException;
import CleanCode.model.Bet;
import CleanCode.model.Roulette;
import CleanCode.service.impl.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/roulettes")
public class RouletteController {
    @Autowired
    public RouletteService rouletteService;
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ResponseEntity<?> createRoulette() throws RoulException {
        Long id = Long.valueOf(rouletteService.findRoulettes().size())+1;
        Roulette roulette = new Roulette(id);
        try {
            rouletteService.createRoulete(roulette);
            return new ResponseEntity<>(roulette.getId(), HttpStatus.ACCEPTED);
        } catch (RoulException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> openRoulette(@PathVariable Long id ) throws RoulException {
        try {
            if (!rouletteService.getStatus(id)) {
                List<Bet> list = rouletteService.changeStatus(id);
                return new ResponseEntity<>("Succes", HttpStatus.ACCEPTED);
            }else{
                List<Bet> list = rouletteService.changeStatus(id);
                return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
            }
        }catch (RoulException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllRoulette(){
        try {
            List<String> shows = new ArrayList<String>();
            List<Roulette> roulettes = rouletteService.findRoulettes();
            for (Roulette r: roulettes){
                shows.add("id: "+r.getId()+" Status: "+r.getStatus());
            }
            return new ResponseEntity<>(shows, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
