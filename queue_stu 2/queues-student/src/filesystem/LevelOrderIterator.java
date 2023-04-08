package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.Queue;


/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem.
 */
public class LevelOrderIterator extends FileIterator<File> {
	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */

	private Queue<File> fileQueue;
	private int i = -1;
	private File dequeued;
	private File [] newFile;
	private boolean dir = false;

	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
        	// TODO 1		
			fileQueue = new Queue<File>();
			if (!rootNode.exists()) throw new FileNotFoundException("Root node does not exist");
			fileQueue.enqueue(rootNode);
	}
	
	@Override
	public boolean hasNext() {
        	// TODO 2
            return (!fileQueue.isEmpty());
	}

	@Override
	public File next() throws NoSuchElementException {
        	// TODO 3

			if (!hasNext()) throw new NoSuchElementException();
			
			dequeued = fileQueue.dequeue();
			
			if (dequeued.isDirectory()){

				if (!hasNext()) newFile = dequeued.listFiles();

				if (newFile.length == 0){
					return dequeued;
				}
				else{
					//i++;
					for (int j = 0; j < newFile.length; j++){

						fileQueue.enqueue(newFile[j]);
					}
				}
				
			}
			
			return dequeued;

			
	}


	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
