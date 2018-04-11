package impl;

import adt.Map;
import adt.Stack;

public class LLStackMap<K, P> implements Map<K, P> {

    private LinkedListStack<KeyValuePair<K, P>> pairs;


    public LLStackMap(){
        pairs = new LinkedListStack<>();
    }

    @Override
    public void define(K key, P value) {
        boolean isDefine = false;
        KeyValuePair<K, P> pair;
        Stack<KeyValuePair> temp = new LinkedListStack<>();

        for(int i =0; i < pairs.getSize(); i++){
            try{
                pair = pairs.pop();
                if(pair.getKey() == key){
                    pair = new KeyValuePair(key, value);
                    isDefine = true;
                }
                temp.push(pair);
            } catch (Exception ex){
            }
        }
        while(temp.getSize() != 0){
            try{
                pairs.push(temp.pop());
            } catch (Exception ex){
            }
        }
        if(isDefine == false) pairs.push(new KeyValuePair<>(key, value));
    }

    @Override
    public P getValue(K key) {
        P res = null;
        KeyValuePair<K, P> pair;
        Stack<KeyValuePair> temp = new LinkedListStack<>();

        for(int i =0; i < pairs.getSize(); i++){
            try{
                pair = pairs.pop();
                if(pair.getKey() == key){
                    res = pair.getValue();
                }
                temp.push(pair);
            } catch (Exception ex){
            }
        }
        while(temp.getSize() != 0){
            try{
                pairs.push(temp.pop());
            } catch (Exception ex){
            }
        }
        return res;
    }

    @Override
    public P remove(K key) {
        P res = null;
        KeyValuePair<K, P> pair;
        Stack<KeyValuePair> temp = new LinkedListStack<>();

        for(int i =0; i < pairs.getSize(); i++){
            try{
                pair = pairs.pop();
                if(pair.getKey() == key){
                    res = pair.getValue();
                    break;
                }
                temp.push(pair);
            } catch (Exception ex){
            }
        }
        while(temp.getSize() != 0){
            try{
                pairs.push(temp.pop());
            } catch (Exception ex){
            }
        }
        return res;
    }

    @Override
    public KeyValuePair<K, P> removeAny() throws Exception {
        if(pairs.getSize() == 0) throw new Exception("The map is empty");
        return pairs.pop();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListStack<>();
    }

    @Override
    public String toString(){
        return pairs.toString();
    }
}
