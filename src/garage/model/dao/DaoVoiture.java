package garage.model.dao;

import java.util.List;

public interface DaoVoiture<T, K> extends Dao<T, K> {

	public List<T> readByModele(K modele);

	public List<T> readAllSortByPuissance();

}
