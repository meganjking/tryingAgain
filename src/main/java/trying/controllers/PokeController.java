package trying.controllers;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trying.domain.Pokemon;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Megan on 7/29/2016.
 */

@RestController
public class PokeController {
    ArrayList<Pokemon> pokemons;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final AtomicLong counter = new AtomicLong(-1);

    public PokeController(){
        pokemons = new ArrayList<Pokemon>();
//        pokemons[0] = new Pokemon(1,"Pikachu","Electric", 5);
//        pokemons[1] = new Pokemon(2,"Charizard","Fire", 7);
    }

    @RequestMapping(value = "/pokemon", method = RequestMethod.GET)
    public ArrayList<Pokemon> getAllPokemon(){
        jdbcTemplate.query(
                "SELECT id, name, type, strength  FROM characters",
                (rs, rowNum) -> new Pokemon(rs.getInt("id"), rs.getString("name"),
                        rs.getString("type"), rs.getInt("strength"))).forEach(pokemon -> pokemons.add(pokemon));
        return pokemons;
    }

//    @RequestMapping(value = "/pokemon", method = RequestMethod.POST)
//    public Pokemon postPokemon(@RequestParam(value = "name") String name,
//                               @RequestParam(value = "type") String type,
//                               @RequestParam(value = "strength") int strength){
//        int count2 = (int) counter.incrementAndGet();
//        pokemons[count2] = new Pokemon(count2,name,type,strength);
//
//        return pokemons[count2];
//    }


}
