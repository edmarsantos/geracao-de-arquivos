package arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiLeitura {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream entrada = new FileInputStream("C:\\Users\\Edmar\\git\\CriandoArquivoEmJava\\Arquivos\\src\\arquivo\\arquivo_excel.xls");//pega o arquivo excel
	
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); //prepara o arqivo excel para leitura
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); //Pega a primeira aba do arquivo excel
		
		Iterator<Row> linhaInterator = planilha.iterator();//percorrer linhas
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(linhaInterator.hasNext()) { //enquanto estiver linha no arquivo excel ele percorre
			
			Row linha = linhaInterator.next();//dados da linha
			
			Iterator<Cell> celula = linha.iterator(); //prepara o arquivo para percorrer as celulas daquela linha
			
			Pessoa pessoa = new Pessoa();
			
			while(celula.hasNext()) { //percorre as celulas
				Cell cell = celula.next(); 
				
				switch (cell.getColumnIndex()) { //pega o index para percorre o case
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
                     pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                     break;
				} 
				
				
				
			}//fim das celulas
			
			pessoas.add(pessoa);		
			
		}//fim das linhas
		entrada.close(); //fim da leitura
		
		for(Pessoa pessoa:pessoas) {//for para retornar os registros poderia ser uma seria de coisas 
			System.out.println(pessoa);
		}
	

	}

}
