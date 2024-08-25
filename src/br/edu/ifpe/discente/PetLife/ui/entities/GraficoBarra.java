package br.edu.ifpe.discente.PetLife.ui.entities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JPanel {
	public GraficoBarra(double totalRacoes, double totalMedicamentos, double totalVacinas, double totalRecursos) {
		CategoryDataset dataset = createDataSet(totalRacoes, totalMedicamentos, totalVacinas, totalRecursos);
		JFreeChart grafico = createGrafico(dataset);
		ChartPanel graficoPanel = new ChartPanel(grafico);		
		// graficoPanel.setPopupMenu(null);
		graficoPanel.setRangeZoomable(false);  // Desativa o zoom no eixo Y
		graficoPanel.setDomainZoomable(false); // Desativa o zoom no eixo X
		
		this.setLayout(new java.awt.BorderLayout());
		this.add(graficoPanel, java.awt.BorderLayout.CENTER);		 
	}

	private CategoryDataset createDataSet(double racoes, double medicamentos, double vacinas, double total) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(racoes, "Recursos", "Rações");
		dataset.setValue(medicamentos, "Recursos", "Medicamentos");
		dataset.setValue(vacinas, "Recursos", "Vacinas");
		dataset.setValue(total, "Recursos", "Total");

		return dataset;
	}

	private JFreeChart createGrafico(CategoryDataset dataset) {
		JFreeChart graficoBarra = ChartFactory.createBarChart("Gastos com Recursos", "Recursos", "Valor Gasto", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		    float hue = 240.0f / 360.0f; // Paleta do HSV = 240 
	        float saturation = 0.0f;    // Paleta do HSV = 0
	        float brightness = 0.94f;   // Paleta do HSV = 94
		  graficoBarra.setBackgroundPaint(Color.getHSBColor(hue, saturation, brightness));
		  TextTitle title = graficoBarra.getTitle();
		    title.setFont(new Font("Tahoma Negrito", Font.PLAIN, 18)); //Muda o tamanho e a fonte do titulo.
			  
		  CategoryPlot plot = graficoBarra.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        renderer.setSeriesPaint(0, Color.gray); // Cor das barras
	          float hue2 = 0.0f;
			  float saturation2 = 0.0f;
			  float brightness2 = 0.80f;
	         plot.setBackgroundPaint(Color.getHSBColor(hue2,saturation2,brightness2));

	        return graficoBarra;
		
	}
}