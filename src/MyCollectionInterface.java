/**
 * 
 * @author 
 *
 */
public interface MyCollectionInterface {
	/**
	 * 
	 * @param <T>
	 * @param item
	 * @return
	 */
	public <T> boolean contains(T item);
	/**
	 * 
	 * @param <T>
	 * @param item
	 * @return
	 */
	public <T> boolean add(T item);
	/**
	 * 
	 * @param <T>
	 * @param item
	 * @return
	 */
	public <T> boolean remove(T item);
	/**
	 * 
	 * @return
	 */
	public String[] toArray();
	
}
