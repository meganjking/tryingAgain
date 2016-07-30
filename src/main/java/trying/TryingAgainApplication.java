package trying;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import trying.domain.Pokemon;

@SpringBootApplication
public class TryingAgainApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TryingAgainApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TryingAgainApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception{
		jdbcTemplate.query(
				"SELECT id, name, type, strength  FROM characters WHERE name = ?", new Object[] { "Megesaur" },
				(rs, rowNum) -> new Pokemon(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("strength"))
		).forEach(pokemon -> log.info(pokemon.toString()));
	}


}
