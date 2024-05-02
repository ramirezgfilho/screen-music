package br.com.ramirez.screenmusic.repository;

import br.com.ramirez.screenmusic.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);



}
