/**
 * List.java
 * @author 
 *
 */
public class List<T> implements MyCollectionInterface<Object> {
	
	private final int SIZE_LIMIT = 100; // List size capacity
	private Object[] objectList;		// Array of objects
	private int arraySize;				// Size of the array free of null values
	
	/**
	 * Default constructor. Instantiates both objectList and 
	 * arraySize. 
	 * 
	 */
	public List() {
		this.objectList = new Object[SIZE_LIMIT];
		this.arraySize = 0;	
	} // End constructor
	
	/**
	 * Searches the array for the first null value and adds newItem 
	 * at the first occurrence of a null value.
	 * 
	 * @param newItem : item to be added
	 * @return true if successful, false if not
	 */
	public boolean add(Object newItem) {
		boolean canAdd = false;
		int index = 0;
		
		for (Object item : this.objectList) {
			if (item == null) {
				this.objectList[index] = newItem;
				canAdd = true;
				break;
			} // End if
			index++;
		} // End for
		return false;
	} // End add

	/**
	 * Removes the first non-null item in the list.
	 *  
	 * @return true if successful, false if not
	 */
	public Object remove() {
		Object removedObject = null;
		int index = 0;
		
		for (Object item : this.objectList) {
			if (item != null) {
				removedObject = this.objectList[index];
				this.objectList[index] = null;
				break;
			} // End if
			index++;
		} // End for
		return removedObject;
	} // End remove

	/**
	 * Searches the array for item anEntry and removes the first 
	 * occurance of it. 
	 * 
	 * @param anEntry : entry to be removed
	 * @return true if the removal was successful, false if not. 
	 */
	public boolean remove(Object anEntry) {
		boolean canRemove = false; 
		int index = 0;
	
		for (Object item : this.objectList) {
			if (item == anEntry) {
				this.objectList[index] = null;
				canRemove = true;
				break;
			} // End if
			index++;
		} // End for
		return false;
	} // End remove

	/**
	 * Clears all non-null items in the list, creating an empty list
	 */
	public void clear() {
		
		for (int i = 0; i < this.arraySize; i++) {
			if (this.objectList[i] != null){
				this.objectList[i] = null;
			} // End if
		} // End for
	} // End clear

	/**
	 * Counts all non-null items in objectList
	 * @return number of non null items in objectList
	 */
	public int getCurrentSize() {
		
		for (Object item : this.objectList) {
			if (item != null) {
				this.arraySize++;
			} // End if
		} // End for
		
		return this.arraySize;
	} // End getCurrentSize

	/**
	 * Checks if all values in the list of objects are null. 
	 * @return true, if empty, false if not
	 */
	public boolean isEmpty() {
		this.getCurrentSize(); // Updates the size of the array 		
		return this.arraySize == 0;
	} // End isEmpty

	/**
	 * Counts the number of times an entry is found in a list.
	 * @param anEntry : Entry to find 
	 * @return number of times anEntry appears in objectList
	 */
	public int getFrequencyOf(Object anEntry) {
		int frequency = 0; // Number of times anEntry appears
		
		for (Object item : this.objectList) {
			if (item == anEntry) {
				frequency++;
			} // End if
		} // End for
		return frequency;
	} // End getFrequencyOf

	/**
	 * Searches the array for parameter anEntry.
	 * @return true, if the item is found, false if not. 
	 */
	public boolean contains(Object anEntry) {
		boolean inArray = false;
		
		for (Object item : this.objectList) {
			if (item == anEntry) {
				inArray = true;
				break;
			} // End if
		} // End for
		return inArray;
	} // End contains

	/**
	 * Generates an array by first filtering all null values out of objectList, assigning the 
	 * non null values to a new array, and then returning that array. 
	 * 
	 * @return Object[] : Returns null if it is empty or the filtered array if it is not. 
	 */
	public Object[] toArray() {
		this.getCurrentSize();	// Updates the current size of the list. 
		Object[] returnArray;	// Object array to be returned. Stores no null values
		int nonNullIndex = 0;	// Number of non null values in the array
		
		if (this.arraySize == 0) {
			return null;
			
		} else {
			returnArray = new Object[this.arraySize];
			
			for (Object item : this.objectList) {
				if (item != null) {
					returnArray[nonNullIndex] = item;
					nonNullIndex++;
				} // End if
			} // End for
			return returnArray;	
		} // End else
	} // End toArray
} // End list
