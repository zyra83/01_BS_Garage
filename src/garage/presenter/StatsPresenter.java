package garage.presenter;

import java.util.List;

import garage.model.entities.Marque;
import garage.model.facade.FacadeFactory;
import garage.model.facade.IFacadeMetier;
import garage.model.facade.exceptions.FacadeMetierException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class StatsPresenter {

	IFacadeMetier fm = FacadeFactory.fabriquerFacadeMetier();

	@FXML
	private PieChart piechart;

	@FXML
	public void initialize() {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		// Je recup les marques
		List<Marque> lstMarques;
		try {
			lstMarques = fm.listerLesMarques();
			// par marque
			for (Marque marque : lstMarques) {
				// Je veux le nb de voitures
				long nb = fm.compterVoituresParMarque(marque);
				PieChart.Data p = new PieChart.Data(marque.getNom(), nb);
				pieChartData.add(p);
				log.info(String.format("Marque: %s -> nb:%s", marque.getNom(), nb));
			}
			piechart.setData(pieChartData);
		} catch (FacadeMetierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}