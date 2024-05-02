package br.com.ramirez.screenmusic.repository;

import br.com.ramirez.screenmusic.model.Artista;
import br.com.ramirez.screenmusic.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findByArtistaId(Long id);

}
