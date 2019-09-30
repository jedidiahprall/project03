/**
 * 
 * @author 
 *
 */

public class List implements MyCollectionInterface {
	
	// TODO something here. 
	/**
	 * 
	 * @param type
	 */
	public List(char type) {
		assert (type == 'S') || (type == 'G');
		
		if (type == 'S') {
			// TODO Student object list
		} else {
			// TODO GradeItem object list
		}
	}
	
	/**
	 *
	 */
	public <T> boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	public <T> boolean add(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	public <T> boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	public String[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
