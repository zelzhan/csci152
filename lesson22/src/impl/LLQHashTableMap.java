package impl;
import adt.HashTableMap;
import adt.Map;

public class LLQHashTableMap<K, V> implements HashTableMap<K, V>{
    private LinkedListQueue<KeyValuePair<K, V>>[] hashtable;
    private int size, buckets;

    public LLQHashTableMap(int buckets){
        hashtable = new LinkedListQueue[buckets];
        this.buckets = buckets;
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index > buckets || index < 0) throw new Exception("Out of range");
        if(hashtable[index] != null) return hashtable[index].getSize();
        return 0;
    }

    @Override
    public double getLoadFactor() {
        return size/buckets;
    }

    @Override
    public double getBucketSizeStandardDev() {
        double mean, sum2 = 0;
        mean = size/buckets;
        for(int j = 0; j<buckets; j++){
            if(hashtable[j] != null) sum2+=Math.pow(Math.abs(hashtable[j].getSize() - mean), 2);
            else sum2+=Math.pow(mean, 2);
        }
        return Math.sqrt(sum2/buckets);
    }

    @Override
    public String bucketsToString() {
        String string = "";
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] == null) continue;
            string += hashtable[i].toString() + '\n';
        }
        return string;
    }

    @Override
    public void define(K key, V value) {
        int index = Math.abs(key.hashCode())%buckets;
        if(hashtable[index] == null){
            hashtable[index] = new LinkedListQueue<>();
            hashtable[index].enqueue(new KeyValuePair(key, value));
            size++;
            return;
        }
        for(int i = 0; i < hashtable[index].getSize(); i++){
            try{
                KeyValuePair temp = hashtable[index].dequeue();
                hashtable[index].enqueue(temp);
                if(temp.getKey().equals(key)){
                    temp.setValue(value);
                    return;
                }
            } catch (Exception ex){
            }
        }
    }

    @Override
    public V getValue(K key) {
        int index = Math.abs(key.hashCode())%buckets;
        if(hashtable[index] == null) return null;
        for(int i = 0; i < hashtable[index].getSize(); i++){
            try{
                KeyValuePair<K, V> temp = hashtable[index].dequeue();
                hashtable[index].enqueue(temp);
                if(temp.getKey().equals(key)){
                    return temp.getValue();
                }
            } catch (Exception ex){
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode())%buckets;
        if(hashtable[index] == null) return null;
        for(int i = 0; i < hashtable[index].getSize(); i++){
            try{
                KeyValuePair<K, V> temp = hashtable[index].dequeue();
                if(temp.getKey().equals(key)){
                    size--;
                    return temp.getValue();
                }
                hashtable[index].enqueue(temp);
            } catch (Exception ex){
            }
        }
        return null;
    }

    @Override
    public KeyValuePair removeAny() throws Exception {
        if(size == 0) throw new Exception("Empty");
        for(int i = 0; i < buckets; i++){
            if(hashtable[i].getSize() != 0){
                size--;
                return hashtable[i].dequeue();
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        hashtable = new LinkedListQueue[buckets];
        this.buckets = buckets;
    }

    @Override
    public String toString(){
//        String string = "";
//        int temp = size;
//        LinkedListQueue queue;
//        while(temp != 0){
//            for(int i = 0; i < ; i++){
//                if(hashtable[i] == null) continue;
//                string += hashtable[i].toString() + '\n';
//            }
//            temp--;
//        }
        return bucketsToString();
    }
}
