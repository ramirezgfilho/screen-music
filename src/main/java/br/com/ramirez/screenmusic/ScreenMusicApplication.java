package br.com.ramirez.screenmusic;

import br.com.ramirez.screenmusic.principal.Principal;
import br.com.ramirez.screenmusic.repository.ArtistaRepository;
import br.com.ramirez.screenmusic.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private MusicaRepository musicaRepository;

	public static void main(String[] args) {

		SpringApplication.run(ScreenMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistaRepository, musicaRepository);

		principal.exibeMenu();

	}
}
