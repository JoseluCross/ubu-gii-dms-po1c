package view;
import java.util.Collection;

import model.*;

public interface ViewRequisito extends Mostrable<Requisito>{
	public boolean crearRequisito();
	public void mostrarRequisitos(Collection<Requisito> requisitos);
	public void mostrarReducido(Requisito requisito);
}
