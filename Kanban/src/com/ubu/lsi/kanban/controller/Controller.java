package com.ubu.lsi.kanban.controller;
import java.util.*;

import com.ubu.lsi.kanban.persistence.*;

public interface Controller<E> {
	
	Collection<E> getList();
	E getElement(int index);

}
