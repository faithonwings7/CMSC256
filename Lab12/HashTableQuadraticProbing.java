package cmsc256;

public class HashTableQuadraticProbing<K, V> extends HashTableOpenAddressing<K, V> {

    public int quadraticProbe(int index, K keyIn) {
        boolean found = false;
        int removedStateIndex = -1; // Index of first removed location
        int i = 0;
        if (table[index] == null) // The hash index is available
            return index;
        while (!found && table[index] != null) {
            if (table[index].isIn()) {
                if (keyIn == (table[index].getKey()))
                    found = true; // Key found
                else // Follow probe sequence
                    index = (index + i * i) % table.length;
                    i++;
            } else { // Skip entries that were removed
                // Save index of first location in removed state
                if (removedStateIndex == -1)
                    removedStateIndex = index;
                index = (index + i * i) % table.length;
                i++;
            }
        }
        if (found || (removedStateIndex == -1))
            return index; // Index of either key or null
        else
            return removedStateIndex; // Index of an available location
    }

    @Override
    public V put(K keyIn, V valueIn) {

        if (keyIn == null || valueIn == null) {
            throw new IllegalArgumentException("nulls not allowed");
        }

        V oldValue = null;

        Entry newEntry = new Entry(keyIn, valueIn);

        int index = super.getHashIndex(keyIn);

        index = quadraticProbe(index, keyIn);

        if (table[index] == null || table[index].isRemoved()) {
            table[index] = newEntry;
            numEntries++;
        } else {
            oldValue = table[index].getValue();
            table[index] = newEntry;
        }

        if (isFull()) {
            enlargeHashTable();
        }

        return oldValue;
    }

    @Override
    public V getValue(K keyIn) {

        int index = super.getHashIndex(keyIn);
        index = quadraticProbe(index, keyIn);
        Entry<K, V> item = table[index];
        if ((item != null) && item.isIn()){
            return item.getValue();
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        boolean found = false;
        int index = getHashIndex(key);
        index = quadraticProbe(index, key);

        while (!found && table[index] != null) {
            if (table[index].isIn()) {
                if (key == table[index].getKey()) {
                    found = true; // Key found
                }
            }
        }

        return found;
    }

    @Override
    public V remove(K keyIn) {
        V removedValue = null;
        boolean found = false;

        // calculate the initial index
        int index = super.getHashIndex(keyIn);

        // find the location of the key using linear probing
        index = quadraticProbe(index, keyIn);

        // if Key found; flag entry as removed and return its value
        while (!found && table[index] != null) {
            if (table[index].isIn()) {
                if (keyIn == table[index].getKey()) {
                    found = true; // Key found
                    removedValue = table[index].getValue();
                    table[index].setToRemoved();
                    numEntries--;
                }
            }
        }
    // else key not found; return removedValue
    return removedValue;
    }
}
