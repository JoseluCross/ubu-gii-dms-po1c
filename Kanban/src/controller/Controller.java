package controller;
import java.util.*;
import persistence.*;

public interface Controller<E> {
	
	Collection<E> getList();
	E getElement(int index);

}
