package br.com.buscacep.modelos;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String estado;
    private String cidade;

    public Endereco(String cep, String logradouro, String complemento, String bairro, String estado, String cidade) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Endereco (EnderecoViaCep enderecoViaCep){
        this.cep = enderecoViaCep.cep();
        this.logradouro = enderecoViaCep.logradouro();
        this.complemento = enderecoViaCep.complemento();
        this.bairro = enderecoViaCep.bairro();
        this.estado = enderecoViaCep.uf();
        this.cidade = enderecoViaCep.localidade();
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Cep: " + cep + '\n'
                + "Estado: " + estado + '\n'
                + "Cidade: " + cidade + '\n'
                + "Logradouro: " + logradouro + '\n'
                + "Bairro: " + bairro + '\n'
                + "Complemento: " + complemento;
    }
}
