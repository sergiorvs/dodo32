package app.dominio;

public interface BaseEntity<K> {
	K getId();
	void setId(K id);
}
