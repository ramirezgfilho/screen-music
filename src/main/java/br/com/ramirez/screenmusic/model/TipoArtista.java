package br.com.ramirez.screenmusic.model;

public enum TipoArtista {

    SOLO,
    DUPLA,
    GRUPO;


    public static TipoArtista fromString(String text){
        for (TipoArtista tipoArtista : TipoArtista.values()){
            if (tipoArtista.toString().equalsIgnoreCase(text)){
                return tipoArtista;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada. Digite novamente. ");
    }


}
