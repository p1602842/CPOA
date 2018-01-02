package model;

public abstract class DAO<T> {

	public abstract T trouver(Object id);

	public abstract T creer(T obj);

	public abstract T mettreAJour(T obj);

	public abstract void delete(T obj);
}
