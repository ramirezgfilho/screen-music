package br.com.ramirez.screenmusic.model;

public enum GeneroMusica {

    METAL,
    ROCK,
    MPB,
    POPROCK;

    public static GeneroMusica fromString(String text){
        for (GeneroMusica generoMusica : GeneroMusica.values()){
            if (generoMusica.toString().equalsIgnoreCase(text)){
                return generoMusica;
            }
        }
        throw new IllegalArgumentException("Nenhum genêro encontrado, digite novamente por favor!");
    }

}
