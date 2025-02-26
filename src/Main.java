import br.edu.fatecpg.consumocep.model.Endereco;
import br.edu.fatecpg.consumocep.service.ConsumoApi;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import br.edu.fatecpg.consumocep.service.Hora;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Digite 1 para Consultar CEP");
            System.out.println("Digite 2 para Listar Ceps Consultados");
            System.out.println("Digite 3 para Sair");

            int opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o CEP: ");
                String cep = scan.nextLine();

                String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
                String resp = ConsumoApi.obterDados(url);

                System.out.println("Resposta da API: " + resp);

                Gson gson = new Gson();
                Endereco endereco = gson.fromJson(resp, Endereco.class);

                String hora = Hora.obterHoraZona();

                try (FileWriter fw = new FileWriter("cep.log", true)) {
                    fw.write(endereco.toString() + " - " + hora + "\n");
                    System.out.println("Arquivo gravado com sucesso.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (opcao == 2) {
                try (FileReader fr = new FileReader("cep.log");
                     BufferedReader br = new BufferedReader(fr)) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        System.out.println(linha);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            }
            else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scan.close();
    }
}
