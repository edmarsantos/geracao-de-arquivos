package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando_celula_existente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\Users\\Edmar\\git\\CriandoArquivoEmJava\\Arquivos\\src\\arquivo\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); //prepara a entrada do arquivo excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//pegando a aba da planilha
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		
		while(linhaIterator.hasNext()) { //enquanto tiver linhas
			Row linha = linhaIterator.next(); //dados da linha
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula + "Valor da Celula alterado");
					
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		
		System.out.println("Planilha Atualizada");

	}

}
