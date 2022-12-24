package utilities;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.EntitiesUsuario;

// TODO: Auto-generated Javadoc
/**
 * The Class GerarPdf.
 */
public class GerarPdf {

	/**
	 * Pdf.
	 *
	 * @param lista    the lista
	 * @param response the response
	 */
	public static void pdf(ArrayList<EntitiesUsuario> lista, HttpServletResponse response) {

		Document documento = new Document();

		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de contatos:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col4 = new PdfPCell(new Paragraph("E-mail"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			for (EntitiesUsuario x : lista) {
				tabela.addCell(x.getNome());
				tabela.addCell(x.getCpf());
				tabela.addCell(x.getTelefone());
				tabela.addCell(x.getEmail());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}
