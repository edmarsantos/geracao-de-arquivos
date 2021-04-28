package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoEmJava {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("edmar@redekrill.com");
		pessoa1.setIdade(30);
		pessoa1.setNome("Edmar");
		
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("jose@redekrill.com");
		pessoa2.setIdade(30);
		pessoa2.setNome("jose");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("ze@redekrill.com");
		pessoa3.setIdade(30);
		pessoa3.setNome("ze");
		
		//lista de pessoas
		List<Pessoa> pessoas =new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("C:\\Users\\Edmar\\eclipse-workspace_202103\\Arquivos\\src\\arquivo\\arquivo.txt");
		
		if (arquivo.exists()) {
			arquivo.createNewFile(); //criar arquivo
				}
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);//dizer onde eu quro escrever
		
		escrever_no_arquivo.write("meu texto no arquivo");//escrevendo no arquivo
		escrever_no_arquivo.write("\n");//escrevendo no arquivo
		escrever_no_arquivo.write("MInha segunda linha");//escrevendo no arquivo
		
		//forma usando if
		for(int i =3;i<=10;i++) { //foi eu que iniciei em 3
			escrever_no_arquivo.write("Texto da minha Linha " + i + "\n");
		}
		
		//forma uzando o for para pegar todos os registro dentro da classe
		for(Pessoa p :pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getIdade() + ";" + p.getEmail() + "\n");	
			}
		
		
		escrever_no_arquivo.flush(); //para persistir essas alterações
		escrever_no_arquivo.close();//fechar o arquivo

	}

}
