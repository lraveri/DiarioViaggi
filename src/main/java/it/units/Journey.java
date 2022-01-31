package it.units;

public class Journey {
        
    private String id;
    private String data;
    private String mezzo;
    private String tappe;
    private String percorso;
    private String username;
    
    public Journey() {}

    public Journey(String id, String data, String mezzo, String tappe, String percorso, String username) {
        this.id = id;
        this.data = data;
        this.mezzo = mezzo;
        this.tappe = tappe;
        this.percorso = percorso;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMezzo() {
        return mezzo;
    }

    public void setMezzo(String mezzo) {
        this.mezzo = mezzo;
    }

    public String getTappe() {
        return tappe;
    }

    public void setTappe(String tappe) {
        this.tappe = tappe;
    }

    public String getPercorso() {
        return percorso;
    }

    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
