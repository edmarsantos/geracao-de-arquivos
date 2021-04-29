package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		
		//PASSAR CAMINHO E SALVAR EM UMA VARIAVEL
		FileInputStream entradaArquivo =
				new FileInputStream(new File("C:\\Users\\Edmar\\git\\CriandoArquivoEmJava\\Arquivos\\src\\arquivo\\arquivo.txt"));
		
		//LEITURA DO ARQUIVO PARA UTILIZAR A FRENTE E A CODIFICAÇÃO UTILIZADA NO CASO "UTF-8"
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		
		//while para ler linha a linha enquanto houver registro
		while(lerArquivo.hasNext()) {
			
			//variavel para lr linha a linha
			String linha = lerArquivo.nextLine();
						
			//if para linha for null ou vazia ele nao vai mostrar server para eliminar possivies sujeiras do layout
			if(linha!=null && !linha.isEmpty()) {
				System.out.println(linha);	
			}
				
			
		}
		
		
		

	}

}
