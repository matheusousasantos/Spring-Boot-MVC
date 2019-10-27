package curso.springboot.controller;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component //Componente do Spring
public class ReportUtil implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	Retorna nosso PDF em Byte para dowload no navegador
	public byte[] gerarRelatorio(List listDados, String relatorio, 
			ServletContext servletContext) throws Exception {
		
//		Cria a lista de dados para o relatório com nossa lista de objetos para imprimir 
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listDados);
		
//		Carregar o caminho do arquivo Jasper Compilado
		String caminhoJasper = servletContext.getRealPath("relatorios") + File.separator + relatorio + ".jasper";
		
//		A URL fica assim: relatorios/pessoa.jasper
		
//		Gera/Carrega o arquivo Jasper passando os dados
		JasperPrint impressoraJasper = JasperFillManager.fillReport(caminhoJasper, new HashMap(), jrbcds);
				
//		Caminho
//		Lista de Map
//		Fonte de dados
		
//		Será montado o relatório
		
		return JasperExportManager.exportReportToPdf(impressoraJasper);
		
	}

}
