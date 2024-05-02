package br.com.ramirez.screenmusic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipoArtistaEnum;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();


    public Artista() {}

    public Artista(String nome, TipoArtista tipoArtistaEnum) {
        this.nome = nome;
        this.tipoArtistaEnum = tipoArtistaEnum;
    }


    public Long getId() {
        return id;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Enum<TipoArtista> getTipoArtistaEnum() {
        return tipoArtistaEnum;
    }

    public void setTipoArtistaEnum(TipoArtista tipoArtistaEnum) {
        this.tipoArtistaEnum = tipoArtistaEnum;
    }


    @Override
    public String toString() {
        return "\n Nome: " + nome +
                "\n Tipo de grupo: " + tipoArtistaEnum;
    }
}
