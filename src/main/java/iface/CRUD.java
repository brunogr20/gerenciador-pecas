package iface;

import java.util.List;

public interface CRUD<Entity>{
	
	List<Entity> getList(String filter);
	boolean create(Entity entity);
	boolean update(Entity entity);
	boolean delete(Entity entity);
	
}
