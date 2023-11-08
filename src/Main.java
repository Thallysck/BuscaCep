import br.com.buscacep.modelos.ConsultaViaCep;
import br.com.buscacep.modelos.Endereco;
import br.com.buscacep.modelos.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String cep;

        Scanner input = new Scanner(System.in);
        ConsultaViaCep consultaViaCep = new ConsultaViaCep();
        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();

        String resposta = "sim";

        while (resposta.equalsIgnoreCase("sim")){
            System.out.println("Informe o CEP desejado para consulta: ");
            cep = input.nextLine();

            try{
                Endereco novoEndereco = consultaViaCep.buscarCep(cep);
                geradorDeArquivo.SalvaJson(novoEndereco);
            } catch (RuntimeException e){
                System.out.println("Não consegui obter o endereço a partir desse CEP!");
            }


            System.out.println("Deseja realizar mais uma consulta?: [Sim/Nao]");
            resposta = input.nextLine();
        }


    }
}