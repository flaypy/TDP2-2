package br.edu.fatecpg.consumocep.model;

import com.google.gson.annotations.SerializedName;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    @SerializedName("localidade")
    private String cidade;

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
