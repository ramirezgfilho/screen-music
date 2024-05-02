package br.com.ramirez.screenmusic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMusica;
    @Enumerated(EnumType.STRING)
    private GeneroMusica genero;
    @ManyToOne
    private Artista artista;

    public Musica(String nomeMusica, GeneroMusica genero, Artista artista) {
        this.nomeMusica = nomeMusica;
        this.genero = genero;
        this.artista = artista;
    }

    public Musica() {}

    @Override
    public String toString() {
        return "\n Título: '" + nomeMusica + ", Gênero: " + genero + ", Artista: " + artista.getNome();
    }
}
