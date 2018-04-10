package impl;

import adt.Map;

public class LLQueueMap<K, P> implements Map<K, P>{

    private LinkedListQueue<KeyValuePair<K, P>> pairs;

    public LLQueueMap(){
        pairs = new LinkedListQueue<>();
    }

    @Override
    public void define(K key, P value) {
        KeyValuePair<K, P> pair;
        for(int i =0; i < pairs.getSize(); i++){
            try{
                pair = pairs.dequeue();
                if(pair.getKey() == key){
                    pairs.enqueue(new KeyValuePair(key, value));
                    return;
                }
                pairs.enqueue(pair);
            } catch (Exception ex){
            }
        }
        pairs.enqueue(new KeyValuePair(key, value));
    }

    @Override
    public P getValue(K key) {
        KeyValuePair<K, P> pair;
        for(int i =0; i < pairs.getSize(); i++){
            try{
                pair = pairs.dequeue();
                pairs.enqueue(pair);
                if(pair.getKey() == key) return pair.getValue();
            } catch (Exception ex){
            }
        }
        return null;
    }

    @Override
    public P remove(K key) {
        KeyValuePair<K, P> pair;
        for(int i =0; i < pairs.getSize(); i++){
            try{
                pair = pairs.dequeue();
                if(pair.getKey() == key) return pair.getValue();
                pairs.enqueue(pair);
            } catch (Exception ex){
            }
        }
        return null;
    }

    @Override
    public KeyValuePair<K, P> removeAny() throws Exception {
        if(pairs.getSize() == 0) throw new Exception("The map is already empty");
        return pairs.dequeue();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue<>();
    }

    @Override
    public String toString(){
        return pairs.toString();
    }
}
