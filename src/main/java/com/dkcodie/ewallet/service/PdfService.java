package com.dkcodie.ewallet.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public ByteArrayInputStream generatePdfReport() {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Title
            document.add(new Paragraph("AI-Generated PDF Report"));
            document.add(new Paragraph("User Insights and Recommendations"));
            document.add(new Paragraph("Generated on: " + java.time.LocalDate.now()));
            document.add(new Paragraph(" ")); // Add space

            // Table for data presentation
            PdfPTable table = new PdfPTable(3); // 3 columns
            table.setWidthPercentage(100); // Set table width to 100%
            table.setSpacingBefore(10f); // Add space before table
            table.setSpacingAfter(10f); // Add space after table

            // Table Header
            table.addCell("Transaction ID");
            table.addCell("Amount");
            table.addCell("Date");

            // Here you can add your data (replace this with actual transaction data)
            for (int i = 1; i <= 5; i++) {
                table.addCell(String.valueOf(i)); // Transaction ID
                table.addCell(String.format("$%.2f", Math.random() * 100)); // Amount
                table.addCell(java.time.LocalDate.now().toString()); // Date
            }

            document.add(table); // Add table to document
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
