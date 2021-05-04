package arquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		File file = new File("C:\\Users\\Edmar\\git\\CriandoArquivoEmJava\\Arquivos\\src\\arquivo\\arquivo_excel.xls");

		if(!file.exists()) {
			file.createNewFile();
		}
		
		
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
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //utilizado para escrever a planilha
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilha de Pessoas Jdev Treinamento"); //criar a planilha
		
		int numeroLinha = 0;
		for(Pessoa p : pessoas) {
			Row linha = linhaPessoa.createRow(numeroLinha ++); //criando a linha na planilha
			
				int celula= 0;
				
				Cell cellNome = linha.createCell(celula ++); //celula 1
				cellNome.setCellValue(p.getNome());
				
				Cell celemail = linha.createCell(celula ++);//celula 2
				celemail.setCellValue(p.getEmail());
				
				Cell celidade = linha.createCell(celula ++);//celula 3
				celidade.setCellValue(p.getIdade());
						
						
		}//final da planilha
		
		FileOutputStream saida = new FileOutputStream(file); //saida do arquivo
		hssfWorkbook.write(saida); // escreve a planilha
		saida.flush();
		saida.close();
		
		System.out.println("Planilha Criada");
	}

}
