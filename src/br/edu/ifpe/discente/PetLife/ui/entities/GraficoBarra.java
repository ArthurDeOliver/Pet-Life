package br.edu.ifpe.discente.PetLife.ui.entities;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JPanel {
	public GraficoBarra(double totalRacoes, double totalMedicamentos, double totalVacinas, double totalRecursos) {
		CategoryDataset dataset = createDataSet(totalRacoes, totalMedicamentos, totalVacinas, totalRecursos);
		JFreeChart grafico = createGrafico(dataset);
		ChartPanel graficoPanel = new ChartPanel(grafico);		
		graficoPanel.setPopupMenu(null);
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

		  CategoryPlot plot = graficoBarra.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        renderer.setSeriesPaint(0, Color.gray); // Cor das barras	     
	        return graficoBarra;
		
	}
}