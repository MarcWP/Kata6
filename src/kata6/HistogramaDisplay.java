/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author usuario
 */
public class HistogramaDisplay <T> extends ApplicationFrame{
     private final Histogram<T> histo;
     private final String nameEjeX;

    public HistogramaDisplay(Histogram<T> histo, String nameEjeX) {
        super("HISTOGRAMA");
        this.histo = histo;
        this.nameEjeX=nameEjeX;
        setContentPane(createPanel());
        pack();
    }

    private ChartPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 450));
        return chartPanel;
    }
    private JFreeChart createChart(DefaultCategoryDataset dataset ){
        JFreeChart chart = ChartFactory.createBarChart(
                    null,
                    nameEjeX,
                    "NUMERO",
                    dataset,
                    PlotOrientation.VERTICAL,
                    false,
                    false,
                    false);
            return chart;

        }
    

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (T key : histo.keySet()) {
            dataset.addValue(histo.get(key), "", (Comparable) key);

        }
        return dataset;
    }

    public void execute() {
        setVisible(true);
    }
}
