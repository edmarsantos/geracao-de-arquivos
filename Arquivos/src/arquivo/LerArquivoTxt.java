package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		
		//PASSAR CAMINHO E SALVAR EM UMA VARIAVEL
		FileInputStream entradaArquivo =
				new FileInputStream(new File("C:\\Users\\Edmar\\git\\CriandoArquivoEmJava\\Arquivos\\src\\arquivo\\arquivo.txt"));
		
		//LEITURA DO ARQUIVO PARA UTILIZAR A FRENTE E A CODIFICAÇÃO UTILIZADA NO CASO "UTF-8"
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		//criando lsta de pessoas para mais a frente utilizar para adicionar as pessoas do regsitro lido
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		
		//while para ler linha a linha enquanto houver registro
		while(lerArquivo.hasNext()) {
			
			//variavel para lr linha a linha
			String linha = lerArquivo.nextLine();
						
			//if para linha for null ou vazia ele nao vai mostrar server para eliminar possivies sujeiras do layout
			if(linha!=null && !linha.isEmpty()) {
				//System.out.println(linha);
				String[] dados = linha.split("\\;");
				
				//capturando os dados do registro
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[2]);
				pessoa.setIdade(Integer.parseInt(dados[1]));
				
				//adicionando na lista de pessoas
				pessoas.add(pessoa);
				
			}
				
			
		}
		
		for(Pessoa pessoa : pessoas) //com esse for pode salvar no banco de dados ou gerar email
		System.out.println(pessoa);
		

	}

}
