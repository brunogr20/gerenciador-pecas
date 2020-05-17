package iface;

import java.util.List;

public interface CRUD<Entity>{
	
	List<Entity> getList(String filter);
	Entity find(Entity entity);
	boolean create(Entity entity);
	boolean update(Entity entity);
	boolean delete(Entity entity);
	
}
