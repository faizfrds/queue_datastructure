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

			if (!hasNext()) throw new NoSuchElementException("No more files");
			return fileQueue.dequeue();
			
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
