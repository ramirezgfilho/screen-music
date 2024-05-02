package br.com.ramirez.screenmusic.principal;

import br.com.ramirez.screenmusic.model.Artista;
import br.com.ramirez.screenmusic.model.GeneroMusica;
import br.com.ramirez.screenmusic.model.Musica;
import br.com.ramirez.screenmusic.model.TipoArtista;
import br.com.ramirez.screenmusic.repository.ArtistaRepository;
import br.com.ramirez.screenmusic.repository.MusicaRepository;
import br.com.ramirez.screenmusic.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {





    Scanner scanner = new Scanner(System.in);
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;

    public Principal(ArtistaRepository artistaRepository, MusicaRepository musicaRepository){
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }


    public void exibeMenu(){
        System.out.println("Menu inicial do programa: ");



        var opcao = -1;

        while (opcao != 9) {
            System.out.println("" +
                    "\n 1- Cadastrar artistas" +
                    "\n 2- Cadastrar músicas" +
                    "\n 3- Listar músicas" +
                    "\n 4- Buscar músicas por artistas" +
                    "\n 5- Pesquisar dados sobre um artista" +
                    "\n 9- Sair");

            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao){
                case 1:
                    cadastraArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    consultaDadoArtista();
                    break;
                case 0:
                    break;
            }

        }

    }

    private void consultaDadoArtista() {
        System.out.println("Digite o nome do artista para pesquisar sua descriçâo: ");
        var nomeArtista = scanner.nextLine();
        var resposta = ConsultaChatGPT.obterTraducao(nomeArtista);
        System.out.println(resposta.trim());
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Digite o nome do artista para buscar: ");
        var nomeDoArtista = scanner.nextLine();
        Optional<Artista> artistaOptional = artistaRepository.findByNomeContainingIgnoreCase(nomeDoArtista);
        List<Musica> listMusica = musicaRepository.findByArtistaId(artistaOptional.get().getId());
        listMusica.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Musica> listaMusicas = musicaRepository.findAll();
        listaMusicas.forEach(System.out::println);
    }

    private void cadastrarMusica() {
        System.out.println("Digite o nome da música: ");
        var nomeMusica = scanner.nextLine();
        System.out.println("Digite o gênero da música: METAL, ROCK, MPB, POPROCK. ");
        var generoMusica = scanner.nextLine();
        System.out.println("Digite o nome do artista para adcionar a música: ");
        var nomeArtista = scanner.nextLine();
        Optional<Artista> artistaOptional = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
        Musica novaMusica = new Musica(nomeMusica, GeneroMusica.fromString(generoMusica),artistaOptional.get());
        musicaRepository.save(novaMusica);


    }

    private void cadastraArtista() {
        System.out.println("Digite o nome do artista para cadastrar: ");
        var nomeArtista = scanner.nextLine();
        System.out.println("Digite o tipo de artista: SOLO, DUPLA ou GRUPO");
        var tipoArtista = scanner.nextLine();
        Artista artista = new Artista(nomeArtista, TipoArtista.fromString(tipoArtista.toUpperCase()));
        System.out.println("O artista criado é: " + artista);
        artistaRepository.save(artista);

    }


}
